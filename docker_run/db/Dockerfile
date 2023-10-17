#COPY mysql:latest
#COPY ./structure.sql /docker-entrypoint-initdb.d/structure.sql
##RUN mysql:latest -u root -p my_db2 < docker-entrypoint-initdb.d/structure.sql
# cat Dockerfile
#FROM mysql:latest
#
#MAINTAINER baeldung.com
#
#RUN chown -R mysql:root /var/lib/mysql/
#
#ARG MYSQL_DATABASE=my_db2
#ARG MYSQL_USER=root
#ARG MYSQL_PASSWORD=qwertyui
#ARG MYSQL_ROOT_PASSWORD=qwertyui
#
#ENV MYSQL_DATABASE=$MYSQL_DATABASE
#ENV MYSQL_USER=$MYSQL_USER
#ENV MYSQL_PASSWORD=$MYSQL_PASSWORD
#ENV MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD
#
#ADD structure.sql /etc/mysql/data.sql
#
#RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /etc/mysql/data.sql
#RUN cp /etc/mysql/data.sql /docker-entrypoint-initdb.d
#
#EXPOSE 3306
FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD=qwertyui
ENV MYSQL_DATABASE=my_db2
COPY structure.sql /docker-entrypoint-initdb.d/