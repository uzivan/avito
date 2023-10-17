FROM tomcat:9.0-jdk17-corretto
COPY ./tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY ./context.xml /usr/local/tomcat/webapps.dist/manager/META-INF/context.xml
COPY ./spr_sec.war /usr/local/tomcat/webapps.dist/
RUN mv webapps webapps_old
RUN mv webapps.dist webapps