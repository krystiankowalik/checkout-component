#FROM openjdk:8-jdk-alpine
FROM pegasystems/postgres-pljava-openjdk

VOLUME /tmp
# WORKDIR /
ADD target/checkout-component-0.1.0.jar app.jar
ENV JAVA_OPTS=""
#RUN java -jar app.jarcd
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar#
ENTRYPOINT exec su - postgres && java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar