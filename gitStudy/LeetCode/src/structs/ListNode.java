class ListNode{
    int val;
    ListNode next;

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode iterate(ListNode head){
        ListNode prev = null, next;
        ListNode curr = head;
        while(curr.next != null){
            next = curr;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode recursion(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}


