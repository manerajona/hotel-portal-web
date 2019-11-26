# Overview
 
- Backend: Spring Boot, Spring Security, JPA, Hibernate, MySQL, Maven, Docker, Java 1.8.
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
$ mvn compile
$ mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Ingresar en el browser:

```http://localhost:8081/index``` 

### Docker run

Verificar que la versión de Apache Maven sea 3.6.+

```sh
$ mvn -v  
```

Generar .war:

```sh
$ cd mvc
$ mvn clean package
```
Verificar que la versión de Docker sea 19.03.+

```sh
$ docker version
```

Levantar base de datos en Docker

```sh
$ docker pull mysql:8.0
$ docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=HOTEL -e MYSQL_PASSWORD=admin -d mysql:8.0
```

Buildear imagen en Docker y ejecutar el contenedor

```sh
$ docker build . -t hotel-web
$ docker run -p 8086:8086 --name hotel-web --link mysql-standalone:mysql -d hotel-web
```

Ingresar en el browser:

```http://localhost:8086/index``` 

## Modo Admin

Para ingresar en modo admin acceder a Login con las siguientes credenciales:

| Username | Password |
| -------- | -------- |
| admin    | admin123 |

