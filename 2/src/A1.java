import java.util.Random;
import java.util.Arrays;

/**
 * A1 —— 数组操作综合练习
 *
 * 功能：
 *   1. 随机生成 10 个 1~100 的整数存入数组
 *   2. 求最大值、最小值、总和、平均值
 *   3. 对数组排序后输出
 *
 * 知识点：
 *   - int[] 数组的定义与遍历
 *   - for-each 增强循环
 *   - Arrays.sort() 排序
 *   - 方法封装（getMax/getMin/getSum/getAvg）
 */
public class A1 {
    public static void main(String[] args) {
        // ---- 1. 创建数组，随机填充 10 个 1~100 的整数 ----
        int[] numbers = new int[10];  // 长度为 10 的 int 数组

        Random random = new Random();
        System.out.println("随机生成10个整数：");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;  // 1~100
            System.out.print(numbers[i] + " ");
        }

        // ---- 2. 调用方法计算统计数据 ----
        int max = getMax(numbers);
        int min = getMin(numbers);
        int sum = getSum(numbers);
        double average = getAvg(numbers);

        // ---- 3. 排序 ----
        Arrays.sort(numbers);  // 原地升序排序

        System.out.println();

        System.out.print("排序：");
        for (int num : numbers) {  // for-each 增强循环
            System.out.print(num + " ");
        }

        // ---- 4. 输出结果 ----
        System.out.println();
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
        System.out.println("总和：" + sum);
        System.out.println("平均值：" + average);
    }

    /** 求数组最大值：遍历比较，记录当前最大值 */
    public static int getMax(int[] arr) {
        int max = arr[0];                // 假设第一个最大
        for (int num : arr) {
            if (num > max) {
                max = num;               // 找到更大的就更新
            }
        }
        return max;
    }

    /** 求数组最小值：遍历比较，记录当前最小值 */
    public static int getMin(int[] arr) {
        int min = arr[0];                // 假设第一个最小
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /** 求数组总和：累加每个元素 */
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    /** 求数组平均值：总和 / 元素个数，结果转为 double */
    public static double getAvg(int[] arr) {
        int sum = getSum(arr);
        return (double) sum / arr.length;  // 强制转 double 避免整数除法
    }
}
