import java.util.Scanner;

/**
 * A0012 —— ATM 系统界面原型（交互骨架）
 *
 * 这是 ATM 系统的初始版本，仅演示基本的菜单交互：
 *   选择 1 → 进入登录（提示无账户）
 *   选择 2 → 进入开户（提示输入账户名）
 *
 * 注意：这是一个早期原型，功能不完整，仅供参考 if-else 多分支用法。
 * 完整的 ATM 系统见模块 3 的 ATM.java。
 */
public class A0012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---- 主菜单 ----
        System.out.println("欢迎进入ATM.....");
        System.out.println("1.用户登录");
        System.out.println("2.用户开户");
        System.out.print("请选择：");
        int ch = sc.nextInt();  // 读取用户选择

        // ---- 根据选择进入不同分支 ----
        if (ch == 1) {
            // 选择 1：登录（此时系统中还没有账户）
            System.out.println("\n\n\n\n\n\n\n\n\n\n");        // 模拟清屏
            System.out.println("系统登录");
            System.out.println("当前系统中无任何账户,开户之后再登录");
            System.out.println("\n\n\n\n\n\n\n\n\n\n");

            // 重新显示菜单
            System.out.println("欢迎进入ATM.....");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.print("请选择：");

        } else if (ch == 2) {
            // 选择 2：开户
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("系统开户操作");
            System.out.println("请输入账户名称");

        } else {
            // 其他输入 → 什么都不做
        }
    }
}
