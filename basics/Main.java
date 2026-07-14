import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main —— ATM 系统（控制台版 v1）
 *
 * 功能：
 *   1. 用户开户：输入账户名 + 两次密码确认
 *   2. 用户登录：验证账户名和密码
 *
 * 数据结构：使用 ArrayList<Account> 存储账户列表
 * 流程控制：while(true) 主循环 + switch 分支
 *
 * 注意：本版本仅包含开户和登录，完整版见模块 3 的 ATM.java。
 */
public class Main {

    /** 内部类：账户 */
    static class Account {
        String userName;   // 账户名称
        String password;   // 密码
        double balance;    // 余额（开户时默认为 0）

        public Account(String userName, String password) {
            this.userName = userName;
            this.password = password;
            this.balance = 0.0;
        }
    }

    // 存储所有账户的列表（静态，全局共享）
    private static ArrayList<Account> accounts = new ArrayList<>();
    // 全局 Scanner 对象，避免重复创建
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {  // 主循环：一直运行，直到程序被终止
            System.out.println("欢迎您进入到了ATM系统——");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.print("请选择：");

            String choice = scanner.nextLine();  // 用 nextLine() 避免换行问题

            switch (choice) {
                case "1":
                    login();       // 进入登录流程
                    break;
                case "2":
                    register();    // 进入开户流程
                    break;
                default:
                    System.out.println("输入有误，请重新选择！");
            }
        }
    }

    /** 开户操作：输入账户名 + 密码 + 确认密码 */
    private static void register() {
        System.out.println("——系统开户操作——");

        System.out.print("请您输入您的账户名称：");
        String userName = scanner.nextLine();

        // 检查账户名是否已存在
        for (Account acc : accounts) {
            if (acc.userName.equals(userName)) {
                System.out.println("账户名已存在，请重新输入！");
                return;  // 开户失败，返回主菜单
            }
        }

        System.out.print("请您输入您的密码：");
        String password = scanner.nextLine();

        System.out.print("请再次确认密码：");
        String confirmPwd = scanner.nextLine();

        // 两次密码必须一致
        if (!password.equals(confirmPwd)) {
            System.out.println("两次密码不一致，开户失败！");
            return;
        }

        // 创建新账户并添加到列表
        Account newAccount = new Account(userName, password);
        accounts.add(newAccount);
        System.out.println("开户成功！您的账户名是：" + userName);
        System.out.println("请记住您的密码，稍后登录。");
    }

    /** 登录操作：验证账户名和密码 */
    private static void login() {
        System.out.println("——系统登录——");

        // 先检查系统中是否有账户
        if (accounts.isEmpty()) {
            System.out.println("当前系统中无任何账户，请先开户再来登录~~~");
            return;
        }

        System.out.print("请输入账户名称：");
        String userName = scanner.nextLine();

        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        // 遍历账户列表，匹配账户名和密码
        for (Account acc : accounts) {
            if (acc.userName.equals(userName) && acc.password.equals(password)) {
                System.out.println("登录成功！欢迎您，" + userName);
                // 登录成功后可以继续扩展功能：查询余额、取款、存款等
                return;
            }
        }
        // 循环结束还没找到 → 账户名或密码错误
        System.out.println("账户名或密码错误，登录失败！");
    }
}
