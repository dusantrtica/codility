import spock.lang.Specification

class FirstSpec extends Specification {
    def diagonalTraverse = new DiagonalTraverse();

    def "sanity test"() {
        expect:
        1 + 1 == 2
    }
}