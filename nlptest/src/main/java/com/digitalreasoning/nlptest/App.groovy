package com.digitalreasoning.nlptest

import com.digitalreasoning.nlptest.config.ConfigManager
import com.digitalreasoning.nlptest.logging.ErrorLogger

import com.digitalreasoning.nlptest.service.XMLGenerator


class App
{

    static ConfigManager conf = ConfigManager.getInstance()
    static XMLGenerator xmlGen = XMLGenerator.instance

    static void main( String[] args )
    {
        ErrorLogger.log.info "Starting Processing!"
        xmlGen.generateXML("${conf.inputConfig.input.files.nlp.data}")
        ErrorLogger.log.info "GoodBye!"

    }
}
