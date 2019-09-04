package medium

import java.lang.StringBuilder

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s
    if (numRows == 2) return s.filterIndexed { index, c ->  index % 2 == 0 } + s.filterIndexed { index, c ->  index % 2 == 1 }
    val results =  Array(numRows) { StringBuilder("")}
    var isDown = true
    var currentRow = 0
    for (i in 0 until s.length) {
        println("s[i] ${s[i]}, isDown $isDown, currentRow $currentRow")
        if (isDown) {
            results[currentRow].append(s[i])
            currentRow += 1
            if (currentRow == numRows) {
                isDown = false
                currentRow = numRows - 2
            }
        } else {
            results[currentRow].append(s[i])
            currentRow -= 1
            if (currentRow == 0) {
                isDown = true
            }
        }
    }
    return results.joinToString("")
}

fun main() {
    println(convert("PAYPALISHIRING", 3))
    println(convert("PAYPALISHIRING", 4))
    println(convert("AB", 1))
    println(convert("ABCD", 2))
}