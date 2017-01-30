FROM java:8-jdk
MAINTAINER Ipman1971

ARG user=microservice
#ARG artifact=${project.build.finalName}.jar
ARG artifact=kerberos-mc-0.0.1-SNAPSHOT.jar

VOLUME /tmp
EXPOSE 8080

ENV USER_NAME $user
ENV APP_HOME /home/$USER_NAME/apps

RUN useradd -ms /bin/bash $USER_NAME
RUN mkdir $APP_HOME

ADD $artifact $APP_HOME/application.jar

RUN chown $USER_NAME $APP_HOME/application.jar

USER $USER_NAME
WORKDIR $APP_HOME

RUN bash -c 'touch application.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","application.jar"]