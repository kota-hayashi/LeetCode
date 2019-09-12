package medium

import kotlin.test.assertEquals

fun intToRoman(num: Int): String {
    val result = StringBuilder("")
    when (num / 1000) {
        1 -> result.append("M")
        2 -> result.append("MM")
        3 -> result.append("MMM")
    }
    when ((num % 1000) / 100) {
        1 -> result.append("C")
        2 -> result.append("CC")
        3 -> result.append("CCC")
        4 -> result.append("CD")
        5 -> result.append("D")
        6 -> result.append("DC")
        7 -> result.append("DCC")
        8 -> result.append("DCCC")
        9 -> result.append("CM")
    }
    when ((num % 100) / 10) {
        1 -> result.append("X")
        2 -> result.append("XX")
        3 -> result.append("XXX")
        4 -> result.append("XL")
        5 -> result.append("L")
        6 -> result.append("LX")
        7 -> result.append("LXX")
        8 -> result.append("LXXX")
        9 -> result.append("XC")
    }
    when (num % 10) {
        1 -> result.append("I")
        2 -> result.append("II")
        3 -> result.append("III")
        4 -> result.append("IV")
        5 -> result.append("V")
        6 -> result.append("VI")
        7 -> result.append("VII")
        8 -> result.append("VIII")
        9 -> result.append("IX")
    }
    return result.toString()
}

fun main() {
    assertEquals("III", intToRoman(3))
    assertEquals("IV", intToRoman(4))
    assertEquals("IX", intToRoman(9))
    assertEquals("LVIII", intToRoman(58))
    assertEquals("MCMXCIV", intToRoman(1994))
}