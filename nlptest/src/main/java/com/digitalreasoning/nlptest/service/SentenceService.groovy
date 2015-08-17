package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Paragraph
import com.digitalreasoning.nlptest.domain.Sentence

@Singleton
class SentenceService {

    def splitIntoSentences(paragraphs) {
        Sentence sentence = new Sentence()
        def sentenceList = []
        int offset = 1
        paragraphs.eachWithIndex { paragraph, index ->
            Paragraph paragraph_object = new Paragraph()
            paragraph_object.id = index + offset
            def sentences = paragraph.split(sentence.regex)
            def sentencesWithoutBlanks = sentences.findAll { item -> !item.isEmpty() }
            sentencesWithoutBlanks.eachWithIndex { item, stc_index ->
                if (item.findAll { itm -> !itm.isEmpty() }) {
                    Sentence stc = new Sentence()
                    stc.text = item.trim()
                    stc.sentence_paragraph.id = index + offset
                    sentenceList.add(stc)
                }
            }
        }
        return sentenceList
    }
}
