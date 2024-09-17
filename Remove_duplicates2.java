class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // Method to deserialize a string into a ListNode
    public static ListNode deserialize(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (String node : nodes) {
            current.next = new ListNode(Integer.parseInt(node.trim()));
            current = current.next;
        }
        
        return dummy.next;
    }

    // Method to serialize a ListNode into a string
    public static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode FakeHead = new ListNode(0);
        FakeHead.next = head;
        
        ListNode pre = FakeHead;
        ListNode cur = head;
        
        while (cur != null) {
            boolean isDuplicate = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                isDuplicate = true;
            }
            
            if (isDuplicate) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            
            cur = cur.next;
        }
        
        return FakeHead.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Deserialize input list
        ListNode head = ListNode.deserialize("[1,2,3,3,4,4,5]");

        // Delete duplicates
        ListNode result = sol.deleteDuplicates(head);

        // Serialize the output list and print it
        System.out.println(ListNode.serialize(result));  // Expected output: [1,2,5]
    }
}
