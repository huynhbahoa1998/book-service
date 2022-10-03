FROM openjdk:11

ENV JAVA_OPTS="-XX:MaxRAMPercentage=90 -XshowSettings:vm -Djava.security.egd=file:/dev/./urandom -Dnetworkaddress.cache.ttl=1"
ENV SPRING_OPTS=""
ENV APP_ARGS=""

ADD target/*.jar ./app.jar

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar $SPRING_OPTS app.jar $APP_ARGS"]