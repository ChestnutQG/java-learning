/**
 * P —— Java 运算符大全演示
 *
 * 包含以下运算符：
 *   1. 算术运算符：+  -  *  /  %
 *   2. 字符串连接符：+
 *   3. 自增自减运算符：++  --
 *   4. 关系运算符：>  <  >=  <=  ==  !=
 *   5. 逻辑运算符：&&  ||  !
 *   6. 三元运算符：? :
 *   7. 赋值运算符：=  +=  -= 等
 */
public class P {

    public static void main(String[] args) {
        /*
        // ==================== 1. 算术运算符 ====================
        int a = 10;
        int b = 2;
        System.out.println(a + b);   // 12   → 加法
        System.out.println(a - b);   // 8    → 减法
        System.out.println(a * b);   // 20   → 乘法
        System.out.println(a / b);   // 5    → 除法（整数/整数 = 整数，小数部分被截断）
        System.out.println(5 / 2);   // 2    → 整数除法
        System.out.println(5.0 / 2); // 2.5  → 浮点数除法
        int i = 5;
        int j = 2;
        System.out.println(1.0 * i / j); // 2.5 → 乘以 1.0 把结果提升为浮点数
        System.out.println(a % b);   // 0    → 取模（余数）
        System.out.println(3 % 2);   // 1    → 3÷2 余 1
        */

        /*
        // ==================== 2. 字符串连接符 + ====================
        // 当 + 两边有字符串时，+ 是连接符，不是加法
        int a2 = 5;
        System.out.println("abc" + a2);    // "abc5"    → 字符串 + 数字 = 字符串
        System.out.println(a2 + 5);        // 10        → 两个数字，做加法
        System.out.println("aaa" + a2 + 'a'); // "aaa5a" → 从左到右："aaa"+5="aaa5", "aaa5"+'a'="aaa5a"
        System.out.println(a2 + 'a' + "bbb"); // "102bbb" → 先算 a2+'a'=5+97=102, 再 102+"bbb"="102bbb"
        */

        /*
        // ==================== 3. 自增自减运算符 ====================
        int a = 10;
        ++a;                    // 前置++：先加后用，a = 11
        System.out.println(a);  // 11
        --a;                    // 前置--：先减后用，a = 10
        System.out.println(a);  // 10

        int i = 10;
        int rs = ++i;            // 前置++：i 先变成 11，再赋值给 rs
        System.out.println(rs);  // 11
        System.out.println(i);   // 11

        int j = 10;
        int rs2 = j++;           // 后置++：先把 j=10 赋值给 rs2，j 再变成 11
        System.out.println(rs2); // 10
        System.out.println(j);   // 11
        */

        /*
        // ==================== 4. 关系运算符 ====================
        // 结果是 boolean 类型（true/false）
        int a = 10;
        int b = 5;
        boolean rs = a > b;
        System.out.println(rs);        // true
        System.out.println(a >= b);    // true
        System.out.println(2 >= 2);    // true
        System.out.println(a < b);     // false
        System.out.println(a <= b);    // false
        System.out.println(2 <= 2);    // true
        System.out.println(a == b);    // false   → 判断是否相等
        System.out.println(5 == 5);    // true
        System.out.println(a = b);     // 5       → 注意：一个 = 是赋值，不是判断！
        System.out.println(a != b);    // false   → 判断是否不相等
        System.out.println(10 != 10);  // false
        */

        // ==================== 5. 逻辑运算符 &&  ||  ! ====================
        // 需求：手机尺寸 >= 6.95 且 内存 >= 8
        double size = 6.8;
        int storage = 16;
        // && 短路与：两边都为 true 才为 true
        boolean rs = (size >= 6.95) && (storage >= 8);
        System.out.println(rs);  // false（尺寸不满足）

        // || 短路或：只要一边为 true 就为 true
        boolean rs2 = (size >= 6.95) || (storage >= 8);
        System.out.println(rs2); // true（内存满足）

        // ! 取反
        System.out.println(!true);       // false
        System.out.println(!false);      // true
        System.out.println(!(2 > 1));    // false

        // 逻辑运算真值表
        System.out.println(true && true);   // true
        System.out.println(false && false); // false
        System.out.println(true && false);  // false
        System.out.println(false && true);  // false

        System.out.println(true || true);   // true
        System.out.println(false || false); // false
        System.out.println(true || false);  // true
        System.out.println(false || true);  // true

        // ==================== 6. 三元运算符 ? : ====================
        // 格式：条件 ? 成立时的值 : 不成立时的值
        double score = 58.5;
        String rs1 = (score >= 60) ? "成绩及格" : "成绩不及格";
        System.out.println(rs1);

        // 找两个数的较大值
        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println(max);  // 20

        // 找三个数的较大值（嵌套三元）
        int x = 5, y = 12, z = 9;
        int m = (x > y) ? (x > z ? x : z) : (y > z ? y : z);
        System.out.println(m);   // 12
    }
}
