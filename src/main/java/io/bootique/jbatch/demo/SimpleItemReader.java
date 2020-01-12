package io.bootique.jbatch.demo;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
public class SimpleItemReader extends AbstractItemReader {
    private Integer[] tokens;
    private Integer count;
    @Inject JobContext jobContext;

    @Override public Object readItem() throws Exception {
        if (count >= tokens.length) {
            return null;
        }
        return tokens[count++];
    }

    @Override public void open(Serializable checkpoint) throws Exception {
        tokens = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        count = 0;
    }

    @Override public Serializable checkpointInfo() throws Exception {
        return count;
    }
}


