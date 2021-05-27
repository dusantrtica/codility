import spock.lang.Specification
import tree.BinaryTree

public class BinaryTreeSpec1 extends  Specification{
    BinaryTree tree = new BinaryTree(new int[]{10, 15, 5, 2, 7, 12, 17, 1, 3, 11, 13, 16, 18});

    def "level order" () {
        when:
        def result = tree.levelOrder() as int [][]

        then:
        result == [[10],[5, 15], [2, 7, 12, 17], [1, 3, 11, 13, 16, 18]];
    }

    def "level order iteratively" () {
        when:
        def result = tree.levelOrderIter() as int [][]

        then:
        result == [[10],[5, 15], [2, 7, 12, 17], [1, 3, 11, 13, 16, 18]];
    }
}
