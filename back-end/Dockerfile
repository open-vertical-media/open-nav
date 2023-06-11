FROM openjdk:8-jdk-alpine
MAINTAINER open-nav
EXPOSE 8080
ENV PROFILE='production'
ENV JAVA_OPTS=''
ENV APP_OPTS=''
ADD main/target/main-0.0.1-SNAPSHOT.jar /app.jar
RUN echo "Asia/Shanghai" > /etc/timezone
COPY docker-entrypoint.sh /
ENTRYPOINT ["sh","/docker-entrypoint.sh"]