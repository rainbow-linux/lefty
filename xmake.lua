-- Define the project
set_project("lefty")

-- Define the version
set_version("1.0")

-- Add a custom target to build the Docker image
task("docker")
    on_run(function (target)
        local image_name = "lefty"
        local tag = "latest"
        os.exec("docker build -t %s:%s .", image_name, tag)
    end)

-- Default target
target("build")
    set_kind("phony")