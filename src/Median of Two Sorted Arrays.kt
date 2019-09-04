fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val nums = nums1 + nums2
    nums.sort()
    val a = nums.size/2
    return if (nums.size % 2 == 0) {
        (nums[a-1] + nums[a]).toDouble()/2
    } else {
        nums[a].toDouble()
    }
}

fun main() {
    println(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4)))
}