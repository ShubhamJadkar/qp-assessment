
FROM tomcat:9.0-jdk17


WORKDIR /usr/local/tomcat


RUN rm -rf webapps/ROOT


COPY target/GroceryAPI-By-Shubham.war webapps/ROOT.war

EXPOSE 8080


CMD ["catalina.sh", "run"]
