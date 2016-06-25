import java.util.ArrayList;

/**
 * Created by maggie on 6/23/16.
 */
public class Buffer<T> {
    ArrayList<T> arr;
    int capacity = 0;

    public Buffer(int capacity) {
        this.capacity = capacity;
        arr = new ArrayList<T>(capacity);
    }

    public synchronized T get() throws InterruptedException {

        while (arr.isEmpty()) {
            this.wait();
            System.out.println("*******buffer is empty*******");
        }

        T t = arr.remove(0);
        this.notify();
        return t;
    }

    synchronized public void put(T t) throws InterruptedException {
        while (arr.size() == capacity) {
            this.wait();
            System.out.println("-----buffer is full----");
        }
        arr.add(t);
        this.notify();

    }



}
