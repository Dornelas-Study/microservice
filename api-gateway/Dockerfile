FROM openjdk:17.0.2-slim
ENV APP_HOME=/application
WORKDIR $APP_HOME
COPY ./*[0-9].jar ./app.jar
COPY ./entrypoint.sh .
RUN chmod +x ./entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]
EXPOSE 8761