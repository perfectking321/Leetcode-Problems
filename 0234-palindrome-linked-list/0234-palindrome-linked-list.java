/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode Reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = Reverse(head.next);
        ListNode front = head.next;
        front.next = head;       
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firsthalf = head;
        ListNode secondhalf;
        if(fast!=null){
            secondhalf = slow.next;
        }
        else{
            secondhalf = slow;
        }
        ListNode reversedSecondHalf = Reverse(secondhalf);
        ListNode firstNode = firsthalf;
        ListNode secondNode = reversedSecondHalf;
        while(secondNode!=null){
            if(firstNode.val == secondNode.val){
                firstNode = firstNode.next;
                secondNode = secondNode.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
}