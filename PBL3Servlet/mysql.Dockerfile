FROM mysql:8.0.25

ENV MYSQL_ROOT_PASSWORD=123123
ENV MYSQL_DATABASE=pbl3

COPY src/main/resources/dump_mysql/*.sql /docker-entrypoint-initdb.d

CMD ["mysqld"]