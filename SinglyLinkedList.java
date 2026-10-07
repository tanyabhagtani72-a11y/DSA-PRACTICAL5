import java.util.Scanner;

public class SinglyLinkedList {

    class Node {
        int rollNo;
        String name;
        Node next;

        Node(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
            this.next = null;
        }
    }

    Node head = null;

    // Insert student
    void insert(int rollNo, String name) {

        Node newNode = new Node(rollNo, name);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student added successfully.");
    }

    // Delete student
    void delete(int rollNo) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    // Search student
    void search(int rollNo) {

        Node temp = head;

        while (temp != null) {

            if (temp.rollNo == rollNo) {
                System.out.println("Student found.");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Update student
    void update(int rollNo, String newName) {

        Node temp = head;

        while (temp != null) {

            if (temp.rollNo == rollNo) {
                temp.name = newName;
                System.out.println("Student record updated successfully.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Display students
    void display() {

        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        Node temp = head;

        System.out.println("\nStudent Registration List:");

        while (temp != null) {
            System.out.println(
                "Roll No: " + temp.rollNo +
                ", Name: " + temp.name
            );

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {

            System.out.println("\n--- Student Registration System ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    list.insert(rollNo, name);
                    break;

                case 2:
                    System.out.print("Enter Roll No to delete: ");
                    rollNo = sc.nextInt();

                    list.delete(rollNo);
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    rollNo = sc.nextInt();

                    list.search(rollNo);
                    break;

                case 4:
                    System.out.print("Enter Roll No to update: ");
                    rollNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    list.update(rollNo, newName);
                    break;

                case 5:
                    list.display();
                    break;

                case 6:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}