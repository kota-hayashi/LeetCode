package hard

import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun isMatch(s: String, p: String): Boolean {
    if (p.isEmpty()) return s.isEmpty()

    val firstMatch = (s.isNotEmpty() && (p[0] == s[0] || p[0] == '.'))

    return if (p.length >= 2 && p[1] == '*') {
        (isMatch(s, p.substring(2))
                || (firstMatch && isMatch(s.substring(1), p)))
    } else {
        firstMatch && isMatch(s.substring(1), p.substring(1))
    }
}

fun main() {
    assertFalse(isMatch("aa", "a"))
    assertTrue(isMatch("aa", "a*"))
    assertTrue(isMatch("ab", ".*"))
    assertTrue(isMatch("aab", "c*a*b"))
    assertFalse(isMatch("mississippi", "mis*is*p*."))
}