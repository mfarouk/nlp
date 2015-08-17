Running 1st feature instructions

git checkout requirement1

mvn package

mvn exec:java

To produce a fully java compatible jar with all dependencies

mvn assembly:assembly


You will need to run the jar from the project root directory and not from inside target: e.g. java -jar target/nlp**.jar


