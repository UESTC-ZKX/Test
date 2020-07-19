package test;

import java.util.*;

/**
 * @ClassName findTreeSum
 * @Description: TODO
 * @Author UESTC-ZKX
 * @Date 2020/3/7
 **/
public class FindTreeSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        String[] indexs = scanner.nextLine().split(",");
        scanner.close();
        if (strings.length == 0) {
            return;
        }
        TreeNode root = isNull(strings[0]) ? null : new TreeNode(Integer.parseInt(strings[0]));
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < strings.length; i += 2) {
            if (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                temp.left = isNull(strings[i]) ? null : new TreeNode(Integer.parseInt(strings[i]));
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (i + 1 < strings.length) {
                    temp.right = isNull(strings[i + 1]) ? null : new TreeNode(Integer.parseInt(strings[i + 1]));
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
            }
        }
        traversal(root);
        for (String s : indexs) {
            int index = Integer.parseInt(s);
            if (index < list.size()) {
                sum += list.get(index);
            } else {
                return;
            }
        }
        System.out.println(sum);
    }

    public static boolean isNull(String s) {
        return "null".equals(s);
    }

    public static void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}


