## Reservation System API
this is a java reservation api built using Spring FrameWork and MySql DataBase
## Running Reservation-System  localy
reservation-system is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/zmilad97/reservation-system.git
cd reservation-system
./mvnw package
java -jar target/*.jar
```

You can then access reservation-system here: http://localhost:6060/



Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## In case you find a bug/suggested improvement for Reservation-System
Our issue tracker is available here: https://github.com/zmilad97/reservation-system/issues


## Database configuration

In its default configuration, reservation uses a MySql database on 3306 port which you must
create on your own and name it reservation-system.




