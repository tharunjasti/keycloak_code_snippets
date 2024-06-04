FROM quay.io/keycloak/keycloak:20.0.3

ENV KEYCLOAK_ADMIN admin
ENV KEYCLOAK_ADMIN_PASSWORD admin

COPY /target/user-storage-properties-example.jar  /opt/keycloak/providers/user-storage-properties-example.jar


# docker run -p 8080:8080 keycloak-quarkus start-dev
# docker build -t keycloak-quarkus .

