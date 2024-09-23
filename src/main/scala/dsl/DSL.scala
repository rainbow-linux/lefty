package gay.rainbowlinux.infra.cd.lefty;

// Represents the entire pipeline
case class Pipeline(stages: List[Stage] = Nil) {
  def stage(stage: Stage): Pipeline = Pipeline(stages :+ stage)
  def run(): Unit = stages.foreach(_.run())
}

// Represents a stage in the CI pipeline
case class Stage(name: String, steps: List[Step] = Nil) {
  def step(step: Step): Stage = Stage(name, steps :+ step)
  def run(): Unit = {
    println(s"Running stage: $name")
    steps.foreach(_.run())
  }
}

// Represents a step in a stage
case class Step(name: String, action: () => Unit) {
  def run(): Unit = {
    println(s"  Running step: $name")
    action()
  }
}

// A method to simulate shell commands (for demonstration)
object Shell{
  def shell(command: String): Unit = {
    println(s"    Executing: $command")
  }
}

object DSL {
  // Syntax sugar: allows defining stages and steps with cleaner syntax
  implicit class PipelineOps(pipeline: Pipeline) {
    def |(stage: Stage): Pipeline = pipeline.stage(stage)
  }

  implicit class StageOps(stage: Stage) {
    def |(step: Step): Stage = stage.step(step)
  }

  implicit class StepOps(name: String) {
    def step(action: => Unit): Step = Step(name, () => action)
  }

  implicit class StageStringOps(name: String) {
    def stage(stepsBuilder: => Stage): Stage = Stage(name, stepsBuilder.steps)
  }
}

object Lefty {
  def run(pipeline: Pipeline) : Unit = {
    pipeline run
  }
}
