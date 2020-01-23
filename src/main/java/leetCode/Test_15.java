//package leetCode;
//
//import java.util.*;
//
///**
// * @author ZKX
// * @description leetCode 15
// * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
// *
// * 注意：答案中不可以包含重复的三元组。
// *
// * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
// *
// * 满足要求的三元组集合为：
// * [
// *   [-1, 0, 1],
// *   [-1, -1, 2]
// * ]
// */
//public class Test_15 {
//
//    public static void main(String[] args){
//        int[] array = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//        List list = threeSum(array,0);
//        // List list = threeSum1(array);
//        System.out.println(list);
//    }
//
//    public static List<List<Integer>> threeSum(int[] nums, int target) {
//        if(nums == null){
//            return null;
//        }
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        for (int i = 0; i < nums.length; i++){
//            List<List<Integer>> temp = twoSum(nums,target - nums[i], i);
//            for(List<Integer> list : temp) {
//                if (null != temp && !isExist(result, list)) {
//                    result.add(list);
//                }
//            }
//        }
//        return result;
//    }
//
//    public static List<List<Integer>> twoSum(int[] nums, int target, int index) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(i == index){
//                continue;
//            }
//            int temp = target - nums[i];
//            List<Integer> list = new ArrayList<Integer>();
//            if(map.containsKey(temp)){
//                list.add(temp);
//                list.add(nums[i]);
//                list.add(nums[index]);
//                result.add(list);
//            }
//            map.put(nums[i], i);
//        }
//        return result;
//    }
//    public static boolean isExist(List<List<Integer>> result, List<Integer> temp){
//
//        for(List<Integer> l : result){
//            if(l.contains(temp.get(0)) && l.contains(temp.get(1)) && l.contains(temp.get(2))
//                    && temp.contains(l.get(0)) && temp.contains(l.get(1)) && temp.contains(l.get(2))){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // 暴力法
//    public static List<List<Integer>> threeSum1(int[] nums) {
//        if(nums == null){
//            return null;
//        }
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        int length = nums.length;
//        for(int i = 0; i < length - 2; i++){
//                        for(int j = i + 1; j < length - 1; j++){
//                                    temp.add(nums[j]);
//                                    temp.add(nums[k]);
//                                    for(int k = j + 1; k < length; k++){
//                                        if(nums[i] + nums[j] + nums[k] == 0){
//                                            List<Integer> temp = new ArrayList<Integer>();
//                                            temp.add(nums[i]);
//                        if(null != temp && !isExist(result,temp)){
//                            result.add(temp);
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}