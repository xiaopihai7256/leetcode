package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * date: 2020/8/19
 * description: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @author xiaopihai7256
 */
public class LevelOrder {

    /**
     * 2ms
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new LinkedList<>();
        addLevelOrder(result, Collections.singletonList(root));
        return result;
    }

    public static void addLevelOrder(List<List<Integer>> result, List<TreeNode> nodes) {
        if (nodes == null || nodes.size() <= 0) return;
        result.add(valueList(nodes));
        List<TreeNode> nextLevel = new LinkedList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) nextLevel.add(node.left);
            if (node.right!= null) nextLevel.add(node.right);
        };
        addLevelOrder(result, nextLevel);
    }

    static List<Integer> valueList(List<TreeNode> nodes) {
        List<Integer> result = new ArrayList<>(nodes.size());
        for (TreeNode node : nodes) {
            result.add(node.val);
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
