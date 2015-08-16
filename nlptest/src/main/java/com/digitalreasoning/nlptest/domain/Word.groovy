package com.digitalreasoning.nlptest.domain

import com.digitalreasoning.nlptest.enums.NLPConstants

class Word {
    int id
    def regex
    def content
    Sentence word_sentence

    Word() {
        regex = "(\\s)|" +
                "(?![a-z])(?![A-Z])(?![0-9])|" +
                "(?<=\\${NLPConstants.doubleQuotes})|" +
                "(?<=\\${NLPConstants.leftParan})|" +
                "(?<=\\${NLPConstants.rightParan})|" +
                "(?<=\\${NLPConstants.singleQuote})|" +
                "(?<=\\${NLPConstants.hyphen})"
    }

}
