package com.digitalreasoning.nlptest.domain

import com.digitalreasoning.nlptest.enums.NLPConstants

class Paragraph {
    int id
    def regex
    def content


    Paragraph() {
        regex = NLPConstants.newLine
    }

}
