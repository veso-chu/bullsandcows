FROM maven:3.8.3-openjdk-17

WORKDIR /bullsandcows
COPY . .
RUN mvn clean install -X

CMD mvn spring-boot:run -X
