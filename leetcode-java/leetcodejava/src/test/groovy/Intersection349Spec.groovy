import spock.lang.Specification;

public class Intersection349Spec extends Specification {
  IntersectionOf2Arrays349 task = new IntersectionOf2Arrays349();

  def "sample 1" () {
    given:
    def a1 = [1,2,2,1] as int []
    def a2 = [2,2] as int []

    when:
    def result = task.intersection(a1, a2)

    then:
    result == [2]
  }

  def "sample 2" () {
    given:
    def a1 = [4, 9, 5] as int []
    def a2 = [9, 4] as int []

    when:
    def result = task.intersection(a1, a2)

    then:
    result == [4, 9]
  }
}
