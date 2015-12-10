
public class AddTwoNumber{
  public static void main(String[] args) {
    ListNode l1 = new ListNode(7);
    l1.next = new ListNode(5);
    ListNode l2 = new ListNode(6);
    l2.next = new ListNode(4);
    ListNode ans = addTwoNumbers(l1,l2);
    while(ans!=null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1==null) {
      return l2;
    }
    else if(l2==null) {
      return l1;
    }

    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while(l1!=null||l2!=null) {
      int value = carry;
      if(l1!=null) {
        value += l1.val;
        l1 = l1.next;
      }
      if(l2!=null) {
        value += l2.val;
        l2 = l2.next;
      }
      carry = value/10;
      value = value%10;
      current.next = new ListNode(value);
      current = current.next;
    }

    if(carry==1) {
      current.next = new ListNode(carry);
    }

    return dummy.next;
  }

  public static class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
      this.val = x;
    }
  }
}
