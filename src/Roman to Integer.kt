class Solution1 {
    fun romanToInt(s: String): Int {
        val romans = s.toCharArray()
        var count = 0
        var skip = false
        for (i in 0 .. (romans.size - 2)) {
            if (skip) {
                skip = false
                continue
            }
            skip = true
            if (romans[i] == 'I') {
                if (romans[i+1] == 'V') {
                    count += 4
                    continue
                }
                if (romans[i+1] == 'X') {
                    count += 9
                    continue
                }
            }

            if (romans[i] == 'X') {
                if (romans[i+1] == 'L') {
                    count += 40
                    continue
                }
                if (romans[i+1] == 'C') {
                    count += 90
                    continue
                }
            }

            if (romans[i] == 'C') {
                if (romans[i+1] == 'D') {
                    count += 400
                    continue
                }
                if (romans[i+1] == 'M') {
                    count += 900
                    continue
                }
            }

            skip = false
            count += roman2Int.get(romans[i]) ?: 0
        }
        if (!skip) {
            count += roman2Int.get(romans[romans.size - 1]) ?: 0
        }
        return count
    }

    val roman2Int = mapOf<Char, Int>(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000)
}