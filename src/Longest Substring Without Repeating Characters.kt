import java.lang.StringBuilder

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        var max = 0
        var currentSubstring = StringBuilder("")
        for (i in 0 until s.length) {
            if (currentSubstring.contains(s[i])) {
                max = Math.max(max, currentSubstring.length)
                val start = currentSubstring.indexOf(s[i])
                println("start $start")
                currentSubstring =
                    if (start != currentSubstring.length - 1) StringBuilder(currentSubstring.substring(start+1))
                    else StringBuilder()
            }
            currentSubstring.append(s[i])

            println(currentSubstring)
        }
        return Math.max(max, currentSubstring.length)
    }
}