package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.apache.commons.lang.NotImplementedException;

class Node {

  public int val;
  public Node left;
  public Node right;

  public Node(int val) {
    this.val = val;
  }
}

public class BinaryTree {

  private Node root;

  public BinaryTree(int[] elements) {
    Arrays.stream(elements).forEach(e -> insert(e));
  }

  private Node insert(int val, Node node) {
    if (node == null) {
      return new Node(val);
    } else if (val < node.val) {
      node.left = insert(val, node.left);
    } else {
      node.right = insert(val, node.right);
    }
    return node;
  }

  public void delete(int elem) {
    /*
    deletes element
    if(elem is leaf), simply remove it
    if(elem has one child) that child becomes new parent
    if(elem nas 2 children) then, we find elem's predecessor which becomes new parent
     */
    throw new NotImplementedException("Not implemented");
  }

  public int select(int i) {
    /*
    (select ith smallest value)
    Idea:
    Augment tree with size value. size(x) = # of nodes in subtree rooted at x
    size(x) = size(y) +size(z) + 1 (y and z are left and right children)
    a = size(y)
    if(a == i-1) return x's key
    if(a >= i) recursively compute ith order stat. rooted at y
    if(a < i-1) recursively compute (i-a-1)th order rooted at z
     */

    throw new NotImplementedException("Not implemented");
  }

  public void insert(int elem) {
    if (root == null) {
      root = new Node(elem);
    } else {
      root = this.insert(elem, root);
    }
  }

  private void levelOrder(Node node, int level, List<List<Integer>> result) {
    if (node == null) {
      return;
    }

    List<Integer> arrayLevel;
    try {
      arrayLevel = result.get(level);
    } catch (IndexOutOfBoundsException e) {
      arrayLevel = new ArrayList<Integer>();
      result.add(level, arrayLevel);
    }

    arrayLevel.add(node.val);

    levelOrder(node.left, level + 1, result);
    levelOrder(node.right, level + 1, result);
  }

  public List<List<Integer>> levelOrderIter() {
    List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    if(root != null) {
      queue.add(root);
    }
    while(!queue.isEmpty()) {
      List<Integer> subResult = new LinkedList<>();
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        Node curr = queue.poll();
        subResult.add(curr.val);
        if(curr.left != null) {
          queue.add(curr.left);
        }

        if(curr.right != null) {
          queue.add(curr.right);
        }
      }
      result.add(subResult);
    }
    return result;
  }

  public List<List<Integer>> levelOrder() {
    List<List<Integer>> result = new ArrayList<>();
    levelOrder(root, 0, result);
    return result;
  }

  public int min() {
    Node node = root;
    while (node.left != null) {
      node = node.left;
    }
    return node.val;
  }

  public int max() {
    Node node = root;
    while (node.right != null) {
      node = node.right;
    }
    return node.val;
  }

  public void preOrder(Node node, List<Integer> results) {
    results.add(node.val);
    if (node.left != null) {
      preOrder(node.left, results);
    }
    if (node.right != null) {
      preOrder(node.right, results);
    }
  }

  public List<Integer> preOrder() {
    List<Integer> result = new ArrayList<>();
    preOrder(root, result);
    return result;
  }

  private void postOrder(Node node, List<Integer> result) {
    if (node.left != null) {
      postOrder(node.left, result);
    }
    if (node.right != null) {
      postOrder(node.right, result);
    }
    result.add(node.val);
  }

  public List<Integer> postOrder() {
    List<Integer> result = new ArrayList<>();
    postOrder(root, result);
    return result;
  }

  private void inOrder(Node node, List<Integer> result) {
    if (node.left != null) {
      inOrder(node.left, result);
    }
    result.add(node.val);

    if (node.right != null) {
      inOrder(node.right, result);
    }
  }

  public List<Integer> inOrder() {
    List<Integer> result = new ArrayList<>();
    inOrder(root, result);
    return result;
  }

  public List<Integer> preOrderIterative() {
    Stack<Node> stack = new Stack<>();
    HashMap<Node, Boolean> visited = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node node = stack.pop();
      result.add(node.val);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return result;
  }

  public List<Integer> inOrderIterative() {
    Stack<Node> stack = new Stack<Node>();
    List<Integer> result = new ArrayList<>();
    Node curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      result.add(curr.val);
      curr = curr.right;
    }

    return result;
  }

  public List<Integer> postOrderIterative() {
    Stack<Node> stack = new Stack<>();
    Stack<Integer> stackedResult = new Stack<>();
    List<Integer> result = new ArrayList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      stackedResult.push(node.val);
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }

    while (!stackedResult.isEmpty()) {
      result.add(stackedResult.pop());
    }
    return result;
  }

  public int successor(int k) {
    Stack<Node> nodesAllTheWayToK = new Stack<>();
    Node curr = root;
    while (true) {
      if (curr == null || curr.val == k) {
        break;
      } else if (curr.val < k) {
        nodesAllTheWayToK.push(curr);
        curr = curr.right;
      } else {
        nodesAllTheWayToK.push(curr);
        curr = curr.left;
      }
    }

    if (curr.right != null) {
      curr = curr.right;
      while (curr.left != null || curr.right != null) {
        if (curr.left != null) {
          curr = curr.left;
        } else {
          curr = curr.right;
        }
      }
      return curr.val;
    } else {
      while (true) {
        Node parent = nodesAllTheWayToK.pop();
        if (parent.val > k) {
          return parent.val;
        }
      }
    }
  }

  public int predecessor(int k) {
    // easy case: if k's left subtree is non empty, then find the biggest element of k's left subtree (rightmost element of it)
    // else: follow parents from K to the root and find the first  key that is less then K
    Stack<Node> nodesAllTheWayToK = new Stack<>();
    Node curr = root;
    while (true) {
      if (curr == null || curr.val == k) {
        break;
      } else if (curr.val < k) {
        nodesAllTheWayToK.push(curr);
        curr = curr.right;
      } else {
        nodesAllTheWayToK.push(curr);
        curr = curr.left;
      }
    }
    if (curr.left != null) {
      curr = curr.left;
      while (curr.left != null || curr.right != null) {
        if (curr.right != null) {
          curr = curr.right;
        } else {
          curr = curr.left;
        }
      }
      return curr.val;
    } else {
      while (true) {
        Node parent = nodesAllTheWayToK.pop();
        if (parent.val < k) {
          return parent.val;
        }
      }
    }
  }
}
