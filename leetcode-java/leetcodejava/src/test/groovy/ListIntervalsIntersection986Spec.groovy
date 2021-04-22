import spock.lang.Specification

class ListIntervalsIntersection986Spec extends Specification {
    ListIntervalsIntersection986 task = new ListIntervalsIntersection986()

    def "case 1"() {
        given:
        def firstList = [[0, 2], [5, 10], [13, 23], [24, 25]] as int[][]
        def secondList = [[1, 5], [8, 12], [15, 24], [25, 26]] as int[][]

        when:
        def result = task.intervalIntersection(firstList, secondList) as int[][]

        then:
        result == [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]
    }

    def "case 2"() {
        given:
        def firstList = [[1, 3], [5, 9]] as int[][]
        def secondList = [] as int[][]

        when:
        def result = task.intervalIntersection(firstList, secondList) as int[][]

        then:
        result == []
    }

    def "case 3"() {
        given:
        def firstList = [] as int[][]
        def secondList = [[4, 8], [10, 12]] as int[][]

        when:
        def result = task.intervalIntersection(firstList, secondList) as int[][]

        then:
        result == []
    }

    def "case 4"() {
        given:
        def firstList = [[1, 7]] as int[][]
        def secondList = [[3, 10]] as int[][]

        when:
        def result = task.intervalIntersection(firstList, secondList) as int[][]

        then:
        result == [[3, 7]]
    }
}
