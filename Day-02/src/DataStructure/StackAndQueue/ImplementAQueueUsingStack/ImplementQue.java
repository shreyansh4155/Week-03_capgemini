package DataStructure.StackAndQueue.ImplementAQueueUsingStack;
import java.util.*;
public class ImplementQue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void enqueue(int x){
        s1.push(Integer.valueOf(x));
    }

    public int dequeue(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek(){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }



    public static void main(String[] args) {
        ImplementQue q = new ImplementQue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue()); // Output: 1
        System.out.println(q.dequeue()); // Output: 2
        System.out.println(q.dequeue()); // Output: 3
    }
}
