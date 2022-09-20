FROM amazoncorretto:11-alpine3.15-jdk
WORKDIR /app
# ENV ENV_VAR VALUE # for environmental values.
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","./app.jar"]
