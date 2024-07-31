# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Copia el archivo JAR al contenedor
COPY target/apigateway-0.0.1-SNAPSHOT.jar /usr/app/apigateway.jar

# Establece el directorio de trabajo
WORKDIR /usr/app

# Expone el puerto en el que la aplicación estará escuchando
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "apigateway.jar"]
