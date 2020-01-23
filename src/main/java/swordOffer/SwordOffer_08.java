package swordOffer;

/**
 * @ClassName SwordOffer_08
 * @Description:
 * 第八题
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Author UESTC-ZKX
 * @Date 2020/1/22
 **/
public class SwordOffer_08 {

    MyUtils myUtils = new MyUtils();

    // 暴力法
    public int minNumberInRotateArray(int [] array) {
        if(myUtils.isNull(array) || array.length == 0){
            return 0;
        }
        int res = array[0];
        for(int i : array){
            if(i < res){
                res = i;
            }
        }
        return res;
    }
    // 2分法
    public int minNumberInRotateArray_1(int[] array){
        if(myUtils.isNull(array) || array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        int mid;
        // 比较左右值
        if(array[left] < array[right]){
            return array[left];
        }
        else {
            while (left < right) {
                mid = (left + right) / 2;
                if (array[mid] > array[right]) {
                    left = mid;
                } else {
                    right = mid;
                }

                if (right == left + 1){
                    return array[right];
                }
            }
        }
        return 0;
    }
}
