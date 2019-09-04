package easy

import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun isPalindrome(x: Int): Boolean {
    fun String.isPalindrome(): Boolean {
        if (this.length == 1) return true
        if (this.length == 2 || this.length == 3) return this.first() == this.last()
        if (this.first() == this.last()) return this.substring(1, this.length-1).isPalindrome()
        return false
    }

    return x.toString().isPalindrome()
}

fun main() {
    assertTrue(isPalindrome(121))
    assertFalse(isPalindrome(-121))
    assertFalse(isPalindrome(10))
}