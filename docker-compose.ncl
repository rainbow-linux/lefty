{
  version = "3.8",
  services = {
    app = {
      image = "lefty:latest",
      container_name = "sunshine-lefty",
      stdin_open = true,
      tty = true
    }
  }
}