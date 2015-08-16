package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.logging.ErrorLogger

@Singleton
class InputReader {
    static readInputFile(String fileName) {
        def inputFile

        try {
            inputFile = new File(fileName)
        } catch (Exception e) {
            ErrorLogger.log.error "Error while reading test input file with exception: ${e}"
            e.printStackTrace()
            System.exit(0)
        }
        return inputFile
    }

}
