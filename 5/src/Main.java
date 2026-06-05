import java.util.Scanner;

/**
 * Main —— 超市员工薪资管理系统
 *
 * 项目说明：
 *   录入 6 名员工（2 保安 + 2 收银 + 2 理货员），计算并输出各人薪资及总和。
 *
 * 类层次结构（继承 + 多态）：
 *   Person（父类：通用属性 + 算薪方法）
 *     ├── Security（保安：固定月薪 3000 + 全勤奖 500）
 *     ├── Cashier（收银员：底薪 3500 + 工时×20）
 *     └── StockClerk（理货员：底薪 3500 + 销售额×80）
 *
 * 核心知识点：
 *   - 继承：子类 extends 父类，复用代码
 *   - 多态：Person[] 数组存储不同子类对象
 *   - 动态绑定：调用 settleSalary() 时自动选择对应子类的方法
 *   - 方法重写：每个子类有自己的算薪规则
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person[] staff = new Person[6];  // 多态数组：父类引用存子类对象

        // ----- 录入 2 个保安 -----
        for (int i = 0; i < 2; i++) {
            System.out.println("录入第" + (i + 1) + "个保安：");
            System.out.print("员工编号：");
            String id = sc.nextLine();
            System.out.print("员工姓名：");
            String name = sc.nextLine();
            System.out.print("手机号：");
            String phone = sc.nextLine();
            System.out.print("性别：");
            String gender = sc.nextLine();
            staff[i] = new Security(id, name, phone, gender);  // 向上转型
        }

        // ----- 录入 2 个收银员 -----
        for (int i = 0; i < 2; i++) {
            System.out.println("录入第" + (i + 1) + "个收银：");
            System.out.print("员工编号：");
            String id = sc.nextLine();
            System.out.print("员工姓名：");
            String name = sc.nextLine();
            System.out.print("手机号：");
            String phone = sc.nextLine();
            System.out.print("性别：");
            String gender = sc.nextLine();
            Cashier c = new Cashier(id, name, phone, gender);
            System.out.print("工时（小时）：");
            c.setHours(Integer.parseInt(sc.nextLine()));
            staff[2 + i] = c;  // 保安占 0,1，收银占 2,3
        }

        // ----- 录入 2 个理货员 -----
        for (int i = 0; i < 2; i++) {
            System.out.println("录入第" + (i + 1) + "个理货：");
            System.out.print("员工编号：");
            String id = sc.nextLine();
            System.out.print("员工姓名：");
            String name = sc.nextLine();
            System.out.print("手机号：");
            String phone = sc.nextLine();
            System.out.print("性别：");
            String gender = sc.nextLine();
            StockClerk s = new StockClerk(id, name, phone, gender);
            System.out.print("销售额：");
            s.setSales(Double.parseDouble(sc.nextLine()));
            staff[4 + i] = s;  // 理货占 4,5
        }

        sc.close();

        // ----- 输出薪资明细 -----
        System.out.println("\n========== 薪资明细 ==========");
        for (Person p : staff) {
            System.out.println(p);  // 多态调用 toString()
        }

        // ----- 计算薪资总和 -----
        double total = totalSalary(staff);
        System.out.println("==============================");
        System.out.println("薪资总和：" + total);
    }

    /** 计算所有员工薪资总和（多态的应用） */
    public static double totalSalary(Person[] persons) {
        double sum = 0;
        for (Person p : persons) {
            sum += p.settleSalary();  // 根据实际类型调用对应的算薪方法
        }
        return sum;
    }
}

/**
 * Person —— 员工父类
 * 包含所有员工的公共属性和方法
 */
class Person {
    String id;       // 员工编号
    String name;     // 员工姓名
    String phone;    // 手机号
    String gender;   // 性别

    /** 父类构造方法：初始化公共属性 */
    public Person(String id, String name, String phone, String gender) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    /** 结算薪资（父类默认返回 0，子类需重写） */
    public double settleSalary() {
        return 0;
    }

    /** 统一输出格式（子类可重写以显示特有信息） */
    @Override
    public String toString() {
        return name + "(" + id + ") - " + gender + " - 薪资：" + settleSalary();
    }
}

/**
 * Security —— 保安类
 * 薪资规则：底薪 3000 + 全勤奖 500 = 3500（固定）
 */
class Security extends Person {
    static final double BASE_SALARY = 3000;       // 底薪
    static final double FULL_ATTENDANCE = 500;    // 全勤奖

    public Security(String id, String name, String phone, String gender) {
        super(id, name, phone, gender);  // 调用父类构造方法
    }

    @Override
    public double settleSalary() {
        return BASE_SALARY + FULL_ATTENDANCE;  // 3500 固定薪资
    }
}

/**
 * Cashier —— 收银员类
 * 薪资规则：底薪 3500 + 工时 × 20（时薪）
 */
class Cashier extends Person {
    static final double BASE_SALARY = 3500;   // 底薪
    static final double HOURLY_RATE = 20;     // 时薪
    int hours;  // 月工时（小时）

    public Cashier(String id, String name, String phone, String gender) {
        super(id, name, phone, gender);
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double settleSalary() {
        return BASE_SALARY + hours * HOURLY_RATE;
    }

    @Override
    public String toString() {
        return name + "(" + id + ") - " + gender
                + " - 工时：" + hours + "h - 薪资：" + settleSalary();
    }
}

/**
 * StockClerk —— 理货员类
 * 薪资规则：底薪 3500 + 销售额 × 80（提成比例）
 */
class StockClerk extends Person {
    static final double BASE_SALARY = 3500;  // 底薪
    double sales;  // 月销售额

    public StockClerk(String id, String name, String phone, String gender) {
        super(id, name, phone, gender);
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public double settleSalary() {
        return BASE_SALARY + sales * 80;  // 底薪 + 销售额提成
    }

    @Override
    public String toString() {
        return name + "(" + id + ") - " + gender
                + " - 销售额：" + sales + " - 薪资：" + settleSalary();
    }
}
