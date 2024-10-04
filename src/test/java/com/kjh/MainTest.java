package test.java.com.kjh;

import main.java.com.kjh.util.SimHashUtils;
import main.java.com.kjh.util.TxtIOUtils;
import org.junit.Test;
import java.io.IOException;

public class MainTest {
    @Test
    public void origAndAllTest() throws IOException {
        // 读取原始文件和所有抄袭文件
        String[] str = new String[6];
        str[0] = TxtIOUtils.readFile("C:/Users/86133/Desktop/java/PaperPlagiarismDetection/testFiles/orig.txt");
        str[1] = TxtIOUtils.readFile("C:/Users/86133/Desktop/java/PaperPlagiarismDetection/testFiles/orig_0.8_add.txt");
        str[2] = TxtIOUtils.readFile("C:/Users/86133/Desktop/java/PaperPlagiarismDetection/testFiles/orig_0.8_del.txt");
        str[3] = TxtIOUtils.readFile("C:/Users/86133/Desktop/java/PaperPlagiarismDetection/testFiles/orig_0.8_dis_1.txt");
        str[4] = TxtIOUtils.readFile("C:/Users/86133/Desktop/java//PaperPlagiarismDetection/testFiles/orig_0.8_dis_10.txt");
        str[5] = TxtIOUtils.readFile("C:/Users/86133/Desktop/java//PaperPlagiarismDetection/testFiles/orig_0.8_dis_15.txt");

        String ansFileName = "C:\\Users\\86133\\Desktop\\java\\PaperPlagiarismDetection\\testFiles\\ans.txt";

        // 计算相似度并将结果写入文件
        for (int i = 1; i < str.length; i++) {
            double similarity = SimHashUtils.similarity(str[0], str[i]);
            String result = String.format("相似度 between org.txt and file%d: %.2f%%", i, similarity * 100);
            TxtIOUtils.writeFile(ansFileName, result);
        }

        // 验证结果文件是否包含正确的信息
        String resultContent = TxtIOUtils.readFile(ansFileName);
        for (int i = 1; i < str.length; i++) {
            String expectedResult = String.format("相似度 between org.txt and file%d: %.2f%%", i, SimHashUtils.similarity(str[0], str[i]) * 100);
            System.out.println(resultContent.contains(expectedResult));
        }
    }
}
