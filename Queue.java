import java.util.Scanner;

public class Queue {
    Node front, rear;
    class Node { int data; Node next; Node(int data) { this.data = data; } }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) front = rear = newNode;
        else { rear.next = newNode; rear = newNode; }
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int dequeuedData = front.data;
        front = front.next;
        if (front == null) rear = null;
        return dequeuedData;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements to enqueue: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) queue.enqueue(scanner.nextInt());
        System.out.println("Dequeuing elements:");
        while (queue.front != null) System.out.print(queue.dequeue() + " ");
        scanner.close();
    }
}
