# Lefty

Continuous delivery server that uses Scala for its configuration.

```scala
import gay.rainbowlinux.infra.cd.lefty._
import gay.rainbıwlinux.infra.cd.lefty.DSL._

object LeftyFile extends Pipeline {
  Lefty run Pipeline |
    "Build" stage {
        "Install dependencies" step {
            exec "npm install"
        } | "Compile" step {
            exec "npm run build"
        }
    } |

    "Test" stage {
        "Run unit tests" step {
            exec "npm test"
        }
    } |

    "Deploy" stage {
        depends on s"${Lefty host workdir}/deploy.sh" as s"${Lefty workdir}/deploy.sh"
        "Deploy to production" step {
            change into Lefty workdir
            exec s"${Lefty workdir}/deploy.sh"
        }
    } every 10 minutes
}
```

# The goal

The goal is to have a syntax as close to Bash scripts as possible, while also being close to English as much as possible

# Dependencies
- for development:
    - `nickel` (https://nickel-lang.org) for building `docker-compose.yml` with a less insufferable syntax
    - `podman` or `docker` for builds inside the containers
    - `xmake` for the build system
    - `scala` and `sbt`
    - `docker-compose` (optional)
