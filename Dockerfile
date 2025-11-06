FROM eclipse-temurin:17-jdk-jammy

COPY target/employee.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
