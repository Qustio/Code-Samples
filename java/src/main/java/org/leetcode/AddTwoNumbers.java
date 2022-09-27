package org.leetcode;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> list1 = new ArrayList<>();
        do {
            list1.add(l1.val);
            l1 = l1.next;
        } while (l1!=null);
        List<Integer> list2 = new ArrayList<>();
        do {
            list2.add(l2.val);
            l2 = l2.next;
        } while (l2!=null);
        // 342
        int int1 = 0;
        for (int i = list1.size()-1; i >= 0; --i) {
            int1 += list1.get(i)*Math.pow(10, i);
        }
        // 465
        int int2 = 0;
        for (int i = list2.size()-1; i >= 0; --i) {
            int2 += list2.get(i)*Math.pow(10, i);
        }
        // 807
        int sum = int1 + int2;
        // 708
        ListNode l = null;
        ListNode ptr = new ListNode(sum % 10);
        sum = sum / 10;
        while (sum!=0) {
            l = ptr;
            ptr = new ListNode(sum % 10, l);
            sum = sum / 10;
        }
        ListNode prev = null;
        ListNode next = null;
        while (ptr != null) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        ptr = prev;
        return ptr;
    }
}


