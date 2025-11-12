// Doubly Linked List (DLL)

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    void insertBegin(int val) {
        Node newNode = new Node(val);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        System.out.println("Inserted " + val + " at the beginning.");
    }

    void insertEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Inserted " + val + " at the end.");
    }

    void deleteBegin() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
        if (head != null)
            head.prev = null;
        System.out.println("Deleted from beginning.");
    }

    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        if (temp.next == null) {
            head = null;
        } else {
            while (temp.next != null)
                temp = temp.next;
            temp.prev.next = null;
        }
        System.out.println("Deleted from end.");
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Doubly Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, val;

        do {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete at Beginning");
            System.out.println("4. Delete at End");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    list.insertBegin(val);
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    list.insertEnd(val);
                    break;
                case 3:
                    list.deleteBegin();
                    break;
                case 4:
                    list.deleteEnd();
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}


// Circular Linked List (CLL)

import java.util.Scanner;

class CNode {
    int data;
    CNode next;

    CNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    CNode head;

    void insertBegin(int val) {
        CNode newNode = new CNode(val);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            CNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + val + " at the beginning.");
    }

    void insertEnd(int val) {
        CNode newNode = new CNode(val);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            CNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Inserted " + val + " at the end.");
    }

    void deleteBegin() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == head) {
            head = null;
            System.out.println("Deleted last node.");
            return;
        }
        CNode temp = head;
        CNode last = head;
        while (last.next != head)
            last = last.next;
        head = head.next;
        last.next = head;
        System.out.println("Deleted from beginning.");
    }

    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == head) {
            head = null;
            System.out.println("Deleted last node.");
            return;
        }
        CNode temp = head;
        while (temp.next.next != head)
            temp = temp.next;
        temp.next = head;
        System.out.println("Deleted from end.");
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Circular Linked List: ");
        CNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, val;

        do {
            System.out.println("\n--- Circular Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete at Beginning");
            System.out.println("4. Delete at End");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    list.insertBegin(val);
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    list.insertEnd(val);
                    break;
                case 3:
                    list.deleteBegin();
                    break;
                case 4:
                    list.deleteEnd();
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}

