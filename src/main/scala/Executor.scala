package gay.rainbowlinux.infra.cd.lefty

enum ContainerRuntime {
  SystemdNSpawn,
  Docker,
  Podman,
  LXC
}

/// defines an execution engine that loads a Leftyfile.scala
class Executor(val runtime: ContainerRuntime) {
  def run(pipeline: Pipeline) {

  }
}
