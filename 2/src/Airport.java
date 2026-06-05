import java.util.Scanner;

/**
 * Airport —— 飞机票折扣计算系统
 *
 * 规则：
 *   旺季（5-10月）：头等舱 9 折，经济舱 8.5 折
 *   淡季（11-4月）：头等舱 7 折，经济舱 6.5 折
 *
 * 知识点：
 *   - 方法封装（将折扣计算抽成独立方法）
 *   - switch 表达式（Java 14+ 箭头语法）
 *   - 多参数传递
 */
public class Airport {

    /**
     * 计算机票最终价格
     * @param a 原价
     * @param b 季节：1=旺季，2=淡季
     * @param c 舱位：1=头等舱，2=经济舱
     * @return 折扣后价格
     */
    public static double c(double a, int b, int c) {
        double d = 1;  // 折扣率，默认 1（不打折）

        if (b == 1) {  // 旺季
            d = switch (c) {
                case 1 -> 0.9;   // 头等舱 9 折
                case 2 -> 0.85;  // 经济舱 8.5 折
                default -> 1;    // 其他不打折
            };
        }
        if (b == 2) {  // 淡季
            d = switch (c) {
                case 1 -> 0.7;   // 头等舱 7 折
                case 2 -> 0.65;  // 经济舱 6.5 折
                default -> 1;
            };
        }

        return a * d;  // 原价 × 折扣率 = 最终价格
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入原价
        System.out.print("原价：");
        double a = scanner.nextDouble();

        // 选择季节
        System.out.println("1. 旺季（5-10月）");
        System.out.println("2. 淡季（11-4月）");
        int b = scanner.nextInt();

        // 选择舱位
        System.out.println("1. 头等舱");
        System.out.println("2. 经济舱");
        int c = scanner.nextInt();

        // 计算最终价格
        double end = c(a, b, c);
        System.out.println("优惠后价格：" + end + " 元");
    }
}
