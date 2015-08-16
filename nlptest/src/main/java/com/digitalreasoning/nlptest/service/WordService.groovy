package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Paragraph
import com.digitalreasoning.nlptest.domain.Sentence
import com.digitalreasoning.nlptest.domain.Word

@Singleton
class WordService {

    def splitIntoWords(sentences) {
        Word word = new Word()
        def wordsMap = [:]
        def wordList = []
        int offset = 1
        int index = 0
        /*sentences.each { sentence, paragraph_num ->
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
        }*/
        sentences.eachWithIndex { sentence, idx ->
            sentence.text.split(word.regex).each { item ->
                Word w = new Word()
                w.word_sentence.id = idx + offset
                w.word_paragraph.id = sentence.sentence_paragraph.id
                if (item.findAll { itm -> !itm.isEmpty() }) {
                    w.text = item.trim()
                    wordList.add(w)
                }

            }
            index++

        }
        return wordList
    }
}
