package easy

import kotlin.math.abs

fun reverse(x: Int): Int {
    if (x == -2147483648) return 0
    val y = abs(x)
    println("y $y")
    val z =  y.toString().reversed().toDouble()
    return if (-2147483648 <= z && z <= 2147483647) z.toInt() * if (x < 0) -1 else 1 else 0
}

fun main() {
    println(reverse(123))
    println(reverse(-123))
    println(reverse(120))
    println(reverse(1534236469))
    println(reverse(-2147483648))
}