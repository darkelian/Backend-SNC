# Etapa de compilación
FROM openjdk:23-slim AS build

# Analizar la viabilidad del la instalación de Maven

ENV MAVEN_VERSION=3.9.3
ENV MAVEN_HOME=/usr/share/maven
RUN apt-get update && apt-get install -y curl tar && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xz -C /usr/share/ && \
    ln -s /usr/share/apache-maven-${MAVEN_VERSION} ${MAVEN_HOME} && \
    apt-get clean && rm -rf /var/lib/apt/lists/*
ENV PATH=${MAVEN_HOME}/bin:$PATH

WORKDIR /app
COPY pom.xml .
COPY src/ src/

# Compila la aplicación y genera el JAR
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:23-slim

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]
