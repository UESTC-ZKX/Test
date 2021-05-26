package realTest.ths;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author zhoukx
 * @ClassName: MixArrays
 * @description:
 * 穷尽集合之间的元素组合
 * input: list of list
 *      [ [‘a’, ‘b’, ‘c’], [‘1’, ‘2’, ‘3’, ‘4’, ‘5’, ‘6’] , [‘A’, ‘B’, ‘C’, ‘D’] ]
 * output:
 *      [
 *      	[‘a’, ‘1’, ‘A’],
 *      	[‘a’, ‘1’, ‘B’],
 *      	[‘a’, ‘1’, ‘C’],
 *      	[‘a’, ‘1’, ‘D’],
 *      	...
 *      	[‘c’, ‘6’, ‘D’]
 *  ]
 * @date 2021/5/25
 */
public class CombinationProblem {

    public static ArrayList<ArrayList<String>> getSetCombination(ArrayList<ArrayList<String>> input) {

        // 校验参数合法性
        if(Objects.isNull(input) || input.size() == 1){
            return null;
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        // 初始化结果集
        for(String s : input.get(0)){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(s);
            res.add(temp);
        }
        // 从第二个向结果集中合并
        for (int i = 1; i < input.size(); i++) {
            res = mixArray(res, input.get(i));
        }
        return res;
    }

    /**
     * 取笛卡尔集
     * @param res 原结果集
     * @param list 待合并集合
     * @return 新结果集
     */
    public static ArrayList<ArrayList<String>> mixArray(ArrayList<ArrayList<String>> res, ArrayList<String> list) {
        ArrayList<ArrayList<String>> newRes = new ArrayList<>();
        for (ArrayList<String> arrayList : res) {
            for (String string : list) {
                // 深拷贝数组
                ArrayList<String> temp = new ArrayList<>(arrayList);
                temp.add(string);
                newRes.add(temp);
            }
        }
        return newRes;
    }

    public static void main(String [] args) {
        // 测试数据准备
        ArrayList<String> test1 = new ArrayList<>();
        ArrayList<String> test2 = new ArrayList<>();
        ArrayList<String> test3 = new ArrayList<>();
        for(char c = 'a'; c <= 'c'; c++){
            test1.add(String.valueOf(c));
        }
        for(char c = '1'; c <= '6'; c++){
            test2.add(String.valueOf(c));
        }
        for(char c = 'A'; c <= 'D'; c++){
            test3.add(String.valueOf(c));
        }
        ArrayList<ArrayList<String>> input = new ArrayList<>();
        input.add(test1);
        input.add(test2);
        input.add(test3);

        // 验证
        System.out.println(getSetCombination(input));
    }
}
