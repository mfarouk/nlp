package com.digitalreasoning.nlptest.domain

import com.digitalreasoning.nlptest.enums.NLPConstants

class Word {
    int id
    def regex
    def text
    Sentence word_sentence
    Paragraph word_paragraph

    Word() {
        regex = "(\\s)|" +
                "(?![a-z])(?![A-Z])(?![0-9])|" +
                "(?<=\\${NLPConstants.doubleQuotes})|" +
                "(?<=\\${NLPConstants.leftParan})|" +
                "(?<=\\${NLPConstants.rightParan})|" +
                "(?<=\\${NLPConstants.singleQuote})|" +
                "(?<=\\${NLPConstants.hyphen})"
        word_sentence = new Sentence()
        word_paragraph = new Paragraph()
    }

}
