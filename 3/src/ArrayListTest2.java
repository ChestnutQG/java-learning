import java.util.ArrayList;

/**
 * ArrayListTest2 —— 遍历集合时删除元素的正确姿势
 *
 * 问题：正向遍历 ArrayList 时删除元素会跳过相邻的匹配项
 *   原因：删除元素后，后面的元素会前移填补空位，索引 i 继续递增
 *        导致刚移过来的元素被跳过了
 *
 * 解决方案：
 *   方案一：每次删除后执行 i--（回退索引）
 *   方案二：倒序遍历（从后往前，删除不影响前面元素的索引）
 */
public class ArrayListTest2 {
    public static void main(String[] args) {
        // 初始化清单
        ArrayList<String> list = new ArrayList<>();
        list.add("枸杞");
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        System.out.println("初始：" + list);

        /*
        // ❌ 错误示范：正向遍历直接删除会漏删
        for (int i = 0; i < list.size(); i++) {
            String ele = list.get(i);
            if (ele.contains("枸杞")) {
                list.remove(ele);  // 删除后 i++ 会跳过刚移过来的元素
            }
        }
        // 结果：[Java入门, 黑枸杞, 人字拖, 枸杞子] → 黑枸杞和枸杞子漏删了
        */

        /*
        // ✅ 方案一：正向遍历 + 删除后 i--
        for (int i = 0; i < list.size(); i++) {
            String ele = list.get(i);
            if (ele.contains("枸杞")) {
                list.remove(ele);
                i--;  // 回退索引，下次循环重新检查当前位置
            }
        }
        */

        // ✅ 方案二：倒序遍历（推荐，更简洁）
        for (int i = list.size() - 1; i >= 0; i--) {
            String ele = list.get(i);
            if (ele.contains("枸杞")) {
                list.remove(ele);
                // 不需要 i--，因为 i 在递减，且前面元素索引未变
            }
        }
        System.out.println("删除后：" + list);  // [Java入门, 人字拖]
    }
}
