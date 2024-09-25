package gay.rainbowlinux.infra.cd.lefty

import scala.language.postfixOps

/// defines an execution engine that loads a Leftyfile.scala
class Executor {
  def run(pipeline: Pipeline) : Unit = {
    for (stage <- pipeline stages) {
      for (step <- stage steps) {
        step run
      }
    }
  }
}
