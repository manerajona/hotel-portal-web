# Overview
 
- Backend: Spring Boot, Spring Security, JPA, Hibernate, MySQL, Maven, Java 1.8.
- Frontend: JSP, jslt, Spring Framework, Bootstrap, HTML5, CSS, javascript.

### Crear esquema

Crear una base de datos Mysql con el nombre "hoteldb":

```sh
CREATE DATABASE hoteldb;
```
Agregar la usuario y password para hoteldb en resources/aplication.properties. Debería quedar algo así:

```sh
spring.datasource.url=jdbc:mysql://localhost:3306/hoteldb?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=root_pass
```

### Build & run

Verificar que la versión de Apache Maven sea 3.6.0: ```sh $ mvn -v ```. Luego ejecutar:

```sh
$ cd mvc
$ mvn compile
$ mvn install
$ mvn clean spring-boot:run
```


### Modo Admin

Para ingresar en modo admin acceder a http://localhost:8080/login con las siguientes credenciales:

- username: admin
- password: admin123
