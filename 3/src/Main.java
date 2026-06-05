import java.util.ArrayList;

/**
 * Main —— ArrayList 遍历删除演示（正向 vs 倒序）
 *
 * 场景：从清单中删除所有包含"枸杞"的条目
 *
 * 核心问题：ArrayList 在遍历时删除元素会导致索引错乱
 *
 * 解决方案：
 *   方式一：正向遍历 + 删除后 i--（回退索引）
 *   方式二：倒序遍历（推荐）—— 从后往前删，不影响前面元素的索引
 */
public class Main {
    public static void main(String[] args) {
        // 准备一个包含"枸杞"相关条目的清单
        ArrayList<String> list = new ArrayList<>();
        list.add("枸杞茶");
        list.add("红枣枸杞汤");
        list.add("菊花茶");
        list.add("枸杞子");
        list.add("人参枸杞酒");
        list.add("白开水");

        System.out.println("原始清单：" + list);

        // ===== 方式一：正向遍历（删除后需 i--） =====
        for (int i = 0; i < list.size(); i++) {
            String ele = list.get(i);
            if (ele.contains("枸杞")) {
                list.remove(ele);
                i--;  // 删除后后面元素前移，索引回退一位，否则会漏删
            }
        }
        System.out.println("正向删除后的清单：" + list);

        // 重新初始化一个相同的清单，用于对比演示
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("枸杞茶");
        list2.add("红枣枸杞汤");
        list2.add("菊花茶");
        list2.add("枸杞子");
        list2.add("人参枸杞酒");
        list2.add("白开水");

        System.out.println("\n新清单（倒序删除前）：" + list2);

        // ===== 方式二：倒序遍历（推荐，逻辑更清晰） =====
        // 从最后一个元素开始往前删，删除后前面元素的索引不变
        for (int i = list2.size() - 1; i >= 0; i--) {
            String ele = list2.get(i);
            if (ele.contains("枸杞")) {
                list2.remove(ele);
                // 倒序时不需要 i--，因为 i 递减，且前面元素索引不受影响
            }
        }
        System.out.println("倒序删除后的清单：" + list2);
    }
}
