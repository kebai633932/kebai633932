import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Usage: java -jar main.jar [原文文件路径] [抄袭版文件路径] [输出结果文件路径]");
            return;
        }

        String origFilePath = args[0];
        String plagiarizedFilePath = args[1];
        String resultFilePath = args[2];

        System.out.println("读取文件路径: " + origFilePath + " 和 " + plagiarizedFilePath);

        String origContent = TxtIOUtils.readFile(origFilePath);
        String plagiarizedContent = TxtIOUtils.readFile(plagiarizedFilePath);

        double similarity = SimHashUtils.similarity(origContent, plagiarizedContent);

        String result = String.format(origFilePath + "和" + plagiarizedFilePath + "的相似度: %.2f%%", similarity * 100);
        System.out.println(result);

        TxtIOUtils.writeFile(resultFilePath, result);
    }
}

