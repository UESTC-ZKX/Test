package test.vivo;


/**
 * @ClassName Phone
 * @Description: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 求前n项和
 * @Author UESTC-ZKX
 * @Date 2020/3/8
 **/
public class Phone {

    /**
     * @param n int整型 第n天
     * @return int整型
     */
    public int solution(int n) {
        // write code here
        int day = 0;
        int i = 1;
        for (; ; i++) {
            if (day + i >= n) {
                break;
            }
            day += i;
        }
        int sum = 0;
        for (int j = 1; j < i; j++) {
            sum += Math.pow(j, 2);
        }
        sum += (n - day) * (i);
        return sum;
    }

}
