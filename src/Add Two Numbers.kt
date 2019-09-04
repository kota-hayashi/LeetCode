/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
// 長いと対応できない。。。
class SolutionOld {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val answerInt = (l1?.toLong() ?: 0)  + (l2?.toLong() ?: 0)
        return answerInt.toString().map { it.toInt() - '0'.toInt() }.toList().toListNode()
    }

    fun ListNode.toLong(): Long {
        val retVal = next?.let { (`val`.toString() + it.toLong().toString()).trim().toLong() }
            ?: `val`.toLong()
        return retVal
    }

    fun List<Int>.toListNode(): ListNode? {
        val retVal = ListNode(this.last())
        if (this.size > 1) {
            retVal.next = this.subList(0, this.size-1).toListNode()
        } else {
            retVal.next = null
        }
        return retVal
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution2 {
    var flag = false
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            if (flag) {
                val retVal = ListNode(1)
                retVal.next = null
                return retVal
            }
            return null
        }

        val value = l1.valOrZero() + l2.valOrZero() + if (flag) 1 else 0
        val retVal = ListNode(value % 10)
        flag = value >= 10
        retVal.next = addTwoNumbers(l1?.next, l2?.next)

        return retVal
    }

    fun ListNode?.valOrZero(): Int =
            this?.`val` ?: 0
}


