package binarytrees;

public class TreeFromPreorderInorder {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private TreeNode buildTreeInternal(int [] preorder, int [] inorder, int inStart, int inEnd) {
    if(inStart > inEnd) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[inStart]);
    int index = indexOf(inorder, preorder[0], inStart, inEnd);
    node.left = buildTreeInternal(preorder, inorder, inStart, index);
    node.right = buildTreeInternal(preorder, inorder, index+1, inEnd);

    return node;
  }

  private int indexOf(int [] arr, int elem, int start, int end) {
    for(int i = start; i < end; i++) {
      if(arr[i] == elem) {
        return i;
      }
    }
    return  -1;
  }

  public TreeNode buildTree(int [] preorder, int[] inorder) {

    TreeNode root = buildTreeInternal(preorder, inorder, 0, inorder.length-1);

    return root;

  }
}
