package example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @ClassName CastExample
 * @Description: TODO
 * @Author UESTC-ZKX
 * @Date 2020/1/22
 **/
public class CastExample {
        public static void main(String[] args) {
            int[] data = {4, 5, 3, 6, 2, 5, 1};
            /**
             *  int[] 转 List<Integer>
             *  Arrays.stream(arr) 可以替换成IntStream.of(arr)。
             *  1.使用Arrays.stream将int[]转换成IntStream。
             *  2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
             *  3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
             */
            List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());

            /**
             * int[] 转 Integer[]
             * 前两步同上，此时是Stream<Integer>。
             * 然后使用Stream的toArray，传入IntFunction<A[]> generator。
             * 这样就可以返回Integer数组。
             * 不然默认是Object[]。
             */
            Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);

            /**
             *  List<Integer> 转 Integer[]
             *  调用toArray。传入参数T[] a。这种用法是目前推荐的。
             *  List<String>转String[]也同理。
             */
            Integer[] integers2 = list1.toArray(new Integer[0]);

            /**
             *  List<Integer> 转 int[]
             *  想要转换成int[]类型，就得先转成IntStream。
             *  这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
             *  而IntStream中默认toArray()转成int[]。
             */
            int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

            /**
             *  Integer[] 转 int[]
             */
            int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();

            /**
             * Integer[] 转 List<Integer>
             * 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。
             */
            List<Integer> list2 = Arrays.asList(integers1);

            /*********** 最简单的方式。String[]转List<String>也同理。***********/
            // 同理
            String[] strings1 = {"a", "b", "c"};
            // String[] 转 List<String>
            List<String> list3 = Arrays.asList(strings1);
            // List<String> 转 String[]
            String[] strings2 = list3.toArray(new String[0]);
        }
 }

