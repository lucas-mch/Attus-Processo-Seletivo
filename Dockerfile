FROM amazoncorretto:21
LABEL authors="Lucas"
COPY ./target/attus-processo-seletivo-0.0.1-SNAPSHOT.jar attus-processo-seletivo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/attus-processo-seletivo-0.0.1-SNAPSHOT.jar"]