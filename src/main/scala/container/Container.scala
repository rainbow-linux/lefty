package gay.rainbowlinux.infra.cd.lefty;

case class Container(val name: String) {
  def init(rootfs: String): Unit = {
    os.proc("systemd-nspawn", s"-D $rootfs", "--boot").call()
  }
}
