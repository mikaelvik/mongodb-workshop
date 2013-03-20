#!/bin/sh

# remove build catalog
rm -rf target/

# build package without tests
mvn -DskipTests package 

# start the server with configuration (yml)
java -jar target/mongodb-tutorial-1.0-SNAPSHOT.jar server mongodb-workshop-local.yml

