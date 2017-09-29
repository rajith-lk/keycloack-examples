# Docker file for camel app on wildfly with keycloak security
# ===========================================================

FROM jboss/wildfly:10.1.0.Final

ENV KEYCLOAK_VERSION 3.3.0.CR2

USER jboss

WORKDIR /opt/jboss/wildfly

RUN curl -L https://downloads.jboss.org/keycloak/$KEYCLOAK_VERSION/adapters/keycloak-oidc/keycloak-wildfly-adapter-dist-$KEYCLOAK_VERSION.tar.gz | tar zx

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

ADD ./standalone.xml $JBOSS_HOME/standalone/configuration/

ADD ./target/camel-keycloak-0.1.war $JBOSS_HOME/standalone/deployments/
