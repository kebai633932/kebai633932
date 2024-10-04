package test.java.com.kjh.util;

import main.java.com.kjh.util.SimHashUtils;
import org.junit.Test;
import java.math.BigInteger;
import static org.junit.Assert.*;

public class SimHashUtilsTest {

    @Test
    public void testComputeSimHash() {
        String text = "This is a simple example.";
        BigInteger simHash = SimHashUtils.computeSimHash(text);
        assertNotNull(simHash);
    }

    @Test
    public void testHammingDistance() {
        BigInteger hash1 = SimHashUtils.computeSimHash("This is a simple example.");
        BigInteger hash2 = SimHashUtils.computeSimHash("This is another example.");
        int distance = SimHashUtils.hammingDistance(hash1, hash2);
        assertTrue(distance >= 0 && distance <= 128);
    }

    @Test
    public void testSimilarity() {
        String text1 = "This is a simple example.";
        String text2 = "This is a similar example.";
        double similarity = SimHashUtils.similarity(text1, text2);
        assertTrue(similarity > 0.7); // 假设相似度应该较高
    }
}
