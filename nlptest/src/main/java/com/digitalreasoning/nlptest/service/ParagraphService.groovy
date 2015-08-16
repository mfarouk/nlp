package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Paragraph

@Singleton
class ParagraphService {


    def splitIntoParagraphs(input) {
        Paragraph paragraph = new Paragraph()
        def paragraphs = input.text.split(paragraph.regex).findAll { item -> !item.isEmpty() }
        return paragraphs
    }
}
