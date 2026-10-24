class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;

        // Create a copy of every node.
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;

        // Connect copies to other copies.
        while (temp != null) {
            Node copy = map.get(temp);

            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }
}