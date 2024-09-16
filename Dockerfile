# Use an Alpine-based image with OpenJDK
FROM openjdk:17-alpine

# Set the maintainer
LABEL maintainer="info@yigitovski.com"

# Install dependencies: bash, curl, and git (git is required for SBT)
RUN apk add --no-cache bash curl git && \
    # Download and install SBT
    curl -L -o sbt.zip https://github.com/sbt/sbt/releases/download/v1.8.0/sbt-1.8.0.zip && \
    unzip sbt.zip && rm sbt.zip && \
    chmod +x sbt/bin/sbt && \
    mv sbt /usr/local/sbt && \
    ln -s /usr/local/sbt/bin/sbt /usr/local/bin/sbt

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . /app

# Run sbt to download dependencies and compile the project
RUN sbt update && sbt compile

# Set the entry point to run the application
CMD ["sbt", "run"]