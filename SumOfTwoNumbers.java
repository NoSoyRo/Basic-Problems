
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public String addTwoNodeNumbers(ListNode l1, ListNode l2, int acum, String num) {
        if ((l1.next != null) || (l2.next != null)) {
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
        } else {
            char ch;
            String str;
            String nstr;
            nstr = "";
            Integer suma = l1.val + l2.val + acum;
            String sumami = suma.toString();
            for (int i = 0; i < sumami.length(); i++) {
                ch = sumami.charAt(i);
                nstr = ch + nstr;
            }
            return num + nstr;
        }
        Integer val = l1.val + l2.val + acum;
        acum = (int) (val / 10);
        val = val - acum * 10;
        num += val;
        return addTwoNodeNumbers(l1.next, l2.next, acum, num);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num = addTwoNodeNumbers(l1, l2, 0, "");
        System.out.println(num);
        return num;
    }
}