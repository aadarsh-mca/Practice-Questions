package DSA;

public class QueueLinear {
    static int[] queue;
    static int front, rear;
    static int size;

    QueueLinear(int queueSize) {
        queue = new int[queueSize];
        front = rear = -1;
        size = queueSize;
    }

    static void enqueue(int data) {
        if(rear == -1) {
            front = rear = 0;
            queue[rear] = data;
            return;
        }
        if(rear == size-1) {
            System.out.println("Queue is full !!!");
            return;
        }

        rear++;
        queue[rear] = data;
    }

    static int dequeue() {
        int data;
        if(front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        data = queue[front];
        if(front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return data;
    }

    static void display() {
        if(front == -1) {
            System.out.println("Queue is empty !!!");
            return;
        }
        int i = front;
        while(i <= rear) {
            System.out.print(queue[i] + "  ");
            i++;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        QueueLinear obj = new QueueLinear(7);

        enqueue(10);
        enqueue(20);
        
        display();
        System.out.println(dequeue());
        System.out.println(dequeue());
        display();

        enqueue(30);
        enqueue(40);
        display();
    }
}
