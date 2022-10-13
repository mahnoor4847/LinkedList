import java.util.HashSet;

public class linkedlist {
    // create an object of Node class
    // create the head of the linked list
    public Node head;

    // static inner class
    static class Node {
        int value;

        // connect each node to next node
        //next pointer points to null
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }

    }

    public static boolean Empty(linkedlist ll) {
        if (ll.head == null) {
            return true;
        } else return false;
    }

    public static linkedlist AddElement(linkedlist ll, int d) {
        //create new node
        Node node_insert = new Node(d);
        if (Empty(ll)) {
            ll.head = node_insert;
        }
        //if linkedlist is not empty then go through list until null and add element
        else {
            Node current_n = ll.head;
            while (current_n.next != null) {
                current_n = current_n.next;
            }
            current_n.next = node_insert;
        }
        return ll;

    }

    public static linkedlist removal(linkedlist ll, int position) {
        //search for position in list, different cases: list empty, remove head, in middle/end, not in list
        if (Empty(ll)) {
            System.out.println("can't remove from empty list");
        }
        //if head is being removed then update head to the next node instead
        else {
            Node current_n = ll.head;
            if (position == 0 & current_n != null) {
                ll.head = current_n.next;
                System.out.println(position + " position element deleted");
                return ll;
            }
            int nth_node = 0;
            //case where node we want to remove is in the middle or end of linkedlist
            //keep track of node position and stop when we get to the node before the one we want
            while (nth_node <= position & current_n != null) {
                // if the node is before the one we want to remove, make it point to node after the one we want to remove
                if (nth_node == position - 1) {
                    current_n.next = current_n.next.next;
                    System.out.println("position " + position + " element deleted");
                    break;
                } else {
                    //if at node we want to remove, update it to next node
                    current_n = current_n.next;
                    nth_node++;
                }
            }
        }
        return ll;
    }

    public static int find_node(linkedlist ll, int n) {
        int nth_node = 0;
        Node current_n = ll.head;
        while (current_n != null) {
            if (nth_node == n) {
                System.out.println(current_n.value + " is the node at position " + n);
                return current_n.value;

            }
            nth_node++;
            current_n = current_n.next;
        }

        return -1;

    }

    public static int length(linkedlist ll) {
        int list_length = 1;
        Node current_n = ll.head;
        if (Empty(ll) == false) {
            while (current_n.next != null) {
                list_length++;
                current_n = current_n.next;
            }
        }

        return list_length;
    }
    // detect cycles in hashset, go through list and add nodes to hashset
    //if null is reached at any point return false
    //if node already exists in hashset, returns true
    public static boolean cycles(Node n){
        HashSet<Node> s = new HashSet<Node>();
        while (n!= null) {
            if (s.contains(n)) {
                return true;
            }
            //seeing node for first time so add it to hashset
            s.add(n);
            n = n.next;
        }

        return false;

    }

    public static void printList(linkedlist ll) {
        Node current_n = ll.head;

        System.out.print("LinkedList: ");

        // go through the list
        while (current_n != null) {
            // Print the value at current node
            System.out.print(current_n.value + " ");

            // Go to next node
            current_n = current_n.next;
        }
    }

    public static void main(String[] args)
    {
        /* Start with the empty list. */
        linkedlist list = new linkedlist();

        // Insert the values
        list = AddElement(list, 1);
        list = AddElement(list, 2);
        list = AddElement(list, 3);
        list = AddElement(list, 4);
        list = AddElement(list, 5);
        list = AddElement(list, 6);
        list = AddElement(list, 7);
        list = AddElement(list, 8);

        // Print the LinkedList
        printList(list);

        removal(list, 4);
        printList(list);

        removal(list, 0);
        printList(list);

        System.out.println("list length is " + length(list) );

        find_node(list, 2);

        System.out.println(cycles(list.head));

    }
}



