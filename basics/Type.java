/**
 * Type —— Java 的 8 种基本数据类型演示
 * 四类八种：整数(byte/short/int/long)、浮点(float/double)、字符(char)、布尔(boolean)
 * 外加引用类型 String
 */
public class Type {
    public static void main(String[] args) {
        // ==================== 整数类型 ====================
        byte number = 1;               // byte：1 字节，范围 -128 ~ 127
        System.out.println(number);

        short number2 = 180;           // short：2 字节，范围约 ±3.2 万
        int number3 = 111111111;       // int：4 字节（最常用），范围约 ±21 亿
        long number4 = 123456789L;     // long：8 字节，后缀 L 表示长整型

        // ==================== 浮点类型 ====================
        float s1 = 3.14f;              // float：4 字节，后缀 f 表示单精度
        double s2 = 3.14;              // double：8 字节（默认小数类型）

        // ==================== 字符类型 ====================
        char s3 = 'a';                 // char：2 字节，用单引号，支持 Unicode
        char s4 = '中';                // 一个汉字也是一个 char
        char s5 = 'c';

        // ==================== 布尔类型 ====================
        boolean b1 = true;             // boolean：只有 true 和 false 两个值
        boolean b2 = false;

        // ==================== 引用类型：String ====================
        String name = "gaga";          // String 不是基本类型，是引用类型，用双引号
        System.out.println(name);
    }
}
