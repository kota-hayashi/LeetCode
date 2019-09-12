package easy

import java.lang.StringBuilder
import kotlin.test.assertEquals

fun longestCommonPrefix(strs: Array<String>): String {
    val shortestStr = strs.minBy { it.length }
    val result = StringBuilder("")
    if (shortestStr == null) return ""
    for (i in 0 until shortestStr!!.length) {
        val target = shortestStr[i]
        if (strs.all { it[i] == target }){
            result.append(target)
        } else break
    }
    return result.toString()
}

fun main() {
    assertEquals("fl", longestCommonPrefix(arrayOf("flower","flow","flight")))
    assertEquals("", longestCommonPrefix(arrayOf("dog","racecar","car")))
    assertEquals("", longestCommonPrefix(arrayOf()))
}