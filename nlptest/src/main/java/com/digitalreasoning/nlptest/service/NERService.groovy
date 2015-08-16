package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.config.ConfigManager
import com.digitalreasoning.nlptest.domain.NamedEntity

@Singleton
class NERService {

    static InputReader inputReader = InputReader.instance
    static ConfigManager conf = ConfigManager.instance


    def loadNamedEntities(file) {
        def entities = inputReader.readInputFile("${conf.inputConfig.input.files.path}/${file}")
        def entitiesList = []
        entities.eachWithIndex { entity, idx ->
            if (entity.findAll { item -> !item.isEmpty() }) {
                NamedEntity ne = new NamedEntity()
                ne.entityName = entity as String
                ne.id = idx + 1
                entitiesList.add(ne)
            }
        }
        return entitiesList
    }

    def findNamedEntities(sentences, entitiesList) {
        def hits = []
        sentences.eachWithIndex { sentence, sen_idx ->
            entitiesList.eachWithIndex { entity, idx ->
                if (sentence.toString().contains(entity.entityName.toString())) {
                    entity.entity_sentence.id = sen_idx + 1
                    hits.add(entity)
                }
            }
        }
        return hits
    }
}
