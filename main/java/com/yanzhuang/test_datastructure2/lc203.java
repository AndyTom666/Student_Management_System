package com.yanzhuang.test_datastructure2;

public class lc203 {
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode cur = head;
        ListNode prev = null;
        ListNode post = null;
        while(cur.next!=null)
        {
            if(val==cur.next.val)
            {
                prev=cur;
                cur = cur.next;
                post=cur.next;
                prev.next=post;
                cur=post;

            }else
            {
                cur = cur.next;
            }

        }
        return head;

    }

    public static void main(String[] args) {
        
    }
}
