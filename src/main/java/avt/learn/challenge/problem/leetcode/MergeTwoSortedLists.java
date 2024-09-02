package avt.learn.challenge.problem.leetcode;

import avt.learn.challenge.problem.leetcode.base.ListNode;

import java.util.Arrays;

public class MergeTwoSortedLists {

    /*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    Example 2:
    Input: list1 = [], list2 = []
    Output: []

    Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]

    Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.


     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {

        ListNode listNode1 = ListNode.getListNode(new int[]{1, 2, 4});
        ListNode listNode2 = ListNode.getListNode(new int[]{1, 3, 4});
        System.out.println(Arrays.toString(ListNode.toArray(new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode2))));

        listNode1 = ListNode.getListNode(new int[]{});
        listNode2 = ListNode.getListNode(new int[]{});
        System.out.println(Arrays.toString(ListNode.toArray(new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode2))));

        listNode1 = ListNode.getListNode(new int[]{});
        listNode2 = ListNode.getListNode(new int[]{0});
        System.out.println(Arrays.toString(ListNode.toArray(new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode2))));


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode tempList = new ListNode(-1);
        ListNode head = tempList;
        while (list1 != null && list2 != null) {
            int val;
            if (list1.val <= list2.val) {
                val = list1.val;
                list1 = list1.next;
            } else {
                val = list2.val;
                list2 = list2.next;
            }
            tempList.next = new ListNode(val);
            tempList = tempList.next;
        }
        if (list1 != null)
            tempList.next = list1;
        if (list2 != null)
            tempList.next = list2;

        return head.next;
    }
}

