package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Paragraph
import com.digitalreasoning.nlptest.domain.Sentence
import com.digitalreasoning.nlptest.domain.Word

@Singleton
class WordService {

    def splitIntoWords(sentences) {
        Word word = new Word()
        def wordsMap = [:]
        int offset = 1
        int index = 0
        sentences.each { sentence, paragraph_num ->
            Sentence sentence_object = new Sentence()
            sentence_object.id = index + offset
            sentence.split(word.regex).each { item ->
                if (item.findAll{itm->!itm.isEmpty()}){
                    wordsMap.put("${sentence_object.id.toString()}|" +
                            "${paragraph_num}|" +
                            "UUID:${java.util.UUID.randomUUID()}",item)
                }
            }
            index++
        }
        return wordsMap
    }
}
