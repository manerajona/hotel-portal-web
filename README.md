## Overview
 
- Backend: Spring Boot, Spring Security, JPA, Hibernate, MySQL, Maven, Java 1.8.
- Frontend: JSP, jslt, Bootstrap, HTML5, CSS, javascript.

## Build & run

### Local run

Verificar que la versión de Apache Maven sea 3.6.+ y java 1.8.+

```sh
$ mvn -v 
$ java -version 
```

Ejecutar como spring-boot aplication en dev

```sh
$ cd mvc
$ mvn clean package
$ mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Ingresar en el browser:

```http://localhost:8081/index``` 

## Modo Admin

Para ingresar en modo admin acceder a Login con las siguientes credenciales:

| Username | Password |
| -------- | -------- |
| admin    | admin123 |

