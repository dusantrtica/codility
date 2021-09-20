import binarysearch.FindKClosestElements
import spock.lang.Specification

class FindKClosestElementsSpec extends Specification {

    FindKClosestElements task = new FindKClosestElements()

    def "case 1"() {
        given:
        def input = [1, 2, 3, 4, 5] as int[]
        def k = 4
        def x = 3

        when:
        def result = task.findClosestElements(input, k, x)

        then:
        result == [1, 2, 3, 4]
    }

    def "case 2" () {
        given:
        def input = [1, 2, 3, 4, 5] as int[]
        def k = 4
        def x = -1

        when:
        def result = task.findClosestElements(input, k, x)

        then:
        result == [1, 2, 3, 4]
    }

    def "case 3" () {
        given:
        def input = [1] as int[]
        def k = 1
        def x = 0

        when:
        def result = task.findClosestElements(input, k, x)

        then:
        result == [1]
    }

    def "case 4" () {
        given:
        def input = [1] as int[]
        def k = 1
        def x = 1

        when:
        def result = task.findClosestElements(input, k, x)

        then:
        result == [1]
    }

    def "case 5"() {
        given:
        def input = [1, 3] as int[]
        def k = 1
        def x = 2

        when:
        def result = task.findClosestElements(input, k, x)

        then:
        result == [1]
    }
}
