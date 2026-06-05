import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 账户实体类
 * 使用私有属性 + getter/setter 封装数据
 */
class Account {
    private String id;         // 卡号（8位随机数字）
    private String name;       // 账户名称
    private char sex;          // 性别（男/女）
    private String password;   // 密码
    private double money;      // 余额
    private double sx;         // 每次取现额度限制

    // ==================== Getter / Setter ====================
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getN() { return name; }
    public void setN(String name) { this.name = name; }

    public char getS() { return sex; }
    public void setS(char sex) { this.sex = sex; }

    public String getPw() { return password; }
    public void setPw(String password) { this.password = password; }

    public double getM() { return money; }
    public void setM(double money) { this.money = money; }

    public double getSx() { return sx; }
    public void setSx(double sx) { this.sx = sx; }
}

/**
 * ATM —— 完整版 ATM 系统（控制台）
 *
 * 功能菜单：
 *   主菜单：
 *     1. 用户登录   2. 用户开户
 *   用户菜单（登录后）：
 *     1.查账户  2.存款  3.取款  4.转账  5.改密码  6.退出  7.注销
 *
 * 核心设计：
 *   - 使用 ArrayList<Account> 存储所有账户
 *   - 8位随机数字卡号（唯一）
 *   - 取款有余额和额度双重限制
 *   - 转账需验证对方账户姓（首字符匹配）
 *   - 注销账户需余额为 0 且二次确认
 *
 * 这是一个综合性的面向对象 + 集合操作示例。
 */
public class ATM {
    private ArrayList<Account> as = new ArrayList<>();  // 账户列表
    private Scanner sc = new Scanner(System.in);        // 全局输入
    private Account loginA = null;                      // 当前登录账户（null=未登录）

    public static void main(String[] args) {
        ATM atm = new ATM();  // 创建 ATM 实例
        atm.start();          // 启动系统
    }

    /** 系统入口：主菜单循环 */
    public void start() {
        while (true) {
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: login(); break;  // 登录
                case 2: ca(); break;     // 开户
                default: System.out.println("错误");
            }
        }
    }

    /** 开户流程：输入账户信息 → 生成卡号 → 存入列表 */
    private void ca() {
        System.out.println("开户");
        Account acc = new Account();

        // 1. 输入账户名称
        System.out.print("账户名称：");
        String userName = sc.next();
        acc.setN(userName);

        // 2. 输入性别（带校验，只能输入男/女）
        while (true) {
            System.out.print("性别（男/女）：");
            String sexStr = sc.next();
            if (sexStr.equals("男") || sexStr.equals("女")) {
                acc.setS(sexStr.charAt(0));  // 取第一个字符
                break;
            } else {
                System.out.println("错误");
            }
        }

        // 3. 设置密码（两次确认）
        while (true) {
            System.out.print("密码：");
            String pwd = sc.next();
            System.out.print("确认密码：");
            String confirmPwd = sc.next();
            if (pwd.equals(confirmPwd)) {
                acc.setPw(pwd);
                break;
            } else {
                System.out.println("错误");
            }
        }

        // 4. 设置取现额度
        System.out.print("额度：");
        double limit = sc.nextDouble();
        acc.setSx(limit);
        acc.setM(0.0);  // 初始余额为 0

        // 5. 生成唯一 8 位卡号
        String Id = createId();
        acc.setId(Id);

        // 6. 存入列表
        as.add(acc);
        System.out.println(acc.getN() + (acc.getS() == '男' ? "先生" : "女士")
                + "成功，卡号：" + acc.getId());
    }

    /** 生成 8 位随机数字卡号，确保不重复 */
    private String createId() {
        Random r = new Random();
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append(r.nextInt(10));  // 添加一位随机数字 0~9
            }
            String cardId = sb.toString();
            // 检查卡号是否已存在
            if (getAFI(cardId) == null) {
                return cardId;  // 唯一 → 返回
            }
            // 重复则重新生成
        }
    }

    /** 根据卡号查找账户（线性查找），找不到返回 null */
    private Account getAFI(String cardId) {
        for (Account acc : as) {
            if (acc.getId().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }

    /** 登录流程：验证卡号 + 密码 → 进入用户菜单 */
    private void login() {
        System.out.println("登录");
        if (as.isEmpty()) {
            System.out.println("无账户");
            return;
        }

        System.out.print("卡号：");
        String cardId = sc.next();
        Account acc = getAFI(cardId);
        if (acc == null) {
            System.out.println("错误");
            return;
        }

        System.out.print("密码：");
        String pwd = sc.next();
        if (!acc.getPw().equals(pwd)) {
            System.out.println("错误");
            return;
        }

        // 登录成功，进入用户菜单
        loginA = acc;
        System.out.println(loginA.getN() + (loginA.getS() == '男' ? "先生" : "女士")
                + "成功登录，卡号：" + loginA.getId());
        SU();  // 进入用户操作界面
    }

    /** 用户操作界面（登录后） */
    private void SU() {
        while (true) {
            System.out.println("1、查账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、改密码");
            System.out.println("6、退出");
            System.out.println("7、注销");
            System.out.print("请选择：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: showAF(); break;            // 查账户
                case 2: d(); break;                 // 存款
                case 3: wd(); break;                // 取款
                case 4: t(); break;                 // 转账
                case 5: updatePassword(); return;   // 改密码（改完返回主菜单）
                case 6:
                    System.out.println(loginA.getN() + "退出");
                    loginA = null;                  // 登出
                    return;
                case 7:
                    if (delete()) {                  // 注销成功
                        loginA = null;
                        return;
                    }
                    break;
                default: System.out.println("错误");
            }
        }
    }

    /** 1. 查询账户信息 */
    private void showAF() {
        System.out.println("卡号：" + loginA.getId());
        System.out.println("户主：" + loginA.getN()
                + (loginA.getS() == '男' ? "先生" : "女士"));
        System.out.println("性别：" + loginA.getS());
        System.out.println("余额：" + loginA.getM());
        System.out.println("每次取现额度：" + loginA.getSx());
    }

    /** 2. 存款 */
    private void d() {
        System.out.print("存入金额：");
        double money = sc.nextDouble();
        if (money <= 0) {
            System.out.println("错误");
            return;
        }
        loginA.setM(loginA.getM() + money);  // 余额增加
        System.out.println("成功，余额：" + loginA.getM());
    }

    /** 3. 取款（有余额和额度双重校验） */
    private void wd() {
        if (loginA.getM() < 0.01) {
            System.out.println("余额不足");
            return;
        }
        System.out.print("取款金额：");
        double money = sc.nextDouble();
        if (money > loginA.getM()) {
            System.out.println("余额不足，还剩：" + loginA.getM());
            return;
        }
        if (money > loginA.getSx()) {
            System.out.println("超过限额：" + loginA.getSx());
            return;
        }
        loginA.setM(loginA.getM() - money);
        System.out.println("成功，余额：" + loginA.getM());
    }

    /** 4. 转账（需验证对方账户姓的首字） */
    private void t() {
        if (as.size() < 2) {
            System.out.println("没有其他账户");
            return;
        }
        if (loginA.getM() <= 0) {
            System.out.println("余额不足");
            return;
        }

        System.out.print("卡号：");
        String targetCardId = sc.next();
        if (targetCardId.equals(loginA.getId())) {
            System.out.println("错误");  // 不能转给自己
            return;
        }
        Account target = getAFI(targetCardId);
        if (target == null) {
            System.out.println("错误");
            return;
        }

        // 验证对方姓（输入一个汉字，匹配对方账户名的第一个字）
        System.out.print("姓名：");
        String lastName = sc.next();
        if (target.getN().charAt(0) != lastName.charAt(0)) {
            System.out.println("错误");
            return;
        }

        System.out.print("金额：");
        double money = sc.nextDouble();
        if (money > loginA.getM()) {
            System.out.println("余额不足");
            return;
        }

        // 扣自己的钱，加到对方账户
        loginA.setM(loginA.getM() - money);
        target.setM(target.getM() + money);
        System.out.println("成功！金额：" + money + "，余额：" + loginA.getM());
    }

    /** 5. 修改密码 */
    private void updatePassword() {
        System.out.print("密码：");
        String oldPwd = sc.next();
        if (!loginA.getPw().equals(oldPwd)) {
            System.out.println("错误");
            return;
        }
        while (true) {
            System.out.print("新密码：");
            String newPwd = sc.next();
            System.out.print("新密码：");
            String confirmPwd = sc.next();
            if (newPwd.equals(confirmPwd)) {
                loginA.setPw(newPwd);
                System.out.println("成功");
                break;
            } else {
                System.out.println("错误");
            }
        }
    }

    /** 7. 注销账户 */
    private boolean delete() {
        System.out.print("确认注销(y/n)：");
        String confirm = sc.next();
        if (!"y".equalsIgnoreCase(confirm)) {
            System.out.println("取消");
            return false;
        }
        if (loginA.getM() > 0) {
            System.out.println("有余额，错误");  // 余额不为 0 不能注销
            return false;
        }
        as.remove(loginA);  // 从列表中移除
        System.out.println("成功");
        return true;
    }
}
