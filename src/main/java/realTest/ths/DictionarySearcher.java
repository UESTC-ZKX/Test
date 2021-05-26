package realTest.ths;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author zhoukx
 * @ClassName: DictionarySearcher
 * @description:
 * 字典查找的算法。
 *  input:
 *        1. input_file
 *           每一行有一个词汇，如“浙江”, “浙江大学”, “美国”, “美国政府”。该文件可能有100万词
 *        2. a document，字符串。一般有2000字左右。如 “美国规划协会中国办公室揭牌仪式及美国规划领域合作研讨会在浙江大学城乡规划设计研究院208会议室举行。
 *        美国规划协会CEO James Drinan，国际项目及外联主任Jeffrey Soule先生，浙江大学党委副书记任少波，浙江大学控股集团领导杨其和，西湖区政府代表应权英副主任....”
 *
 * output:
 *        输出document中出现的词汇,以及其位置列表。如
 *           {
 *              “美国” : [ 0,16, ....],
 *               “浙江”: [28, ...]
 *                “浙江大学”: [28, ...]
 *           }
 *
 *  实现下面的方法， 尽量优化算法的时间复杂度：
 * @date 2021/5/25
 */
public class DictionarySearcher {

    public static HashMap<String, ArrayList<Integer>> res = new HashMap<>();
    private static String keyword = null;

    public DictionarySearcher(String filename, String document) throws Exception {
        InputStreamReader in = new InputStreamReader(new FileInputStream(new File(filename)));
        BufferedReader br = new BufferedReader(in);
        keyword = br.readLine();
        // 滑动读取，避免一次性读入内存
        while (Objects.nonNull(keyword)){
            search(document);
            keyword = br.readLine();
        }
        br.close();
    }

    public HashMap<String, ArrayList<Integer>> search(String document) {
        if(document == null){
            return null;
        }
        ArrayList<Integer> indexList = new ArrayList<>();
        int index = document.indexOf(keyword);
        while(index>-1) {
            indexList.add(index);
            index = document.indexOf(keyword, index + 1);;
        }
        res.put(keyword, indexList);

        return res;
    }

    public static void main(String [] args) throws Exception{

        // 测试数据准备
        String document = "美国规划协会中国办公室揭牌仪式及美国规划领域合作研讨会在浙江大学城乡规划设计研究院208会议室举行。" +
                "美国规划协会CEO James Drinan，国际项目及外联主任Jeffrey Soule先生，浙江大学党委副书记任少波，浙江大学控股集团领导杨其和，西湖区政府代表应权英副主任....";
        String filename = "C:\\APP\\Study\\Projects\\Test\\src\\main\\java\\realTest\\ths\\keyword.txt";
        new DictionarySearcher(filename, document);
        System.out.println(res);
    }
}
