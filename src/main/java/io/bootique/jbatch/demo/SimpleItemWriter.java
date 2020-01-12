package io.bootique.jbatch.demo;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.util.List;

@Named
public class SimpleItemWriter extends AbstractItemWriter {
    @Override
    public void writeItems(List<Object> list) throws Exception {
        System.out.println(list);
    }
}
