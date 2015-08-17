Running 1st feature instructions

++++++++++++++++++++++++++++++++

git checkout requirement2

mvn package

mvn exec:java

To produce a fully java compatible jar with all dependencies ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

mvn assembly:assembly

You will need to run the jar from the project root directory and not from inside target:

java -jar target/nlp**.jar

*Jar file is also included in the project root
