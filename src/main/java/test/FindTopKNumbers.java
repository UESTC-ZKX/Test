package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * @ClassName Factorial
 * @Description: 找出文件中数字里，最大的前N个数值
 * numberFile 存有数字的文件，每一行是一个int数字
 * opMax 要查最大的前多少个
 * @Author UESTC-ZKX
 * @Date 2019/1/18
 **/
public class FindTopKNumbers {
    static String path = "E:\\numbers.txt";

    static void swap(int max[], int i, int j) {                //交换函数
        int temp = max[i];
        max[i] = max[j];
        max[j] = temp;
    }

    static int findMinChild(int max[], int father, int topMax) {            //找到较小的子节点
        int lChild = 2 * father + 1;
        int rChild = lChild + 1;
        if (lChild == topMax - 1) return lChild;
        else {
            if (max[lChild] < max[rChild]) return lChild;
            else return rChild;
        }
    }

    static void down(int max[], int father, int topMax) {            //向下替换
        int minChild;
        while (father < topMax / 2) {
            minChild = findMinChild(max, father, topMax);
            if (max[father] > max[minChild]) {
                swap(max, father, minChild);
                father = minChild;
            } else break;
        }
    }

    static void up(int max[], int Child) {        //当小于topMax（100）时，从下向上插入扩大堆。
        int father = (Child - 1) / 2;                    //通过子节点算出父节点下标
        while (father >= 0) {                        //父节点不空时循环
            if (max[Child] < max[father]) {            //将小的向上置换
                swap(max, Child, father);
                Child = father;
                father = (father - 1) / 2;
                if (Child == 0) break;
            } else break;
        }
    }

    public static int[] findTopKNumbers(File numberFile, int topMax) throws IOException {
        Reader r = new InputStreamReader(new FileInputStream(numberFile));
        BufferedReader br = new BufferedReader(r);
        String line = "";
        line = br.readLine();
        int temp = 0;                                //监视计数器
        int max[] = new int[topMax];                //工作堆
        int cache = 0;                                //大于topMax（100）后的缓存
        while (line != null) {                        //逐行读取文件
            if (temp < topMax) {
                max[temp] = Integer.parseInt(line);
                up(max, temp);
                temp++;
            } else {
                cache = Integer.parseInt(line);

                if (cache > max[0]) {
                    max[0] = cache;
                    down(max, 0, topMax);
                }
            }
            line = br.readLine();
        }
        br.close();
        Arrays.sort(max);
        return max;
    }

    public static void main(String[] args) throws IOException {
        File f = new File(path);
        int max[] = new int[100];
        long startTime = System.currentTimeMillis();
        max = findTopKNumbers(f, 100);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        for (int i : max) {
            System.out.println(i);
        }
    }
}
