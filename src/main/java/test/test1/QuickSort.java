package test.test1;

/**
 * @author zhoukx
 * @ClassName: QuickSort
 * @description: TODO
 * @date 2021/5/23
 */
public class QuickSort {

//    public class ShowMeBug {

        public static void quickSort(int a[], int low, int high) {
            // 递归终止条件
            if (low >= high) {
                return;
            }
            // 所选的点
            int key = a[low];
            int l = low;
            int r = high;
            while (l < r) {
                while (l < r && a[r] >= key) {
                    r--;
                }
                while (l < r && a[l] <= key) {
                    l++;
                }
                int temp = a[r];
                a[r] = a[l];
                a[l] = temp;
            }
            a[low] = a[l];
            a[l] = key;
            quickSort(a, low, l - 1);
            quickSort(a, l + 1, high);

        }
        public static void main(String[] args) {
            int a[] = { 46, 58, 15, 45, 90, 18, 10, 62, 46 };
            System.out.println("Before Sorting:");
            for (int i = 0; i < a.length; i++){
                System.out.print(a[i] + " ");
            }
//            System.out.println();
            quickSort(a, 0 ,a.length-1);
            System.out.println("After Sorting:");
            for (int i = 0; i < a.length; i++){
                System.out.print(a[i] + " ");
            }

        }
//    }


}
