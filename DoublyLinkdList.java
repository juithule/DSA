package src;

class Node5 {
    int data;
    Node5 next;
    Node5 prev;  

    Node5(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node5 head;  

    public void insertAtStart(int data) {
        Node5 newNode = new Node5(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAt(int index, int data) {
        Node5 newNode = new Node5(data);
        if (index == 0) {
            insertAtStart(data);
            return;
        }
        Node5 current = head;  
        for (int i = 0; i < index - 1; i++) {
            if (current != null) {
                current = current.next;
            } else {
                System.out.println("Index out of bounds");
                return;
            }
        }
        if (current != null) {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public void deleteAt(int index) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        Node5 current = head;  
        for (int i = 0; i < index; i++) {
            if (current != null) {
                current = current.next;
            } else {
                System.out.println("Index out of bounds");
                return;
            }
        }
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public void show() {
        Node5 current = head;  
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class DoublyLinkdList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
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
