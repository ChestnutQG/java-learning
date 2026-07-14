import java.util.Random;

/**
 * ID —— 随机验证码生成器
 *
 * 功能：生成指定位数的验证码，每位的字符随机来自：
 *   - 数字 0~9（ASCII 48~57）
 *   - 大写字母 A~Z（ASCII 65~90）
 *   - 小写字母 a~z（ASCII 97~122）
 *
 * 知识点：
 *   - Random 随机数
 *   - ASCII 码与 char 的转换
 *   - StringBuilder 拼接
 *   - switch 控制字符类型选择
 */
public class ID {

    public static void main(String[] args) {
        // 测试不同长度的验证码
        String code1 = a(4);
        System.out.println("4位验证码：" + code1);

        String code2 = a(6);
        System.out.println("6位验证码：" + code2);

        String code3 = a(8);
        System.out.println("8位验证码：" + code3);
    }

    /**
     * 生成指定位数的随机验证码
     * @param n 验证码长度
     * @return n 位验证码字符串
     */
    public static String a(int n) {
        Random random = new Random();
        StringBuilder a = new StringBuilder();  // 存储生成的验证码

        for (int i = 0; i < n; i++) {
            int type = random.nextInt(3);  // 随机字符类型：0=数字, 1=大写, 2=小写

            switch (type) {
                case 0:
                    // 随机数字：'0' 的 ASCII 是 48，random.nextInt(10) 生成 0~9
                    char digit = (char) (random.nextInt(10) + '0');
                    a.append(digit);
                    break;
                case 1:
                    // 随机大写字母：'A' 的 ASCII 是 65，random.nextInt(26) 生成 0~25
                    char upper = (char) (random.nextInt(26) + 'A');
                    a.append(upper);
                    break;
                case 2:
                    // 随机小写字母：'a' 的 ASCII 是 97
                    char lower = (char) (random.nextInt(26) + 'a');
                    a.append(lower);
                    break;
            }
        }

        return a.toString();  // StringBuilder → String
    }
}
