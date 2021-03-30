import spock.lang.Specification

class RunningSumOf1dArray1480Spec extends Specification {
    RunningSumOf1dArray1480 r = new RunningSumOf1dArray1480()

    def "1,2,3,4 example"() {
        given:
        def input = [1,2,3, 4] as int []

        when:
        def result = r.runningSum(input)

        then:
        result == [1,3, 6, 10]
    }

    def "all ones example" () {
        given:
        def input = [1,1,1,1,1] as int []

        when:
        def result = r.runningSum(input)

        then:
        result == [1,2,3,4,5]
    }

    def "random array"() {
        given:
        def input = [3,1,2,10,1] as int []

        when:
        def result = r.runningSum(input)

        then:
        result == [3,4,6,16,17]
    }
}
