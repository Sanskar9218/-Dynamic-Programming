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
    public ListNode sortList(ListNode head) {
        
        if(head==null)
        {
            return head;
        }
        ListNode a=head;
        
        PriorityQueue<Integer> p = new PriorityQueue<>();
        while(a!=null)
        {
            p.add(a.val);
            a=a.next;
        }
        
        ListNode b=new ListNode(p.poll());
        ListNode c=b;
        
        while(!p.isEmpty())
        {
            b.next=new ListNode(p.poll());
            b=b.next;
        }
        
        return c;
        
    }
}
