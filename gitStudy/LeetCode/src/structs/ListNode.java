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
            curr.next = prev
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

class test{
    int[] a = new int[](0,1,2,2,3,3,4);
    int i = 0;
	for(int j = 1; j < a.length; j++){
        if(a[j] != a[i]){
            i ++;
            a[i + 1] = a[j];
        }
    }
	return i;
}

