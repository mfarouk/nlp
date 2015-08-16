package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.config.ConfigManager

@Singleton
class Tokenizer {
    static SentenceService sentence = SentenceService.instance
    static ParagraphService paragraph = ParagraphService.instance
    static WordService word =  WordService.instance
    static InputReader input = InputReader.instance
    static ConfigManager conf = ConfigManager.getInstance()
    static XMLGenerator xml = new XMLGenerator()

    static tokenize(file){
        def inputData = input.readInputFile("${conf.inputConfig.input.files.path}/${file}")
        def paragraphs = paragraph.splitIntoParagraphs(inputData)
        def sentences = sentence.splitIntoSentences(paragraphs)
        println sentences
        //def word = word.splitIntoWords(sentences)
        xml.generateXML(file)

        //word.each{println it}
    }

}
