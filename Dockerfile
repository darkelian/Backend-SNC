# Etapa de compilación con JDK 23 y Maven instalado manualmente
FROM eclipse-temurin:23 AS build

WORKDIR /app

# Instalar Maven manualmente (última versión estable)
RUN apt update && apt install -y maven

# Copiar el archivo pom.xml y resolver dependencias
COPY backend_snc/pom.xml ./
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar la aplicación
COPY backend_snc/src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución con JDK 23
FROM eclipse-temurin:23-jre

WORKDIR /app

# Copiar el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]


