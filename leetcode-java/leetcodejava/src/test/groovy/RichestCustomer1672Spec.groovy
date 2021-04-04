import spock.lang.Specification

class RichestCustomer1672Spec extends Specification {

    RichestCustomer1672 richestCustomer1672 = new RichestCustomer1672()

    def "case 1"() {
        given:
        def accounts = [[1, 2, 3], [3, 2, 1]] as int[][]

        when:
        def result = richestCustomer1672.maximumWealth(accounts)

        then:
        result == 6
    }

    def "case 2"() {
        given:
        def accounts = [[1, 5], [7, 3], [3, 5]] as int[][]

        when:
        def result = richestCustomer1672.maximumWealth(accounts)

        then:
        result == 10
    }

    def "case 3"() {
        given:
        def accounts = [[2,8,7],[7,1,3],[1,9,5]] as int[][]

        when:
        def result = richestCustomer1672.maximumWealth(accounts)

        then:
        result == 17
    }
}
