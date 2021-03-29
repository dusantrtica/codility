import spock.lang.Specification

class SpiralMatrixSpec extends Specification {

    SpiralMatrix spiralMatrix = new SpiralMatrix()

    def "empty matrix"() {
        given:
        def inputMatrix = [[]] as int[][]

        when:
        def result = spiralMatrix.spiralOrder(inputMatrix)

        then:
        result == []
    }

    def "matrix 1 x 1"() {
        given:
        def inputMatrix = [[1]] as int[][]

        when:
        def result = spiralMatrix.spiralOrder(inputMatrix)

        then:
        result == [1]
    }

    def "matrix 1 x 3"() {
        given:
        def inputMatrix = [[1, 2, 3]] as int[][]

        when:
        def result = spiralMatrix.spiralOrder(inputMatrix)

        then:
        result == [1, 2, 3]
    }

    def "matrix 2 x 3"() {
        given:
        def inputMatrix = [[1, 2, 3], [4, 5, 6]] as int[][]

        when:
        def result = spiralMatrix.spiralOrder(inputMatrix)

        then:
        result == [1, 2, 3, 6, 5, 4]
    }

    def "matrix 3 x 3"() {
        given:
        def inputMatrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]] as int[][]

        when:
        def result = spiralMatrix.spiralOrder(inputMatrix)

        then:
        result == [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
