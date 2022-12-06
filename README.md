# Account&User
Spring Boot ile ekleme,silme,gunceleme,arama fonksiyonlari var. Verileri H2 Database ?zerinde tutan basit bir Java Spring Boot projesi

**Ilk olarak user yaratip gerekli degiskenleri verdikten sonra o user'in id'sini alip account olustururken veriyoruz. Boylece user'la account'u bagliyoruz.**

Basit testler yazilmistir.

### Postman Collection
Buradan tum islemlere ulasabilirsiniz.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/eaec5ba68fd7b8f9eb66?action=collection%2Fimport)

### Port
```
  http://localhost:8080
```

### H2 Database Connection
```
http://localhost:8080/h2-console/
``` 

<ul>
    <li>setting-name=Generic H2(Embedded)</li>
    <li>driver-class=org.h2.Driver</li>
    <li>url=jdbc:h2:mem:dcbapp</li>
    <li>username=sa</li>
    <li>password=password</li>
</ul>

### Tech Stack
- Java 11
- Spring Boot
- Spring Data
- REST-API
- H2 Database
- Lombok
- Junit5

### Requirements

For building and running the application you need:
- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or newer .
- [Maven](https://maven.apache.org)
- [Lombok](https://projectlombok.org/)

### Build & Run

```
  mvn clean install && mvn --projects backend spring-boot:run
```
