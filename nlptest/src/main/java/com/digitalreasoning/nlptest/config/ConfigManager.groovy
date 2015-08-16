package com.digitalreasoning.nlptest.config

import com.digitalreasoning.nlptest.logging.ErrorLogger

/* A Singleton to access configuration files */
class ConfigManager {

    def inputConfig

    private static ConfigManager configManager = new ConfigManager()

    /* Private constructor to defeat instantiation */

    private ConfigManager() {

        def path = System.getenv("properties.nlp.path")

        if (path == null) {
            path = "${System.getProperty("user.dir")}/src/main/resources/config"
        }

        def inputProps = new Properties()

        try {
            def inputInputStream = new FileInputStream("${path}/input.properties")
            inputProps.load(inputInputStream)
        } catch (IOException e) {
            ErrorLogger.log.error "Error while reading file config file with exception: ${e}"
            e.printStackTrace()
            System.exit(0)
        }
        inputConfig = new ConfigSlurper().parse(inputProps)
    }

    static synchronized ConfigManager getInstance() {
        return configManager;
    }
}
