/**
 * People —— 父类（基类）
 *
 * 作为继承体系的顶层类，定义了：
 *   - name 成员变量（与子类同名，演示变量隐藏）
 *   - run() 方法（被子类重写，演示方法多态）
 *
 * 继承关系：People ← Student / Teacher
 */
public class People {
    public String name = "父类People的名称";  // 父类中的 name 变量

    public void run() {
        System.out.println("人可以跑~");
    }
}
