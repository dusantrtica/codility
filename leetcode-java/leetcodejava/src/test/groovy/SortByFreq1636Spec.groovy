import spock.lang.Specification

class SortByFreq1636Spec extends Specification {
    SortByFreq1636 task = new SortByFreq1636()

    def "case 1"() {
        given:
        def input = [1, 1, 2, 2, 2, 3] as int[]

        when:
        def result = task.frequencySort(input)

        then:
        result == [3, 1, 1, 2, 2, 2]
    }

    def "case 2"() {
        given:
        def input = [2, 3, 1, 3, 2] as int[]

        when:
        def result = task.frequencySort(input)

        then:
        result == [1, 3, 3, 2, 2]
    }

    def "case 3"() {
        given:
        def input = [-1, 1, -6, 4, 5, -6, 1, 4, 1] as int[]

        when:
        def result = task.frequencySort(input)

        then:
        result == [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
