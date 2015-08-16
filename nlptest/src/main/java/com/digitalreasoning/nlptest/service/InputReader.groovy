package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.logging.ErrorLogger
import groovy.io.FileType
import groovy.transform.WithReadLock
import groovy.transform.WithWriteLock


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
    @WithReadLock
    synchronized readInputDirectory(directoryName) {
        def inputDir
        def inputFiles = []
        try {
            inputDir = new File(directoryName)
            inputDir.eachFileRecurse(FileType.FILES) { file ->
                if(file.exists()){
                    if (file.name.endsWith("txt")) {
                        inputFiles << file
                    }
                }
            }
        } catch (Exception e) {
            ErrorLogger.log.error "Error while reading test input file/directory with exception: ${e}"
            e.printStackTrace()
            System.exit(0)
        }
        return inputFiles
    }
    @WithReadLock
    @WithWriteLock
    synchronized renameProcessedFiles(String directoryName,inputFiles){
        def inputDir
        try {
            inputDir = new File(directoryName)
            inputDir.eachFileRecurse(FileType.FILES) { file ->
                if(file.exists() &&
                        file.name.endsWith("txt") && inputFiles.contains(file)){
                    file.renameTo("${directoryName}/${file.name}." +
                            "${new Date().format("yyyy-MM-ddHHmmss")}.processed")
                }
            }
        } catch (Exception e) {
            ErrorLogger.log.error "Error while reading test input file/directory with exception: ${e}"
            e.printStackTrace()
            System.exit(0)

        }

    }


}
