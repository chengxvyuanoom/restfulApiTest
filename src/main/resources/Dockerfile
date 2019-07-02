FROM java:openjdk-8-jre-alpine

ARG JAR_FILE
ARG LIB_FILE
ARG BIN_FILE
ARG RES_FILE

COPY ${JAR_FILE} /product_service/lib/
COPY ${LIB_FILE} /product_service/lib/
COPY ${BIN_FILE} /product_service/bin/
COPY ${RES_FILE} /product_service/resources/
#RUN mv /product_service/lib/restful-0.0.1-SNAPSHOT.jar.original /product_service/lib/restful-0.0.1-SNAPSHOT.jar
RUN chmod a+x /product_service/bin/*

#ENTRYPOINT [ "sh","sleep","1d" ]
