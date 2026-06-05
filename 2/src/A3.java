import java.util.Scanner;

/**
 * A3 —— 统计字符串中字母和数字的个数
 *
 * 使用 Character 工具类的方法：
 *   - Character.isLetter(c) → 判断是否为字母
 *   - Character.isDigit(c)  → 判断是否为数字
 */
public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入字符串：");
        String str = sc.nextLine();

        int letterCount = 0;  // 字母计数器
        int digitCount = 0;   // 数字计数器

        // 逐个字符遍历
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);       // 取出当前位置的字符
            if (Character.isLetter(c)) {  // 是字母？
                letterCount++;
            } else if (Character.isDigit(c)) {  // 是数字？
                digitCount++;
            }
            // 其他字符（空格、标点等）忽略
        }

        System.out.println("字母：" + letterCount + "个，数字：" + digitCount + "个");
        sc.close();
    }
}
