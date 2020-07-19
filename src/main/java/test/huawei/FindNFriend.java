package test.huawei;

import java.util.*;

/**
 * @ClassName FindNFriend
 * @Description: 有一款社交软件 APP,假说注朋用户m人(0<m<50),
 * 用编号为 0~m-1,r[i,j]表示用i 和用户j 好友关系(r[i][j]=0 代表i和j不是好友，
 * r[i][j]=1~9 代表是好友目数值代表熟悉程度,数值越大代表越熟悉,
 * 其中r[i][j]=r[j][i],0<=i,j<=m-1)试编制程序,输出某个特定用户i的n 度好
 * 友(1 度好友代表直接好友,2 度好友代表好友的好友,以此类推1<=n<=10),
 * 并按推荐值降序输出好友列表(推荐值相同的好友,
 * 按好友编号升序,其中推荐值是指关系熟活度之和,比如朋户i和j是好友，
 * 且熟悉度r[i][j]=4 ，j和k是好友且熟活度小r[j][k]=6，
 * 且i和k 不是好友即r[i][k]=0，
 * 则用户k 是用户i的2 度好友且推荐值为可r[i][j]+r[j][k]=10),
 * 如果此用户i 没有n 度好友输出-1。
 * <p>
 * 输入描述：
 * <p>
 * 输入一个整数T,表示有T组测试数据（0<T<100）。
 * <p>
 * 对于每组测试数据输入2行，
 * <p>
 * 第1行     输入3 个整型数 m,i,n 分别代表用户数 m,某个用户编号 i,n度好友, 
 * 即代表本组测试需要输出用户i的n度好友
 * 第2 行    输入1 个整型数 k,接下来 3*k 个整数用空格隔开,
 * 每三个组成关系对,每个关系由3 个整型数组成 i,j,w 代表用户主和的熟悉程度,
 * 即 r[i][j]=w，没有输入的关系默认为非好友（r[i][j]=r[j][i]=0）
 * <p>
 * 输出描述：
 * <p>
 * 输出T行,每行对应每组测试数据的用户i的n 度好友,按推荐值降序输出,
 * 推荐值相同的好友按好友编号升序,编号间用空格隔开。如果没有n 度好友输出-1
 * <p>
 * 示例输入：
 * <p>
 * 2
 * <p>
 * 10 5 2
 * <p>
 * 13 0 3 5 0 4 9 0 6 8 0 7 5 1 2 6 1 6 1 2 9 7 3 4
 * <p>
 *   3 3 5 3 3 8 3 3 9 3 5 8 9 7 8 9
 * <p>
 * 10 0 2
 * <p>
 * 13 0 3 5 0 4 9 0 6 8 0 7 5 1 2 6 1 6 1 2 9 7 3 4
 * <p>
 *   3 3 5 3 3 8 3 3 9 3 5 8 9 7 8 9
 * <p>
 * 示例输出：
 * <p>
 * 7 0 4 9
 * <p>
 * 1 5 8 9
 * @Author UESTC-ZKX
 * @Date 2020/2/27
 **/
public class FindNFriend {

    // 关系矩阵
    private static int[][] r;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        while (n-- > 0 && scanner.hasNextLine()) {
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            // 用#标识字符串分割
            list.add(string1 + "#" + string2);
        }
        scanner.close();

        for (String s : list) {
            String[] strings = s.split("#");
            if (strings.length < 2) {
                return;
            }
            handle(strings[0], strings[1]);
        }

    }

    private static void handle(String s1, String s2) {
        String[] strings1 = s1.split(" ");
        if (strings1.length < 3) {
            return;
        }
        // 人数，第i个人，n度好友
        int m = Integer.parseInt(strings1[0]);
        int i = Integer.parseInt(strings1[1]);
        int n = Integer.parseInt(strings1[2]);

        r = new int[m][m];
        String[] strings2 = s2.split(" ");
        int k = Integer.parseInt(strings2[0]);
        // 初始化
        for (int j = 1; j < 3 * k; j += 3) {
            int x = Integer.parseInt(strings2[j]);
            int y = Integer.parseInt(strings2[j + 1]);
            int value = Integer.parseInt(strings2[j + 2]);
            r[x][y] = value;
            r[y][x] = value;
        }

        // 以i为根开始
        Map<Integer, Integer> res = traversal(i, n);
        if (res.isEmpty()) {
            System.out.println(-1);
        } else {
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(res.entrySet());
            list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if (o2.getValue().compareTo(o1.getValue()) == 0) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }
            });
            // 存结果
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Integer> mapping : list) {
                stringBuilder.append(mapping.getKey()).append(" ");
            }
            System.out.println(stringBuilder + "");
        }
    }

    /**
     * i的n度好友list
     *
     * @param i 第i个人
     * @param n n度
     * @return
     */
    private static Map<Integer, Integer> traversal(int i, int n) {
        // 人的编号为key，推荐值为value
        List<Map<Integer, Integer>> temp = new ArrayList<>();

        Map<Integer, Integer> first = new HashMap<>();
        first.put(i, 0);
        temp.add(first);

        Set<Integer> set = new HashSet<Integer>() {{
            add(i);
        }};

        for (int j = 0; j < n; j++) {
            if (temp.size() - 1 <= j) {
                temp.add(new HashMap<>());
            }
            for (int a : temp.get(j).keySet()) {
                Map<Integer, Integer> map = temp.get(j);
                for (int b = 0; b < r.length; b++) {
                    if (r[a][b] > 0) {
                        if (!set.contains(b)) {
                            temp.get(j + 1).put(b, map.get(a) + r[a][b]);
                            set.add(b);
                        }
                    }
                }
            }
        }
        return temp.get(n);
    }
}
