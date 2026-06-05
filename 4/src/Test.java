/**
 * Test —— 多态核心演示
 *
 * 多态的前提：
 *   1. 存在继承关系（extends）
 *   2. 子类重写父类方法（@Override）
 *   3. 父类引用指向子类对象（People p = new Teacher()）
 *
 * 多态的核心规则（口诀）：
 *   - 成员方法：编译看左边（父类），运行看右边（子类）
 *   - 成员变量：编译看左边（父类），运行也看左边（父类）
 *
 * 即：方法有多态，变量没有多态。
 */
public class Test {
    public static void main(String[] args) {

        // ===== 普通调用（没有多态） =====
        // Teacher t = new Teacher();
        // t.run();  // 输出：老师跑的气喘吁吁~~（调用子类方法）
        //
        // People p = new People();
        // p.run();  // 输出：人可以跑~（调用父类方法）

        // ===== 多态调用：父类引用指向子类对象 =====

        // People 类型的变量 p1，实际指向 Teacher 对象
        People p1 = new Teacher();
        p1.run();                 // 方法：编译看 People，运行看 Teacher
                                  // → 输出：老师跑的气喘吁吁~~
        System.out.println(p1.name);  // 变量：编译看左边，运行也看左边
                                      // → 输出：父类People的名称（不是子类的！）

        // People 类型的变量 p2，实际指向 Student 对象
        People p2 = new Student();
        p2.run();                 // 方法多态：输出 "学生跑的贼快~~"
        System.out.println(p2.name);  // 变量无多态：输出 "父类People的名称"
    }
}
