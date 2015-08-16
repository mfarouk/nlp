package com.digitalreasoning.nlptest.service

@Singleton
class ConcurrencyService {

    def parallelize(numberOfThreads,statement){
        numberOfThreads.times{
            Thread.start{thread->
                if (thread){
                    statement.execute()
                    thread.join()
                }
            }
        }

    }
}
