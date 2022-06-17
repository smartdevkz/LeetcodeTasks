public class MergeTwoListApp {
    public static void main(String[] args) {
        MergeTwoListApp app = new MergeTwoListApp();
        app.run();
    }

    void run() {
        ListNode l1 = createNodes(new int[] { 2 });
        ListNode l2 = createNodes(new int[] { 1 });
        ListNode res = mergeTwoLists3(l1, l2);
        displayNodes(res);

    }


    //Solution
    ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        
        if(l1!=null)p.next=l1;
        if(l2!=null)p.next=l2;

        return dummyHead.next;
    }

    //Second Approach was successfull
    ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if (l1 == null)
        return l2;
    if (l2 == null)
        return l1;

        ListNode root = null;
        ListNode next = null;
        while(l1!=null&&l2!=null){
            int min = l1.val;
            if(l1.val<=l2.val){
                min = l1.val;
                l1 = l1.next;
            }else{
                min = l2.val;
                l2 = l2.next;
            }

            ListNode obj = new ListNode(min);
            if(root==null) {
                root = obj;
            }else{
                if(next==null){
                    root.next = obj;
                    next = root.next;
                }else{
                    next.next = obj;
                    next = next.next;
                }
            }
        }

        if(next!=null){
            if(l1!=null)next.next = l1;
            if(l2!=null)next.next = l2;
        }else{
            if(l1!=null)root.next = l1;
            if(l2!=null)root.next = l2;
        }

        return root;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode current = l1;
        ListNode prev = null;
        while (l2 != null) {
            if (l2.val <= current.val) {
                ListNode temp = new ListNode(l2.val, current);
                if (prev != null)
                    prev.next = temp;
                else
                    l1 = temp;

                l2 = l2.next;

            } else {
                if (current.next == null) {
                    current.next = l2;
                    break;
                }
                current = current.next;
                if (prev == null) {
                    prev = l1;
                } else {
                    prev = prev.next;
                }
            }
            displayNodes(l1);
            System.out.println("");
        }

        return l1;
    }

    ListNode createNodes(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        ListNode root = null;
        ListNode next = null;
        for (int i = 0; i < nums.length; i++) {
            if (root == null) {
                root = new ListNode(nums[i]);
            } else {
                if (next == null) {
                    root.next = new ListNode(nums[i]);
                    next = root.next;
                } else {
                    next.next = new ListNode(nums[i]);
                    next = next.next;
                }
            }
        }
        return root;
    }

    void displayNodes(ListNode l) {
        ListNode current = l;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public class ListNode {
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
    }
}