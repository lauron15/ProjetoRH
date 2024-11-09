# Etapa de build
FROM maven:3.8.5-openjdk-17 AS build

# Copia o código-fonte e o arquivo pom.xml para o diretório de trabalho do container
COPY src /app/src
COPY pom.xml /app

# Define o diretório de trabalho como /app
WORKDIR /app

# Executa o build do projeto para gerar o arquivo JAR
RUN mvn clean install

# Etapa final: criando o container para rodar o aplicativo
FROM openjdk:17-jdk-alpine

# Copia o arquivo JAR gerado da etapa de build para o container final, mantendo o nome original
COPY --from=build /app/target/AppRh-0.0.1-SNAPSHOT.jar /app/AppRh-0.0.1-SNAPSHOT.jar

# Expõe a porta 8080 (ou outra porta que sua aplicação utiliza)
EXPOSE 8080

# Define o comando para executar o JAR com o nome original
ENTRYPOINT ["java", "-jar", "/app/AppRh-0.0.1-SNAPSHOT.jar"]
