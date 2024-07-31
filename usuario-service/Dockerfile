# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Copia el archivo JAR al contenedor
COPY target/usuario-service-0.0.1-SNAPSHOT.jar /usr/app/usuario-service.jar

# Establece el directorio de trabajo
WORKDIR /usr/app

# Expone el puerto en el que la aplicación estará escuchando
EXPOSE 8084

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "usuario-service.jar"]
