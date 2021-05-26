# stage 1
FROM maven:3.8.1-openjdk-15 as maven_builder

WORKDIR /usr/pbl3

COPY ./pom.xml .

RUN mvn dependency:go-offline -B

COPY ./src ./src

RUN mvn package

# stage 2
FROM openjdk:11.0.4-jre-slim

WORKDIR /usr/pbl3

COPY --from=maven_builder /usr/pbl3/target/dependency/webapp-runner.jar .
COPY --from=maven_builder /usr/pbl3/target/*.war .

CMD ["java", "-jar", "./webapp-runner.jar", "PBL3Servlet-1.0-SNAPSHOT.war"]