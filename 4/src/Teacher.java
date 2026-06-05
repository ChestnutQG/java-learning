/**
 * Teacher —— 子类，继承自 People
 *
 * 与 Student 类似，演示同一个父类方法在不同子类中的不同行为（多态）。
 */
public class Teacher extends People {
    public String name = "子类Teacher的名称";  // 与父类同名变量，隐藏父类变量

    @Override
    public void run() {  // 重写父类的 run() 方法
        System.out.println("老师跑的气喘吁吁~~");
    }
}
