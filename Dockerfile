FROM adoptopenjdk/openjdk11:latest

ENV ENV_STR=""

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", "${ENV_STR}"]