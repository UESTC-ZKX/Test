package test;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author zhoukx
 * @ClassName: TreeMapTest
 * @description:
 * @date 2020/9/1
 */
public class TreeMapTest {

    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            // -1 升序 1 降序
            if (i1 < i2) return 1;
            if (i1 > i2) return -1;
            return 0;
        }
    };

//    TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(comparator);

}
