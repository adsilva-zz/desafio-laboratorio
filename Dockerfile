FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD target/laboratorio-0.0.1-SNAPSHOT.jar laboratorio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","laboratorio-0.0.1-SNAPSHOT.jar"]
 
