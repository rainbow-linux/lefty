-- Define the project
set_project("lefty")

-- Define the version
set_version("1.0")

-- Add a custom target to build the Docker image
target("docker")
    set_kind("phony")
    on_run(function (target)
        local image_name = "lefty"
        local tag = "latest"
        os.exec("docker build -t %s:%s .", image_name, tag)
        os.exec("nickel export -f yaml -o docker-compose.yml docker-compose.ncl")
    end)

-- Default target
target("build")
    set_kind("phony")