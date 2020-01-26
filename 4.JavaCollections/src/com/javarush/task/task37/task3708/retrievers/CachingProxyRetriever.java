package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever retriever;
    private LRUCache          cache = new LRUCache(16);

    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {

        if(cache.find(id )== null){
            cache.set(id, retriever.retrieve(id));
        }
        return cache.find(id);
    }
}
