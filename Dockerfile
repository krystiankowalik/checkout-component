#FROM openjdk:8-jdk-alpine
FROM pegasystems/postgres-pljava-openjdk
#FROM alinous/docker-java-postgresql
#FROM postgres
#RUN echo "deb http://http.debian.net/debian jessie-backports main" | sudo tee -a /etc/apt/sources.list
#    RUN apt-get update && \
#        apt-get upgrade -y && \
#        apt-get install -y  software-properties-common && \
#        add-apt-repository ppa:webupd8team/java -y && \
#        apt-get update && \

#ENV POSTGRES_PASSWORD=kk
#ENV POSTGRES_USER=kk
#ENV POSTGRES_DB=kk

#RUN sed -e "s/[#]\?listen_addresses = .*/listen_addresses = '*'/g" -i '/etc/postgresql/9.1/main/postgresql.conf'

#EXPOSE 5432

VOLUME /tmp
ADD target/checkout-component-0.1.0.jar app.jar
#ENV JAVA_OPTS=""
#CMD ["/bin/bash", "/usr/local/bin/postgresql.sh"]
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar


