package avt.learn.challenge.problem.leetcode.base;

import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getListNode(int[] array) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        for (int n : array) {
            temp.next = new ListNode(n);
            temp = temp.next;
        }
        head = head.next;
        return head;
    }

    public static int[] toArray(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list.stream().mapToInt(n->n).toArray();
    }
}
