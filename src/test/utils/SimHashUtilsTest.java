package test.utils;

import main.utils.SimHashUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimHashUtilsTest {

    @Test
    public void testSimHashAndSimilarity() {
        String text1 = "This is a simple example.";
        String text2 = "This is a simple sample.";

        double similarity = SimHashUtils.similarity(text1, text2);
        assertTrue(similarity > 0.9);  // 假设相似度应该较高
    }
}
