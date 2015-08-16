package com.digitalreasoning.nlptest.domain

import com.digitalreasoning.nlptest.enums.NLPConstants

class Sentence {
    int id
    int number
    def regex
    def content
    Paragraph sentence_paragraph

    Sentence() {
        regex = "(?<=\\${NLPConstants.questionMark})|" +
                "(?<=\\${NLPConstants.period})" +
                "(?!\\${NLPConstants.period}${NLPConstants.period})" +
                "(?!\\${NLPConstants.doubleQuotes})" +
                "(?!${NLPConstants.spaceFollowedByLowerCase})"
    }

}
