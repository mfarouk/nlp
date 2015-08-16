package com.digitalreasoning.nlptest.domain


class NamedEntity {
    int id
    String entityName
    Sentence entity_sentence

    NamedEntity() {
        entityName = ""
        entity_sentence = new Sentence()
    }

}
