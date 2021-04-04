import spock.lang.Specification

class ShuffleArray extends Specification{

    ShuffleArray1470 shuffle = new ShuffleArray1470();
    def "case 1" () {
        given:
        def inputArray = [2,5,1,3,4,7] as int []

        when:
        def result = shuffle.shuffle(inputArray, 3)

        then:
        result == [2,3,5,4,1,7]
    }

    def "case 2" () {
        given:
        def inputArray = [1,2,3,4,4,3,2,1] as int []

        when:
        def result = shuffle.shuffle(inputArray, 4)

        then:
        result == [1,4,2,3,3,2,4,1]
    }

    def "case 3" () {
        given:
        def inputArray = [1,1,2,2] as int []

        when:
        def result = shuffle.shuffle(inputArray, 2)

        then:
        result == [1,2,1,2]
    }

}
