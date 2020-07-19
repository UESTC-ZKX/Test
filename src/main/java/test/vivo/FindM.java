package test.vivo;

/**
 * @ClassName FindM
 * @Description: 找到最小的M，使得各位之和等于n
 * @Author UESTC-ZKX
 * @Date 2020/3/8
 **/
public class FindM {

    /**
     * 输入一个整形数值，返回一个整形值
     *
     * @param n int整型 n>9
     * @return int整型
     */
    public int solution(int n) {
        int j = 1;
        for (; ; j++) {
            if (Math.pow(9, j) <= n && Math.pow(9, j + 1) > n) {
                break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (j-- > 0) {
            stringBuilder.append(9);
        }
        // write code here
        int i = 0;
        for (i = Integer.parseInt(stringBuilder + ""); ; i++) {
            if (findSum(i) == n) {
                break;
            }
        }
        return i;
    }

    private int findSum(int n) {
        String string = Integer.valueOf(n).toString();
        int res = 1;
        for (char c : string.toCharArray()) {
            res *= Integer.parseInt(c + "");
        }
        return res;
    }

}
