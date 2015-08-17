Branch specific instructions are found inside each branch.

Input file paths are using relative path but if you had any issues, export the variables below to override the config file location. And you can access the config file location under src/main/resources/config/input.properties to modify the path for the input files or directories.


export NLP_PATH=[location of your nlptest on your machine]/nlptest/src/main/resources/config

launchctl setenv properties.nlp.path $NLP_PATH
