package avt.learn.challenge.problems.leetcode;
public class AddTwoNumbers {

    public static void main(String[] args) {
        // You are given two non-empty linked lists representing two non-negative
        // integers. The digits are stored in reverse order, and each of their nodes
        // contains a single digit. Add the two numbers and return the sum as a linked
        // list.

        // You may assume the two numbers do not contain any leading zero, except the
        // number 0 itself.
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode temp = new ListNode(-1);
        ListNode newL = temp;

        while (l1 != null || l2 != null) {

            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
            int val = sum % 10;
            carry = sum / 10;

            newL.next = new ListNode(val);
            newL = newL.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if(carry != 0){
            newL.next = new ListNode(carry);
        }

        return temp.next;
    }

}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
