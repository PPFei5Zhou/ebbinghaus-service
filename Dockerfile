FROM openjdk:11.0.14-jre-bullseye
EXPOSE 8080

ARG DEPENDENCY=build/libs
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.easy.ebbinghausservice.EbbinghausServiceApplication"]