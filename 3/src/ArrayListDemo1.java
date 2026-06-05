import java.util.ArrayList;

/**
 * ArrayListDemo1 —— ArrayList 常用方法演示
 *
 * ArrayList 是 Java 最常用的集合类之一，底层基于动态数组。
 *
 * 常用方法：
 *   add(E)          → 在末尾添加元素
 *   add(index, E)   → 在指定索引位置插入元素
 *   get(index)      → 获取指定索引的元素
 *   size()          → 获取集合大小（元素个数）
 *   remove(index)   → 按索引删除，返回被删除的元素
 *   remove(Object)  → 按元素内容删除，删除第一次出现的，返回 boolean
 *   set(index, E)   → 修改指定索引的元素，返回被替换的旧元素
 *
 * 注意：ArrayList 只能存储引用类型，不能存基本类型（需用包装类 Integer/Double 等）
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        // 1. 创建 ArrayList 集合对象
        // JDK 7+ 支持钻石语法：后面的尖括号可以省略类型
        ArrayList<String> list = new ArrayList<>();

        // 2. add(E)：在末尾添加元素
        list.add("极客");
        list.add("极客");
        list.add("Java");
        System.out.println(list);  // [极客, 极客, Java]

        // 3. add(index, E)：在指定索引位置插入元素（原位置及后面的元素后移）
        list.add(1, "MySQL");
        System.out.println(list);  // [极客, MySQL, 极客, Java]

        // 4. get(index)：根据索引获取元素
        String rs = list.get(1);
        System.out.println(rs);    // MySQL

        // 5. size()：获取集合中存储的元素个数
        System.out.println(list.size());  // 4

        // 6. remove(index)：按索引删除，返回被删除的元素
        System.out.println(list.remove(1));  // 删除并返回 MySQL
        System.out.println(list);            // [极客, 极客, Java]

        // 7. remove(Object)：按元素内容删除，删除成功返回 true
        System.out.println(list.remove("Java"));  // true
        System.out.println(list);                  // [极客, 极客]

        list.add(1, "html");
        System.out.println(list);  // [极客, html, 极客]

        // 注意：remove(Object) 删除的是第一次出现的匹配项
        System.out.println(list.remove("极客"));  // true（删除第一个"极客"）
        System.out.println(list);                  // [html, 极客]

        // 8. set(index, E)：修改指定索引的元素，返回旧值
        System.out.println(list.set(1, "极客大牛"));  // 返回旧值"极客"
        System.out.println(list);                      // [html, 极客大牛]
    }
}
