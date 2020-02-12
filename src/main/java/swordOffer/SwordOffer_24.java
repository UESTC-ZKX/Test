package swordOffer;

/**
 * @ClassName SwordOffer_24
 * @Description:
 * 第二十四题
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * @Author UESTC-ZKX
 * @Date 2020/2/4
 **/
public class SwordOffer_24 {
    MyUtils myUtils = new MyUtils();
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(myUtils.isNull(sequence) || sequence.length == 0){
            return false;
        }
        return verify(sequence, 0, sequence.length-1);
    }
    // 递归判断
    private Boolean verify(int[] sequence, int left, int right){
        //递归终止条件
        if(left >= right){
            return true;
        }
        // 根节点
        int root = sequence[right];
        int index;
        for(index = left ; index < right; index++){
            if (sequence[index] > root){
                break;
            }
        }
        int temp = index;
        while (index < right){
            if(sequence[index++] <= root){
                return false;
            }
        }
        return verify(sequence, left, temp-1)
                && verify(sequence, temp, right-1);
    }

}
