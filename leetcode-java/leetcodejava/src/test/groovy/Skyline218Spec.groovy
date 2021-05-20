import spock.lang.Specification

class Skyline218Spec extends Specification {
    Skyline218 skyline = new Skyline218()

    def "case 1"() {
        given:
        def input = [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]] as int[][]

        when:
        def result = skyline.getSkyline(input)

        then:
        result == [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]
    }

    def "case 2"() {
        given:
        def input = [[0, 2, 3], [2, 5, 3]] as int[][]

        when:
        def result = skyline.getSkyline(input)

        then:
        result == [[0, 3], [5, 0]]
    }
}
