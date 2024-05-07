FROM gradle:jdk21
ARG PRODUCTION
ARG JDBC_DATABASE_PASSWORD
ARG JDBC_DATABASE_URL
ARG JDBC_DATABASE_USERNAME

ENV PRODUCTION ${PRODUCTION}
ENV JDBC_DATABASE_PASSWORD ${JDBC_DATABASE_PASSWORD}
ENV JDBC_DATABASE_URL ${JDBC_DATABASE_URL}
ENV JDBC_DATABASE_USERNAME ${JDBC_DATABASE_USERNAME}

WORKDIR /app

# Copy the JAR file from the build context into the Docker image
COPY ./build/libs/pabeanapiaccount-0.0.1-SNAPSHOT.jar /app/

# Add a command to list the contents of the directory
RUN ls -l /app

EXPOSE 8080

CMD ["java","-jar","pabeanapiaccount-0.0.1-SNAPSHOT.jar"]