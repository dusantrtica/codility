import c1.week1.MergeSort
import spock.lang.Specification

class MergeSortSpec extends Specification {
    MergeSort mergeSort = new MergeSort()

    def "empty array"() {
        given:
        def nums = [] as int[]

        when:
        mergeSort.sort(nums, nums.length)

        then:
        nums == []
    }

    def "single element array"() {
        given:
        def nums = [4] as int[]

        when:
        mergeSort.sort(nums, 1)

        then:
        nums == [4]
    }

    def "three elements array"() {
        given:
        def nums = [4, 2, 3] as int[]
        when:
        mergeSort.sort(nums, nums.length)
        then:
        nums == [2, 3, 4]
    }

    def "10 elements array"() {
        given:
        def nums = [4, 2, 5, 2, 6, 1, 8, 3, 10, 0] as int[]
        when:
        mergeSort.sort(nums, nums.length)
        then:
        nums == [0, 1, 2, 2, 3, 4, 5, 6, 8, 10]
    }
}