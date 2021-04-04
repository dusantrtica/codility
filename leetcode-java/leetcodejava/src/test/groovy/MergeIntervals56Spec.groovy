import spock.lang.Specification

class MergeIntervals56Spec extends  Specification{
    MergeIntervals56 merge = new MergeIntervals56();

    def "case 1" () {
        given:
        def intervals = [[1,3],[2,6],[8,10],[15,18]] as int [] []

        when:
        def result = merge.merge(intervals)

        then:
        result == [[1,6],[8,10],[15,18]]
    }

    def "case 2" () {
        given:
        def intervals = [[1,4],[4,5]] as int [][]

        when:
        def result = merge.merge(intervals)

        then:
        result ==  [[1,5]]
    }
}
