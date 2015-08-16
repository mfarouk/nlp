package com.digitalreasoning.nlptest.domain

import com.digitalreasoning.nlptest.enums.NLPConstants

class Paragraph {
    int id
    def regex


    Paragraph() {
        regex = NLPConstants.newLine
    }

}
