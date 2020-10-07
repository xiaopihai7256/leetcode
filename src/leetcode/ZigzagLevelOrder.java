package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * date: 2020/10/7
 * description: 二叉树的锯齿形层次遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
 * @author xiaopihai7256
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> rootList = new LinkedList<>();
        rootList.add(root);
        addLevelOrder(result, rootList, true);
        return result;
    }

    public static void addLevelOrder(List<List<Integer>> result, LinkedList<TreeNode> nodes, boolean order) {
        if (nodes == null || nodes.size() <= 0) return;
        result.add(valueList(nodes, order));
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) nextLevel.add(node.left);
            if (node.right!= null) nextLevel.add(node.right);
        }
        addLevelOrder(result, nextLevel, !order);
    }

    static List<Integer> valueList(LinkedList<TreeNode> nodes, boolean order) {
        List<Integer> result = new ArrayList<>(nodes.size());
        if (order) {
            for (TreeNode node : nodes) {
                result.add(node.val);
            }
        } else {
            // 倒序
            Iterator<TreeNode> iterator = nodes.descendingIterator();
            while (iterator.hasNext()) {
                result.add(iterator.next().val);
            }
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
