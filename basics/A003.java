/**
 * A003 —— switch 注意事项 & 穿透性的合理利用
 *
 * 注意事项：
 *   1. 表达式只支持 byte/short/int/char/String/枚举
 *   2. case 值不能重复，且必须是字面量或常量
 *   3. 正常使用必须写 break，否则会穿透
 *
 * 穿透性的妙用：
 *   多个 case 共享同一段代码时，可以故意省略 break，
 *   让它们"穿透"到同一段逻辑。比如：周二三四做同一件事。
 */
public class A003 {
    public static void main(String[] args) {
        /*
        // ===== 注意事项演示 =====
        // 1. switch 不支持 double/float/long
        int a = 10;
        double b = 0.1;
        double b2 = 0.2;
        double c = b + b2;  // 浮点数有精度问题，0.1+0.2 != 0.3
        System.out.println(c);
        switch (a) { }  // int 可以

        // 2. case 值不能重复
        int i = 20;
        int d = 20;
        switch (i) {
            case 10: break;
            case 20: break;  // 只能有一个 case 20
        }

        // 3. 不写 break 会穿透
        String week = "周三";
        switch (week) {
            case "周一":
                System.out.println("埋头苦干，解决bug"); break;
            case "周二":
                System.out.println("请求大牛程序员帮忙");
                // 没有 break → 会继续输出"周三"
            case "周三":
                System.out.println("今晚啤酒、龙虾、小烧烤");
                // 没有 break → 会继续输出"周四"
            case "周四":
                System.out.println("主动帮助新来的女程序解决bug"); break;
            case "周五":
                System.out.println("今晚吃鸡"); break;
            case "周六":
                System.out.println("与王婆介绍的小芳相亲"); break;
            case "周日":
                System.out.println("郁郁寡欢、准备上班"); break;
            default:
                System.out.println("您输入的星期信息不存在~~~");
        }
        */

        // ===== 穿透性的合理利用 =====
        // 周二、周三、周四做同一件事 → 让它们穿透到一起
        String week = "周五";
        switch (week) {
            case "周一":
                System.out.println("埋头苦干，解决bug");
                break;
            case "周二":
            case "周三":
            case "周四":                              // 这三个 case 共享下面的代码
                System.out.println("请求大牛程序员帮忙");
                break;
            case "周五":
                System.out.println("自己整理代码");
                break;
            case "周六":
            case "周日":                              // 周末共享代码
                System.out.println("打游戏");
                break;
            default:
                System.out.println("您输入的星期信息不存在~~~");
        }
    }
}
