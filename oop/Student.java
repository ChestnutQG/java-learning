/**
 * Student —— 子类，继承自 People
 *
 * 演示：
 *   1. 方法重写（@Override）：子类提供自己的 run() 实现
 *   2. 变量隐藏：子类定义了与父类同名的 name 变量
 *
 * 关键规则：
 *   - 方法：编译看左边（父类），运行看右边（子类）—— 多态
 *   - 变量：编译看左边，运行也看左边 —— 没有多态
 */
public class Student extends People {
    public String name = "子类Student的名称";  // 与父类同名变量，隐藏父类变量

    @Override
    public void run() {  // 重写父类的 run() 方法
        System.out.println("学生跑的贼快~~");
    }
}
