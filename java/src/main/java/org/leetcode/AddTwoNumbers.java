package org.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
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

    static public Boolean compareTwoLists(ListNode temp1, ListNode temp2) {
        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 == temp2;
    }
    static public int reverseInt(int a) {
        int ret = 0;
        while (a > 0) {
            ret *= 10;
            ret += a % 10;
            a = a / 10;
        }
        return ret;
    }
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        int sum = val1 + val2 + carry;

        carry = sum / 10;

        l1 = l1 != null ? l1.next:null;
        l2 = l2 != null ? l2.next:null;
        var a = new ListNode(sum%10, addTwoNumbers(l1, l2, carry));
        System.out.println(sum%10);
        return a;
    }
}


