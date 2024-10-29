package src;

class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;

    
    public void insertATStart(int data) {
        Node node = new Node();
        node.data = data;  
        node.next = head;
        head = node;
    }

    
    public void insertAt(int index, int data) {
        Node node = new Node();
        node.data = data;

        if (index == 0) {
            insertATStart(data);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                if (n != null) {
                    n = n.next;
                } else {
                    System.out.println("Index out of bounds");
                    return;
                }
            }
            node.next = n.next;
            n.next = node;
        }
    }

    
    public void deleteAt(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
            }
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                if (n != null) {
                    n = n.next;
                } else {
                    System.out.println("Index out of bounds");
                    return;
                }
            }
            if (n != null && n.next != null) {
                Node n1 = n.next;
                n.next = n1.next;
                n1 = null;  
            }
        }
    }

    
    public void show() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertATStart(10);
        list.insertAt(1, 20);
        list.insertAt(2, 30);
        list.insertAt(1, 15);

        System.out.println("List after inserts:");
        list.show();

        list.deleteAt(2);
        System.out.println("List after deletion at index 2:");
        list.show();
    }
}


