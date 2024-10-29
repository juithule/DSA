package src;

class Node6 {
    int data;
    Node6 next;

    Node6(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node6 head;

    public void insertAtStart(int data) {
        Node6 newNode = new Node6(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node6 current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAt(int index, int data) {
        Node6 newNode = new Node6(data);
        if (index == 0) {
            insertAtStart(data);
            return;
        }
        Node6 current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == head) {
                System.out.println("Index out of bounds");
                return;
            }
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAt(int index) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (index == 0) {
            Node6 current = head;
            if (current.next == head) {
                head = null;
            } else {
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
            return;
        }
        Node6 current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == head) {
                System.out.println("Index out of bounds");
                return;
            }
        }
        Node6 toDelete = current.next;
        if (toDelete == head) {
            head = head.next;
        }
        current.next = toDelete.next;
    }

    public void show() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node6 current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }
}

public class CircularLinkedlist {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtStart(10);
        list.insertAt(1, 20);
        list.insertAt(1, 15);
        list.insertAt(2, 25);
        System.out.println("List after inserts:");
        list.show();
        list.deleteAt(1);
        System.out.println("List after deletion at index 1:");
        list.show();
    }
}
