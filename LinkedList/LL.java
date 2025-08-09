package LinkedList;
// here we write methods
public class LL {
    public static void printList(ListNode list){
        if (list == null){
            System.out.println("[ ]");
            return;
        }
        System.out.print("[");
        ListNode cur = list;
        while (cur.next!=null){
            System.out.print(cur.val+", ");
            cur = cur.next;
        }

        System.out.println(cur.val+"]");
    }
    public static  ListNode getList (int[] num){
        if(num.length==0)
            return new ListNode();
        ListNode list = new ListNode(num[0]);
        ListNode head = list;
        for (int i=1;i< num.length;i++){
            list.next = new ListNode(num[i]);
            list=list.next;
        }
        return head;
    }
}
