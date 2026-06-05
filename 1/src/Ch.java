/**
 * Ch —— 类型转换演示
 *
 * Java 类型转换分两种：
 *   1. 自动类型转换（隐式）：小范围 → 大范围，自动完成
 *   2. 强制类型转换（显式）：大范围 → 小范围，需手动写 (目标类型)
 *
 * 范围大小：byte < short < int < long < float < double
 */
public class Ch {
    public static void main(String[] args) {
        short a = 11;          // short 类型占 2 字节
        int b = 2233;          // int 类型占 4 字节

        // 强制类型转换：int → short（大 → 小，可能丢失数据）
        short c = (short) b;   // 把 b 强制转为 short，再赋值给 c

        // 自动类型转换：short → int（小 → 大，安全）
        int d = a;             // short 的 a 自动提升为 int

        System.out.println(a);  // 11
        System.out.println(b);  // 2233
    }
}
