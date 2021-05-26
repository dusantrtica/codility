package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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

  public void insert(int elem) {
    if (root == null) {
      root = new Node(elem);
    } else {
      root = this.insert(elem, root);
    }
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
    HashMap<Node, Boolean> visited = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      Node node = stack.peek();

      if (node.left != null && !visited.getOrDefault(node.left, false)) {
        stack.push(node.left);
        visited.put(node.left, true);
      } else {
        Node parent = stack.pop();

        result.add(parent.val);
        if (parent.right != null && !visited.getOrDefault(parent.right, false)) {
          stack.push(parent.right);
          visited.put(parent, true);
        }
      }
    }

    return result;
  }

  public List<Integer> postOrderIterative() {
    Stack<Node> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node node = stack.peek();
      if (node.left != null) {
        stack.push(node.left);
      } else {
        result.add(node.val);
        if (node.right != null) {
          stack.push(node.right);
        } else {
          result.add(node.val);
          stack.pop();
          stack.pop();
        }
      }
    }
    return result;
  }
}
