import java.util.Scanner;

/**
 * A2 —— 回文字符串判断（对称字符串）
 *
 * 回文：正着读和反着读一样的字符串，如 "上海自来水来自海上"
 *
 * 算法：双指针法
 *   - 左指针从 0 开始，右指针从末尾开始
 *   - 两个指针向中间移动，逐一比较字符
 *   - 发现不同就是非回文，全部相同就是回文
 *
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入字符串：");
        String str = sc.nextLine();  // 读取整行字符串

        if (isSymmetric(str)) {
            System.out.println("是");
        } else {
            System.out.println("不是");
        }
        sc.close();
    }

    /**
     * 判断字符串是否回文（对称）
     * @param s 待判断的字符串
     * @return true=回文，false=非回文或 null
     */
    public static boolean isSymmetric(String s) {
        if (s == null) return false;   // 空值直接返回 false

        int left = 0;                  // 左指针：指向开头
        int right = s.length() - 1;    // 右指针：指向末尾

        while (left < right) {         // 未相遇时持续比较
            if (s.charAt(left) != s.charAt(right)) {
                return false;          // 发现不同，不是回文
            }
            left++;                    // 左指针右移
            right--;                   // 右指针左移
        }
        return true;                   // 全部匹配，是回文
    }
}
