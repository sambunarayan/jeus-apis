FROM gcr.io/distroless/java:8
LABEL description="Echo IP Java Application"
EXPOSE 60432
COPY ./target/jeus-echo-1.0.0.war /opt/payara/deployments/jeus-echo.war
WORKDIR /opt/payara/deployments
ENTRYPOINT [ "bin/asadmin", "deploy", "/opt/payara/deployments/jeus-echo.war" ]