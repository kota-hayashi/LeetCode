package medium

import kotlin.math.max
import kotlin.math.min
import kotlin.test.assertEquals

fun maxArea(height: IntArray): Int {
    var max = 0
    for (i in 0 until height.size) {
        for (j in i+1 until height.size) {
            max = max(max, (j-i)*min(height[i], height[j]))
        }
    }
    return max
}

fun main() {
    assertEquals(49, maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}