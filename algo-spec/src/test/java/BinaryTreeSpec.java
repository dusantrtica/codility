import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import tree.BinaryTree;

public class BinaryTreeSpec {

  BinaryTree tree = new BinaryTree(new int[]{10, 15, 5, 2, 7, 12, 17, 1, 3, 11, 13, 16, 18});

  @Test
  public void findMin() {

    Assert.assertEquals(1, tree.min());
  }

  @Test
  public void findMax() {

    Assert.assertEquals(18, tree.max());
  }

  @Test
  public void preOrder() {

    List<Integer> result = List.of(10, 5, 2, 1, 3, 7, 15, 12, 11, 13, 17, 16, 18);
    Assert.assertArrayEquals(result.toArray(), tree.preOrder().toArray());
  }

  @Test
  public void preOrderIterative() {

    List<Integer> expected = List.of(10, 5, 2, 1, 3, 7, 15, 12, 11, 13, 17, 16, 18);
    Assert.assertArrayEquals(expected.toArray(), tree.preOrderIterative().toArray());
  }

  @Test
  public void inOrder() {

    List<Integer> expected = List.of(1, 2, 3, 5, 7, 10, 11, 12, 13, 15, 16, 17, 18);
    Assert.assertArrayEquals(expected.toArray(), tree.inOrder().toArray());
  }

  @Test
  public void inOrderIterative() {

    List<Integer> expected = List.of(1, 2, 3, 5, 7, 10, 11, 12, 13, 15, 16, 17, 18);
    Assert.assertArrayEquals(expected.toArray(), tree.inOrderIterative().toArray());
  }

  @Test
  public void postOrder() {

    List<Integer> expected = List.of(1, 3, 2, 7, 5, 11, 13, 12, 16, 18, 17, 15, 10);
    Assert.assertArrayEquals(expected.toArray(), tree.postOrder().toArray());
  }

  @Test
  public void postOrderIterative() {

    List<Integer> expected = List.of(1, 3, 2, 7, 5, 11, 13, 12, 16, 18, 17, 15, 10);
    Assert.assertArrayEquals(expected.toArray(), tree.postOrderIterative().toArray());
  }

  @Test
  public void predecessor() {
    Assert.assertEquals(3, tree.predecessor(5));
    Assert.assertEquals(5, tree.predecessor(7));
    Assert.assertEquals(15, tree.predecessor(16));
    Assert.assertEquals(10, tree.predecessor(11));
  }

  @Test
  public void successor() {
    Assert.assertEquals(7, tree.successor(5));
    Assert.assertEquals(5, tree.successor(3));
    Assert.assertEquals(11, tree.successor(10));
  }
}
