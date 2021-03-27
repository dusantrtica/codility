import spock.lang.Specification

class DiagonalTraverseSpec extends Specification {
    def "matrix 1x1"() {
        given:
        def diagonalTraverse = new DiagonalTraverse()
        def inputMatrix = [[1]] as int[][]

        when:
        def result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == [1]
    }

    def "matrix 1x2"() {
        given:
        def diagonalTraverse = new DiagonalTraverse()
        def inputMatrix = [[1, 2]] as int[][]

        when:
        def result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == [1, 2]
    }

    def "matrix 2 x 1"() {
        given:
        def diagonalTraverse = new DiagonalTraverse()
        def inputMatrix = [[1], [2]] as int[][]

        when:
        def result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == [1, 2]
    }

    def "matrix 2x2"() {
        given:
        def diagonalTraverse = new DiagonalTraverse()
        def inputMatrix = [[1, 2], [3, 4]] as int[][]

        when:
        def result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == [1, 2, 3, 4]
    }

    def "matrix 3x2"() {
        given:
        def diagonalTraverse = new DiagonalTraverse()
        def inputMatrix = [[1, 2, 3], [4, 5, 6]] as int[][]

        when:
        def result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == [1, 2, 4, 5, 3, 6]
    }

    def "matrix 2x3"() {
        given:
        def diagonalTraverse = new DiagonalTraverse()
        def inputMatrix = [[1, 2], [3, 4], [5, 6]] as int[][]

        when:
        def result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == [1, 2, 3, 5, 4, 6]
    }

    def "matrix 3x3"() {
        given:
        def diagonalTraverse = new DiagonalTraverse()
        def inputMatrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]] as int[][]

        when:
        def result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == [1, 2, 4, 7, 5, 3, 6, 8, 9]
    }

    def "empty matrix" () {
        given:
        def diagonalTraverse = new DiagonalTraverse();
        def inputMatrix = [[]] as int [][]

        when:
        result = diagonalTraverse.findDiagonalOrder(inputMatrix)

        then:
        result == []
    }
}

