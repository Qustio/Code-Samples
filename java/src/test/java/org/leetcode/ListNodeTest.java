package org.leetcode;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @org.junit.jupiter.api.Test
    void addTwoNumbers() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = new ListNode(7, new ListNode(0, new ListNode(8)));
        Assertions.assertTrue(ListNode.compareTwoLists(ListNode.addTwoNumbers(l1, l2), l3));
    }
}