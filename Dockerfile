FROM openjdk:11
EXPOSE 8090
ADD target/library-management.jar library-management.jar
ENTRYPOINT ["java","-jar","/library-management.jar"]