FROM openjdk:17.0.2-slim
ENV APP_HOME=/application
WORKDIR $APP_HOME
COPY ./book-service/build/libs/*[0-9].jar ./app.jar
COPY ./book-service/entrypoint.sh .
RUN chmod +x ./entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]
EXPOSE 8761