import java.util.Scanner;  // 导入 Scanner 类（键盘输入）

/**
 * Sc —— Scanner 键盘录入演示
 * 演示如何从控制台接收用户输入的不同类型数据
 *
 * 关键方法：
 *   next()       → 读取字符串（不含空格）
 *   nextInt()    → 读取整数
 *   nextDouble() → 读取小数
 *   nextLine()   → 读取整行（可含空格）
 *
 * 注意：nextInt()/nextDouble() 后直接调用 nextLine()，
 *       会读到上一个输入遗留的换行符，需要多加一次 nextLine() 吸收掉。
 */
public class Sc {
    public static void main(String[] args) {
        // 创建 Scanner 对象，System.in 表示标准输入（键盘）
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入姓名: ");
        String name = scanner.next();          // 读取字符串，遇到空格就停止

        System.out.print("请输入年龄: ");
        int age = scanner.nextInt();            // 读取整数

        System.out.print("请输入身高(米): ");
        double height = scanner.nextDouble();   // 读取浮点数

        System.out.print("请输入您的爱好: ");
        scanner.nextLine();                     // 吸收上面 nextDouble() 遗留的换行符
        String hobby = scanner.nextLine();      // 读取整行（可以包含空格）

        // ---------- 输出个人信息 ----------
        System.out.println("-------- 个人信息 --------");
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.printf("身高: %.2f 米\n", height);  // 格式化输出，保留两位小数
        System.out.println("爱好: " + hobby);

        scanner.close();  // 使用完毕后关闭 Scanner，释放资源
    }
}
