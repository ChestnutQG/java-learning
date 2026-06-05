import java.util.Random;
import java.util.Scanner;

/**
 * Main —— 猜数字游戏
 *
 * 游戏规则：
 *   系统随机生成 1~100 之间的整数，用户有 5 次机会猜测。
 *   每次猜测后系统提示"大了"或"小了"，猜中则提前结束。
 *
 * 知识点：
 *   - Random 类生成随机数
 *   - while 循环控制游戏流程
 *   - if-else 判断提示
 */
public class Main {
    public static void main(String[] args) {
        // 生成 1~100 的随机目标数字
        Random random = new Random();
        int target = random.nextInt(100) + 1;  // nextInt(100) → 0~99，+1 → 1~100
        System.out.println("1~100猜五次");

        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5;        // 最多猜 5 次
        int attempt = 0;            // 已猜次数
        boolean guessedCorrectly = false;  // 是否猜中

        // 还有次数 且 没猜中 → 继续猜
        while (attempt < maxAttempts && !guessedCorrectly) {
            System.out.print("第 " + (attempt + 1) + " 次");

            int guess = scanner.nextInt();  // 读取用户猜测的数字
            attempt++;                      // 已猜次数 +1

            if (guess == target) {
                System.out.println("猜中了");
                guessedCorrectly = true;    // 标记猜中，循环结束
            } else if (guess < target) {
                System.out.println("小了"); // 提示偏小
            } else {
                System.out.println("大了"); // 提示偏大
            }
        }

        // 5 次都没猜中，公布答案
        if (!guessedCorrectly) {
            System.out.println("结束，答案是：" + target);
        }
    }
}
