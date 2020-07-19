package test.byteDance;

import java.util.*;

/**
 * @ClassName FindUserType
 * @Description:
 *
 * @Author UESTC-ZKX
 * @Date 2020/3/15
 **/
public class FindUserType {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // key模板文件，value用户类型
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if(n == 0){
            return;
        }
        while (n-- > 0){
            list.add(scanner.nextLine());
        }
        scanner.close();
        for(String s : list){
            String[] strings = s.split(" ");
            if(strings.length != 2){
                return;
            }
            if(map.containsKey(strings[1])){
                map.get(strings[1]).add(strings[0]);
            }
            else {
                map.put(strings[1],new ArrayList<String>(){{
                    add(strings[0]);
                }});
            }
        }
        for(String s : map.keySet()){
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> arrayList = map.get(s);
            Collections.sort(arrayList);
            for(String s1 : arrayList){
                stringBuilder.append(s1).append(" ");
            }
            System.out.println(s+" "+stringBuilder.toString());
        }
    }
}
