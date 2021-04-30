import spock.lang.Specification

class MinAbsDifference1200Spec extends Specification {
    MinAbsDifference1200 task = new MinAbsDifference1200();

    def "case 1" () {
        given:
        def input = [4,2,1,3] as int []

        when:
        def result = task.minimumAbsDifference(input)

        then:
        result == [[1,2],[2,3],[3,4]]
    }

    def "case 2" () {
        given:
        def input = [1,3,6,10,15] as int []

        when:
        def result = task.minimumAbsDifference(input)

        then:
        result == [[1,3]]
    }

    def "case 3" () {
        given:
        def input = [3,8,-10,23,19,-4,-14,27] as int []

        when:
        def result = task.minimumAbsDifference(input)

        then:
        result == [[-14,-10],[19,23],[23,27]]
    }
}
