## Overview
 
- jpa-module: Spring, JPA, Lombok, Hibernate, MySQL.
- web-module: Spring, Lombok, JSP, jslt, Bootstrap, HTML5, CSS, javascript.

## Build & run

### Local run

Verificar que la versión de Apache Maven sea 3.6.+ y java 11+

```sh
$ mvn -v 
$ java -version 
```

Ejecutar con maven spring-boot run con profile "dev"

```sh
$ mvn clean install
$ cd web-module
$ mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Ingresar en el browser:

```http://localhost:8081/index``` 

## Modo Admin

Para ingresar en modo admin acceder a Login con las siguientes credenciales:

| Username | Password |
| -------- | -------- |
| admin    | admin123 |

