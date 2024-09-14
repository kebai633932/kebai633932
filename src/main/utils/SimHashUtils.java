package main.utils;

import java.math.BigInteger;
import java.util.List;

public class SimHashUtils {

    // 计算文本的 SimHash 值
    public static BigInteger computeSimHash(String text) {
        int[] vector = new int[128]; // SimHash 通常是 128 位
        String[] words = text.split("\\s+");

        for (String word : words) {
            BigInteger hash = hashWord(word);
            for (int i = 0; i < 128; i++) {
                // 通过检查每一位是否为 1 来调整向量
                if (hash.testBit(i)) {
                    vector[i] += 1;
                } else {
                    vector[i] -= 1;
                }
            }
        }

        BigInteger simHash = BigInteger.ZERO;
        for (int i = 0; i < 128; i++) {
            if (vector[i] > 0) {
                simHash = simHash.setBit(i);
            }
        }
        return simHash;
    }

    // 计算单词的哈希值
    private static BigInteger hashWord(String word) {
        // 使用常见的哈希函数，如 MurmurHash
        return BigInteger.valueOf(word.hashCode()).abs();
    }

    // 计算两个 SimHash 值之间的汉明距离
    public static int hammingDistance(BigInteger hash1, BigInteger hash2) {
        BigInteger x = hash1.xor(hash2);
        return x.bitCount();
    }

    // 计算两个文本的相似度
    public static double similarity(String text1, String text2) {
        BigInteger simHash1 = computeSimHash(text1);
        BigInteger simHash2 = computeSimHash(text2);
        int distance = hammingDistance(simHash1, simHash2);
        // 汉明距离的范围是 0 到 128 位，计算相似度
        return 1 - (distance / 128.0);
    }
}
