package test;

import main.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainOutput() throws Exception {
        // 调用主方法
        Main.main(new String[]{});

        // 获取输出并检查内容，假设输出的是代码相似度
        String output = outContent.toString().trim();
        assertTrue(output.contains("代码相似度:"));
    }
}
