FROM amazoncorretto:17

WORKDIR /app

COPY target/api-0.0.1-SNAPSHOT.jar /app/app.jar

#comando de inicializacao da aplicacao quando o conteiner for iniciado
CMD ["java", "-jar", "app.jar"]