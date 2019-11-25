FROM tomcat:9.0.24
VOLUME /tmp
COPY target/hotel-portal-web.war /usr/local/tomcat/webapps/hotel-web.war
EXPOSE 8086
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/hotel-web.war" ]