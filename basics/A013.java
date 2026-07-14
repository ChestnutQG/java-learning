/**
 * A013 —— 三种循环语句演示
 *
 * Java 三种循环：
 *   1. while 循环：先判断后执行，可能一次都不执行
 *      格式：while(条件) { 循环体; }
 *
 *   2. do-while 循环：先执行后判断，至少执行一次
 *      格式：do { 循环体; } while(条件);
 *
 *   3. for 循环：适用于已知循环次数的场景
 *      格式：for(初始化; 条件; 迭代) { 循环体; }
 *
 * 三种循环可互相替换，选最简洁的即可。
 */
public class A013 {
    public static void main(String[] args) {

        // ==================== while 循环 ====================
        // 打印 5 个 helloworld
        /*
        int i = 1;
        while (i <= 5) {                   // 条件为 true 就继续循环
            System.out.println("helloworld");
            i++;                           // 迭代变量，避免死循环
        }
        */

        // ==================== do-while 循环 ====================
        // 至少执行一次
        /*
        int i = 1;
        do {
            System.out.println("helloworld");  // 先执行
            i++;
        } while (i <= 5);                      // 再判断
        */

        // ==================== for 循环 ====================
        // 从 10 递减到 6，打印 5 次
        for (int i = 10; i >= 6; i--) {
            System.out.println("helloworld");
        }

        // ==================== 循环实战：求 1+2+...+10 ====================
        int sum = 0;      // 累加器，初始为 0
        int i = 1;        // 循环计数器
        while (i <= 10) {
            sum += i;     // sum = sum + i，把当前数累加到 sum
            i++;          // 计数器 +1
        }
        System.out.println(sum);  // 输出 55
    }
}
