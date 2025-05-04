FROM openjdk:25-ea-4-jdk-oraclelinux9

WORKDIR /app

COPY target/task2.jar task2.jar

EXPOSE 8695

ENTRYPOINT ["java", "-jar", "task2.jar"]
