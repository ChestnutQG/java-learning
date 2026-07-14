/**
 * AMTLS —— 变量定义与基本运算
 * 演示变量的声明、赋值和基本算术运算（加减）
 */
public class AMTLS {
    public static void main(String[] args) {
        // ---------- 整数变量 ----------
        int age = 18;                        // 声明整型变量 age 并赋初值 18
        System.out.println("年龄：" + age);   // 输出：年龄：18
        age = 21;                            // 重新赋值为 21（变量的值可以改变）
        System.out.println("年龄：" + age);   // 输出：年龄：21

        // ---------- 浮点数变量 ----------
        double s = 99.98;                    // 声明双精度浮点数变量
        System.out.println("分数：" + s);     // 输出：分数：99.98

        System.out.println("===============================================");

        // ---------- 金额变化演示 ----------
        double m = 12;                       // 初始金额 12 元
        System.out.println("初始金额：" + m);  // 输出：12.0
        m = m + 3;                           // 加 3 元 → 15 元
        System.out.println("改变后金额：" + m);
        m = m - 6;                           // 减 6 元 → 9 元
        System.out.println("改变后金额：" + m);
    }
}
