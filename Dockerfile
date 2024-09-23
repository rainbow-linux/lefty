# Use the Scala Runner Image we made

FROM ghcr.io/sparkles-laurel/scala-on-alpine:0.1.1

# Set the maintainer
LABEL maintainer="info@yigitovski.com"

RUN apk update && apk upgrade

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . /app

# Run sbt to download dependencies and compile the project
RUN sbt --verbose update && sbt --verbose compile

CMD ["sbt", "run"]

