var addTwoNumbers = function(l1, l2) {
  var carry = 0
  ,   dummy = new ListNode(0)
  ,   cur = dummy;

  while(l1 || l2) {
    var value = carry;
    if(l1) {
      value += l1.val;
      l1 = l1.next;
    }
    if(l2) {
      value += l2.val;
      l2 = l2.next;
    }
    if(value>=10) {
      carry = 1;
      value -= 10;
    }
    else {
      carry = 0;
    }
    cur.next = new ListNode(value);
    cur = cur.next;
  }

  if(carry) {
    cur.next = new ListNode(carry);
  }

  return dummy.next;
};
