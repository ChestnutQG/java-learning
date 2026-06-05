import java.util.Scanner;

/**
 * mov —— 电影信息查询系统
 *
 * 功能：
 *   1. 查询全部电影信息（遍历数组输出）
 *   2. 根据电影 ID 查询电影详情
 *
 * 知识点：
 *   - 对象数组的定义与遍历
 *   - 面向对象：构造方法、成员变量
 *   - 根据条件搜索（线性查找）
 *   - while(true) 菜单循环
 */
public class mov {
    int id;         // 电影编号
    String name;    // 电影名称
    double price;   // 票价
    String Star;    // 评分（用星星表示）

    /** 构造方法：创建电影对象 */
    mov(int id, String name, double price, String Star) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Star = Star;
    }

    public static void main(String[] args) {
        // 初始化 5 部电影数据（对象数组）
        mov[] movies = {
            new mov(1, "好看的电影1", 58.8, "★★★☆☆"),
            new mov(2, "好看的电影2", 68.8, "★★★☆☆"),
            new mov(3, "好看的电影3", 48.8, "★★★★☆"),
            new mov(4, "好看的电影4", 78.8, "★★☆☆☆"),
            new mov(5, "好看的电影5", 91.0, "★☆☆☆☆")
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 主菜单
            System.out.println("1. 查询全部电影信息");
            System.out.println("2. 根据电影id查询电影详情");
            int choice = sc.nextInt();

            if (choice == 1) {
                // ---- 功能1：遍历输出全部电影 ----
                for (mov m : movies) {
                    System.out.println(m.id + " " + m.name + "  " + m.price + "  " + m.Star);
                }
            } else if (choice == 2) {
                // ---- 功能2：按 ID 查找电影 ----
                System.out.print("输入编号：");
                int id = sc.nextInt();

                mov f = null;  // 用于保存找到的电影
                for (mov m : movies) {
                    if (m.id == id) {
                        f = m;
                        break;  // 找到了就退出循环
                    }
                }

                if (f != null) {
                    // 输出详情
                    System.out.println("编号：" + f.id);
                    System.out.println("名称：" + f.name);
                    System.out.println("票价：" + f.price);
                    System.out.println("评分：" + f.Star);
                } else {
                    System.out.println("没有");
                }
            }
        }
    }
}
