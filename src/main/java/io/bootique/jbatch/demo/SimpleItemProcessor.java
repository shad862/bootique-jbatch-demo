package io.bootique.jbatch.demo;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class SimpleItemProcessor implements ItemProcessor {
    @Override
    public Object processItem(Object item) throws Exception {
        var i = (Integer)item;
        if (i % 2 == 0)
            return i;
        return i * 5;
    }
}