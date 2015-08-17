Running 3rd feature instructions

++++++++++++++++++++++++++++++++

git checkout requirement3

mvn package

mvn exec:java

To produce a fully java compatible jar with all dependencies ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

mvn assembly:assembly

You will need to run the jar from the project root directory and not from inside target:

java -jar target/nlp**.jar

*Jar file is also included in the project root


Note:

++++++
After running, files inside src/main/resources/input/nlp_data will be re-named to .processed with timestamp and will not be reprocessed. There is another directory src/main/resources/input/nlp_data copy that also has the files and you can grab them from there if you want to re-run.
