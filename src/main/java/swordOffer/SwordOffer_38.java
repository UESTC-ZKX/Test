package swordOffer;

/**
 * @ClassName SwordOffer_38
 * @Description:
 * 第三十八题
 * 统计一个数字在排序数组中出现的次数。
 * @Author UESTC-ZKX
 * @Date 2020/2/16
 **/
public class SwordOffer_38 {

    public int GetNumberOfK(int [] array , int k) {
        int res = 0;
        if(array.length == 0){
            return res;
        }
        int index = halfSearch(array, k, 0, array.length-1);
        if(index == -1){
            return res;
        }
        else {
            for(int left = index; left >= 0 && array[left] == k; left--){
                res++;
            }
            for(int right = index; right < array.length && array[right] == k; right++){
                res++;
            }
        }
        return res-1;
    }

    /**
     * 二分查找
     * @param array 有序数组
     * @param k     目标值
     * @param left  左下标
     * @param right 右下标
     * @return 目标值下标（-1为未找到）
     */
    private int halfSearch(int[] array, int k, int left, int right){
        // 递归终止条件
        int mid = (left+right) / 2;
        if(array[mid] == k){
            return mid;
        }
        if(left >= right){
            return -1;
        }
        if(array[mid] < k){
            return halfSearch(array, k, mid+1, right);
        }
        else {
            return halfSearch(array, k, left, mid);
        }
    }

}
