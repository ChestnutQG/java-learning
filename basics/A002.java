/**
 * A002 —— switch 分支语句演示
 *
 * switch 语法：
 *   switch(表达式) {
 *       case 值1:
 *           代码;
 *           break;   // 跳出 switch，不写会继续穿透到下一个 case
 *       case 值2:
 *           代码;
 *           break;
 *       default:
 *           代码;     // 所有 case 都不匹配时执行
 *   }
 *
 * 支持类型：byte/short/int/char/String/枚举（不支持 long/float/double/boolean）
 *
 * 本例演示 case 穿透现象：如果某个 case 后面没有 break，
 * 会继续执行下一个 case 中的代码，直到遇到 break 或 switch 结束。
 */
public class A002 {
    public static void main(String[] args) {
        // 每日活动安排
        // 周一：埋头苦干          周五：今晚吃鸡
        // 周二：请求大牛帮忙      周六：相亲
        // 周三：啤酒龙虾          周日：准备上班
        // 周四：帮助新来的女程序

        String week = "周三";
        switch (week) {
            case "周一":
                System.out.println("埋头苦干，解决bug");
                break;                              // 有 break，正常跳出
            case "周二":
                System.out.println("请求大牛程序员帮忙");
                break;
            case "周三":
                System.out.println("今晚啤酒、龙虾、小烧烤");
                // 没有 break！会穿透到周四
            case "周四":
                System.out.println("主动帮助新来的女程序解决bug");
                // 没有 break！继续穿透到周五
            case "周五":
                System.out.println("今晚吃鸡");
                // 继续穿透到周六
            case "周六":
                System.out.println("与王婆介绍的小芳相亲");
                // 继续穿透到周日
            case "周日":
                System.out.println("郁郁寡欢、准备上班");
                // 继续穿透到 default
            default:
                System.out.println("您输入的星期信息不存在~~~");
        }
        System.out.println("switch之后");

        // 由于穿透，当 week="周三" 时，会输出周三到周日的所有内容 + default
    }
}
