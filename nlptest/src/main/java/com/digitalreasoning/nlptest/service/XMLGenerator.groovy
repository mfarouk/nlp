package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.config.ConfigManager

@Singleton
class XMLGenerator {
    static SentenceService sentence = SentenceService.instance
    static ParagraphService paragraph = ParagraphService.instance
    static WordService word = WordService.instance
    static InputReader input = InputReader.instance
    static ConfigManager conf = ConfigManager.instance
    static NERService ner = NERService.instance

    def generateXML(file) {
        def inputData = input.readInputFile("${conf.inputConfig.input.files.path}/${file}")
        def paragraphs = paragraph.splitIntoParagraphs(inputData)
        def sentences = sentence.splitIntoSentences(paragraphs)
        def words = word.splitIntoWords(sentences)
        def xml = new groovy.xml.MarkupBuilder()
        def ne = ner.loadNamedEntities("${conf.inputConfig.input.files.named.entities}")
        def sentences_text_only = []
        sentences.each { sentence ->
            sentences_text_only.add(sentence.text)
        }
        def ne_in_sentences = ner.findNamedEntities(sentences_text_only, ne)
        xml.input(type: "text") {
            Paragrahs() {
                paragraphs.eachWithIndex { par, par_index ->
                    Paragraph(id: "${par_index + 1}", par) {
                        Sentences() {
                            sentences.eachWithIndex { sentence, stc_index ->
                                if (par_index + 1 == sentence.sentence_paragraph.id) {
                                    Sentence(id: "${stc_index + 1}", sentence.text) {
                                        NamedEntities() {
                                            ne_in_sentences.eachWithIndex { named_entity, idx ->
                                                if (named_entity.entity_sentence.id == stc_index + 1) {
                                                    NamedEntity(id: "${idx + 1}", named_entity.entityName)
                                                }
                                            }
                                        }
                                        Words() {
                                            words.eachWithIndex { word, w_idx ->
                                                if (word.word_paragraph.id as int == sentence.sentence_paragraph.id as int &&
                                                        word.word_sentence.id as int == stc_index + 1) {
                                                    Word(id: "${w_idx + 1}", word.text)
                                                }
                                            }

                                        }

                                    }
                                }

                            }
                        }

                    }
                }
            }

        }

    }

}
