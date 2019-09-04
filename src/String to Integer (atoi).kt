import java.lang.StringBuilder
import kotlin.test.assertEquals

fun myAtoi2(str: String): Int {
    if (str.isBlank()) return 0
    if (str == "-") return 0
    val firstNotEmpty = str.first { it !== ' ' }
    val firstIndex = str.indexOfFirst { it != ' ' }
    val digits = (0..9).map { '0' + it }
    if (firstNotEmpty in digits || firstNotEmpty == '-' || firstNotEmpty == '+') {
        val sb = StringBuilder("")
        if (firstNotEmpty == '-') {
            for (i in firstIndex+1 until str.length) {
                if (str[i] in digits) {
                    sb.append(str[i])
                } else {
                    break
                }
            }
            if (sb.isEmpty()) return 0
            val x = sb.toString().toDouble()
            return if (x <= 2147483647) x.toInt() * -1 else -2147483648
        } else if (firstNotEmpty == '+') {
            for (i in firstIndex+1 until str.length) {
                if (str[i] in digits) {
                    sb.append(str[i])
                } else {
                    break
                }
            }
            if (sb.isEmpty()) return 0
            val x = sb.toString().toDouble()
            return if (x <= 2147483647) x.toInt() else 2147483647
        } else {
            for (i in firstIndex until str.length) {
                if (str[i] in digits) {
                    sb.append(str[i])
                } else {
                    break
                }
            }
            if (sb.isEmpty()) return 0
            val x = sb.toString().toDouble()
            return if (x <= 2147483647) x.toInt() else 2147483647
        }
    } else {
        return 0
    }
}

val digits = (0..9).map { '0' + it }

fun String.getDigitsList(firstIndex: Int) : String {
    val sb = StringBuilder("")
//    val target = this.substring(firstIndex)
//    val lastIndex = target.indexOfFirst { it !in digits }
//    if (lastIndex == 0) return ""
//    return this.substring(firstIndex, lastIndex - 1)
    for (i in firstIndex until this.length) {
        if (this[i] in digits) {
            sb.append(this[i])
        } else {
            break
        }
    }
    return sb.toString()
}

fun myAtoi(str: String): Int {
    if (str.isBlank()) return 0
    val firstNotEmpty = str.first { it !== ' ' }
    val firstIndex = str.indexOfFirst { it != ' ' }

    if (firstNotEmpty in digits || firstNotEmpty == '-' || firstNotEmpty == '+') {
        val digitsList = when (firstNotEmpty) {
            '-', '+' -> {
                str.getDigitsList(firstIndex + 1)
            }
            else -> {
                str.getDigitsList(firstIndex)
            }
        }

        if (digitsList.isEmpty()) return 0
        val x = digitsList.toDouble()

        return when (firstNotEmpty) {
            '-' -> {
                if (x <= 2147483647) x.toInt() * -1 else -2147483648
            }
            else -> {
                if (x <= 2147483647) x.toInt() else 2147483647
            }
        }
    }
    return 0
}

fun main() {
    assertEquals(42, myAtoi("42"))
    assertEquals(-42, myAtoi("   -42"))
    assertEquals(4193, myAtoi("4193 with words"))
    assertEquals(0, myAtoi("words and 987"))
    assertEquals(-2147483648, myAtoi("-91283472332"))
    assertEquals(0, myAtoi("-+1"))
    assertEquals(1, myAtoi("+1"))
    assertEquals(-2147483648, myAtoi("-2147483648"))
    assertEquals(0, myAtoi("++1"))
    assertEquals(0, myAtoi(" "))
}