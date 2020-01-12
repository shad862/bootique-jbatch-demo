package io.bootique.jbatch.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class JBatchTest {
    @Test public void simpleItemReaderTest() throws InterruptedException {
        var operator = BatchRuntime.getJobOperator();
        var id = operator.start("ExampleJob", new Properties());
        var exec = operator.getJobExecution(id);
        TimeUnit.SECONDS.sleep(2);
        Assertions.assertEquals(BatchStatus.COMPLETED, exec.getBatchStatus());
    }
}
