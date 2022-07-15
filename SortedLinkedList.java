package dsa_assignment_08;

/**
 *
 * @author 1999k
 */
public class SortedLinkedList {

    // Represent a node of the singly linked list
    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    // addNode() will add a new node to the list
    public void addNode(int data) {

        // Create a new node
        Node newNode = new Node(data);

        // Checks if the list is empty
        if (head == null) {

            // If list is empty, both head and tail will
            // point to new node
            head = newNode;
            tail = newNode;
        } else {

            // newNode will be added after tail such that
            // tail's next will point to newNode
            tail.next = newNode;

            // newNode will become new tail of the list
            tail = newNode;
        }
    }

    // sortList() will sort nodes of the list in ascending
    // order
    public void sortList() {

        // Node current will point to head
        Node current = head, index = null;

        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    // print() will print all the nodes present in the
    // list
    public void print() {
        // Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            // Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    //Checks whether the value x is present in linked list
    public String search(Node head, int x) {
        int steps = 0;
        Node current = head;    //Initialize current
        while (current != null) {
            steps = steps + 1;
            if (current.data == x) {

                return "Found : " + x + " in " + steps + " steps";    //data found
            }
            current = current.next;
        }
        return "Not Found : " + x + " in " + steps + " steps";    //data not found
    }

    public static void main(String[] args) {

        SortedLinkedList sList = new SortedLinkedList();

        // Adds data to the list
        sList.addNode(2);
        sList.addNode(3);
        sList.addNode(7);
        sList.addNode(4);
        sList.addNode(1);
        sList.addNode(5);
        sList.addNode(6);

        // Displaying original list
        System.out.println("");
        System.out.println("Before Sorted : ");
        sList.print();

        // Sorting list
        sList.sortList();

        // Displaying sorted list
        System.out.println("");
        System.out.println("After Sorted : ");
        sList.print();

        System.out.println("");
        System.out.println("Search Value : 1 ");
        System.out.println("Is it found : " + sList.search(sList.head, 1));

        System.out.println("");
        System.out.println("Search Value : 4 ");
        System.out.println("Is it found : " + sList.search(sList.head, 4));

        System.out.println("");
        System.out.println("Search Value : 10 ");
        System.out.println("Is it found : " + sList.search(sList.head, 10));
        System.out.println("");

    }

}
