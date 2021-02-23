FROM openjdk:11.0.10-oraclelinux7
COPY "./target/Ejercicio1-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 4000
ENTRYPOINT ["java","-jar","app.jar"]