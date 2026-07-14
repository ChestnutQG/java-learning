/**
 * A006_Test_String —— String 类全面演示
 *
 * 1️⃣ 创建字符串的两种方式
 *    - 直接双引号：String s = "hello";
 *        存储在字符串常量池，相同内容只存一份
 *    - new String()：String s = new String("hello");
 *        每次在堆内存创建新对象
 *
 * 2️⃣ String 常用方法
 *    length()              → 获取长度
 *    charAt(index)         → 获取指定位置的字符
 *    toCharArray()         → 转为字符数组
 *    equals(s)             → 判断内容是否相等
 *    equalsIgnoreCase(s)   → 忽略大小写判断
 *    substring(start, end) → 截取子串 [start, end)
 *    substring(start)      → 截取到末尾
 *    replace(old, new)     → 替换字符串
 *    contains(s)           → 是否包含
 *    startsWith(s)         → 是否以...开头
 *    split(regex)          → 分割字符串
 *
 * 3️⃣ String 不可变性
 *    String 对象一旦创建内容不可改变
 *    拼接操作实际上创建了新对象
 */
public class A006_Test_String {
    public static void main(String[] args) {
        /*
        // ===== 1. 创建字符串的两种方式 =====
        // 方式一：双引号直接创建（推荐）
        String name = "IT666";
        System.out.println(name);

        // 方式二：new String 创建
        String rs1 = new String();            // 空字符串
        System.out.println(rs1);              // ""

        String rs2 = new String("itheima");   // 通过字符串字面量
        System.out.println(rs2);

        char[] chars = {'a', '三', '十'};      // 通过字符数组
        String rs3 = new String(chars);
        System.out.println(rs3);

        byte[] bytes = {97, 98, 99};          // 通过字节数组（ASCII）
        String rs4 = new String(bytes);
        System.out.println(rs4);              // "abc"
        */

        /*
        // ===== 2. String 常用方法 =====
        String s = "Java";

        // 2.1 获取字符串长度
        System.out.println(s.length());       // 4

        // 2.2 获取指定索引的字符
        char c = s.charAt(1);
        System.out.println(c);                // 'a'

        // 2.3 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println(ch);           // J a v a
        }

        // 2.4 转为字符数组后遍历
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        // 2.5 equals：判断内容是否相等（== 比较的是地址）
        String s1 = new String("伦哥");
        String s2 = new String("伦哥");
        System.out.println(s1 == s2);          // false（地址不同）
        System.out.println(s1.equals(s2));     // true（内容相同）

        // 2.6 equalsIgnoreCase：忽略大小写
        String c1 = "34AeFG";
        String c2 = "34aEfg";
        System.out.println(c1.equals(c2));              // false
        System.out.println(c1.equalsIgnoreCase(c2));    // true

        // 2.7 substring(start, end)：截取 [start, end)，包前不包后
        String s3 = "Java是最好的编程语言之一";
        String rs = s3.substring(0, 8);       // [0,8) = 索引 0~7
        System.out.println(rs);               // "Java是最好的"

        // 2.8 substring(start)：从 start 截到末尾
        String rs2 = s3.substring(5);
        System.out.println(rs2);              // "最好的编程语言之一"

        // 2.9 replace：替换（返回新字符串，原字符串不变）
        String info = "这个电影简直是个垃圾，垃圾电影！！";
        String rs3 = info.replace("垃圾", "**");
        System.out.println(rs3);              // "这个电影简直是个**，**电影！！"

        // 2.10 contains：判断是否包含
        String info2 = "Java是最好的编程语言之一，我爱Java,Java不爱我！";
        System.out.println(info2.contains("Java"));   // true
        System.out.println(info2.contains("java"));   // false（区分大小写）
        System.out.println(info2.contains("Java2"));  // false

        // 2.11 startsWith：判断开头
        String rs4 = "张三丰";
        System.out.println(rs4.startsWith("张"));     // true
        System.out.println(rs4.startsWith("张三"));    // true
        System.out.println(rs4.startsWith("张三2"));   // false

        // 2.12 split：按分隔符切分字符串
        String rs5 = "张无忌,周芷若,殷素素,赵敏";
        String[] names = rs5.split(",");       // 按逗号分割
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        */

        // ===== 3. String 的不可变性 & 常量池 =====

        // 3.1 String 对象不可变——每次拼接都创建新对象
        String name = "黑马";
        name += "程序员";        // name = name + "程序员"，创建了新对象
        name += "播妞";          // 再创建一个新对象
        System.out.println(name);  // "黑马程序员播妞"

        // 3.2 双引号字符串存储在常量池，相同内容只存一份
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);  // true → 地址相同，都指向常量池同一对象

        // 3.3 new String 每次创建新对象在堆内存中
        char[] chars = {'a', 'b', 'c'};
        String a1 = new String(chars);
        String a2 = new String(chars);
        System.out.println(a1 == a2);  // false → 堆中两个不同对象
    }
}
