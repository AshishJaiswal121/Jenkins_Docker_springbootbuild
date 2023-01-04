# Docker Build Stage

FROM openjdk:11
COPY  target/springboot-application.jar springboot-application.jar
ENTRYPOINT ["java","-jar","/springboot-application.jar"]