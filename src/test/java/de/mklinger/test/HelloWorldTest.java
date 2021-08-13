package de.mklinger.test;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class HelloWorldTest {
    @Test
    public void test() {
        PrintStream oldOut = System.out;
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bout, false, StandardCharsets.UTF_8));
            HelloWorld.main(new String[0]);
            Assert.assertEquals("Hello World", bout.toString(StandardCharsets.UTF_8).trim());
        } finally {
            System.setOut(oldOut);
        }
    }
}
