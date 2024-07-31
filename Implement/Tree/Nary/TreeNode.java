package Implement.Tree.Nary;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    List<TreeNode> children;

    TreeNode(int data) {
        this.data = data;
        children = new ArrayList<>();
    }
}