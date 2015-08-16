package com.digitalreasoning.nlptest.logging

@Singleton
class ErrorLogger {
    private final static transient log =
        org.slf4j.LoggerFactory.getLogger(ErrorLogger)
}
