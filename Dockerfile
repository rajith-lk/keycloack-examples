FROM jboss/keycloak:3.2.1.Final

USER jboss

RUN mkdir $JBOSS_HOME/providers

RUN mkdir -p /opt/jboss/keycloak/modules/system/layers/base/com/mysql/jdbc/main; cd /opt/jboss/keycloak/modules/system/layers/base/com/mysql/jdbc/main && curl -O http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.18/mysql-connector-java-5.1.18.jar

ADD module.xml /opt/jboss/keycloak/modules/system/layers/base/com/mysql/jdbc/main/

ADD ./target/keycloak-custom-providers-0.1.jar $JBOSS_HOME/providers/
ADD standalone.xml $JBOSS_HOME/standalone/configuration/
