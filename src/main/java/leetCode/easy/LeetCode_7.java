package leetCode.easy;

/**
 * @ClassName LeetCode_7
 * @Description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−231,  231 − 1]。请根据这个假设，
 * 如果反转后整数溢出那么就返回 0。
 * @Author UESTC-ZKX
 * @Date 2020/3/15
 **/
public class LeetCode_7 {

    public int reverse(int x) {

        int res = 0;
        char[] chars = Integer.toString(x).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = chars.length-1; i >= 0; i--){
            char c = chars[i];
            if(c != '-') {
                stringBuilder.append(c);
            }
            else {
                stringBuilder.insert(0, '-');
            }
        }try {
            res = Integer.parseInt(stringBuilder.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return res;
    }

}
