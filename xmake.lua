-- Define the project
set_project("lefty")

-- Define the version
set_version("0.1.0")

-- for Docker image
target("docker")
    set_kind("phony")
    on_run(function (target)
        local image_name = "lefty"
        local tag = "0.1.0"
        os.exec("docker build -t %s:%s .", image_name, tag)
    end)

-- for Podman users
target("podman")
   set_kind("phony")
   on_run(function (target)
      local image_name = "lefty"
      local tag = "0.1.0"
      os.exec("podman build -t %s:%s .", image_name, tag)
   )

-- Docker compose file generator
target("compose")
    set_kind("phony")
    on_run(function (target)
        os.exec("nickel export -f yaml -o docker-compose.yml docker-compose.ncl")
    end)

-- Default target
target("build")
    set_kind("phony")
