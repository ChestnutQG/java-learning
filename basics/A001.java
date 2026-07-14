/**
 * A001 —— if 条件分支语句演示
 *
 * 三种格式：
 *   1. if 单分支：条件成立才执行
 *   2. if-else 双分支：条件成立执行 A，否则执行 B
 *   3. if-else if-else 多分支：依次判断多个条件
 *
 * 注意事项：
 *   - 多分支中，条件顺序很重要（先判断的条件会优先匹配）
 *   - if 可以嵌套使用
 */
public class A001 {
    public static void main(String[] args) {
        int age = 23;  // 当前年龄

        // ---- 格式一：单分支 if ----
        if (age > 40) {
            System.out.println("中年人");  // age=23 不满足，不执行
        }

        // ---- 格式二：if-else 双分支 ----
        if (age > 40) {
            System.out.println("中年人");
        } else {
            System.out.println("青少年");  // 输出：青少年
        }

        // ---- 格式三：if-else if-else 多分支 ----
        // 注意：条件自上而下匹配，匹配到就停止，后面不再判断
        if (age > 40) {
            System.out.println("中年人");
        } else if (age > 50) {
            System.out.println("中老年");
        } else if (age > 60) {
            System.out.println("老年");
        } else if (age > 70) {
            System.out.println("老老少年");
        } else {
            System.out.println("青少年");  // 23 岁 → 输出：青少年
        }

        // ---- if 嵌套 ----
        if (true) {
            if (false) {
                System.out.println("xxxx");   // 不执行
            } else {
                System.out.println("#####");  // 输出：#####
            }
        }
    }
}
