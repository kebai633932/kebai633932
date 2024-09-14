import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtIOUtils {

    // 读取文件内容
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // 写入文件内容
    public static void writeFile(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}
