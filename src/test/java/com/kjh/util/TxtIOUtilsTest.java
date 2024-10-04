package test.java.com.kjh.util;

import main.java.com.kjh.util.TxtIOUtils;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class TxtIOUtilsTest {

    @Test
    public void testReadFile() throws IOException {
        String filePath = "C:\\Users\\86133\\Desktop\\java\\PaperPlagiarismDetection\\testFiles\\orig.txt";
        String expectedContent = "Hello, world!";
        TxtIOUtils.writeFile(filePath, expectedContent); // 创建测试文件

        String content = TxtIOUtils.readFile(filePath);
        assertEquals(expectedContent, content);
    }

    @Test
    public void testWriteFile() throws IOException {
        String filePath = "C:\\Users\\86133\\Desktop\\java\\PaperPlagiarismDetection\\testFiles\\orig.txt";
        String content = "This is a test.";
        TxtIOUtils.writeFile(filePath, content);

        String writtenContent = TxtIOUtils.readFile(filePath);
        assertEquals(content, writtenContent);
    }
}
