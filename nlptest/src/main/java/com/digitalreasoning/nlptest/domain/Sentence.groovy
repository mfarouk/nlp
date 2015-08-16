package com.digitalreasoning.nlptest.domain

import com.digitalreasoning.nlptest.enums.NLPConstants

class Sentence {
    int id
    int number
    def regex
    def text
    Paragraph sentence_paragraph

    Sentence() {
        regex = "(?<=\\${NLPConstants.questionMark})|" +
                "(?<=\\${NLPConstants.period})" +
                "(?!\\${NLPConstants.period}${NLPConstants.period})" +
                "(?!\\${NLPConstants.doubleQuotes})" +
                "(?!${NLPConstants.spaceFollowedByLowerCase})"
        sentence_paragraph = new Paragraph()
    }
}
