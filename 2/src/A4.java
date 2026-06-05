import java.util.Scanner;

/**
 * A4 —— 手动实现字符串大小写转换
 *
 * 不依赖 String 的 toUpperCase()/toLowerCase()，从底层理解字符编码：
 *   - 小写转大写：char - 32（'a'=97, 'A'=65，差值为 32）
 *   - 大写转小写：char + 32
 *
 * 使用 StringBuilder 拼接结果，比 String 直接拼接效率更高。
 */
public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String input = sc.nextLine();

        String upper = myToUpperCase(input);  // 转大写
        String lower = myToLowerCase(input);  // 转小写

        System.out.println("转换后的大写字符串: " + upper);
        System.out.println("转换后的小写字符串: " + lower);
        sc.close();
    }

    /**
     * 手动实现字符串转大写
     * 原理：小写字母 a-z (ASCII 97-122) 减去 32 得到大写 A-Z (65-90)
     */
    public static String myToUpperCase(String str) {
        if (str == null) return null;      // 空值处理

        StringBuilder sb = new StringBuilder();  // 用于拼接结果
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c - 32));      // 小写 → 大写
            } else {
                sb.append(c);                    // 非小写字母原样保留
            }
        }
        return sb.toString();
    }

    /**
     * 手动实现字符串转小写
     * 原理：大写字母 A-Z (ASCII 65-90) 加上 32 得到小写 a-z (97-122)
     */
    public static String myToLowerCase(String str) {
        if (str == null) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));      // 大写 → 小写
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
