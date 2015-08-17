package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Word

@Singleton
class WordService {

    def splitIntoWords(sentences) {
        Word word = new Word()
        def wordList = []
        int offset = 1
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
        }
        return wordList
    }
}
