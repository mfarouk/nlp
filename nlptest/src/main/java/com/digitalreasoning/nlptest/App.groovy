package com.digitalreasoning.nlptest

import com.digitalreasoning.nlptest.config.ConfigManager
import com.digitalreasoning.nlptest.logging.ErrorLogger
import com.digitalreasoning.nlptest.service.ConcurrencyService
import com.digitalreasoning.nlptest.service.XMLGenerator


class App {

    static ConfigManager conf = ConfigManager.instance
    static XMLGenerator xmlGen = XMLGenerator.instance
    static ConcurrencyService conc = ConcurrencyService.instance
    static dirName = "${conf.inputConfig.input.files.path}/${conf.inputConfig.input.files.dir}"

    static void main(String[] args) {
        ErrorLogger.log.info "Starting Processing!"
        conc.parallelize(10,xmlGen.generateXML(dirName))
        ErrorLogger.log.info "GoodBye!"
    }
}
