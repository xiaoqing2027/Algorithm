/**
 * Created by maggie on 6/25/16.
 */
public class ProducerAndConsumer {

    public static void main(String[] args) throws InterruptedException {
        Buffer<Integer> b = new Buffer<Integer>(5);
        int i = 0;
        while (i < 5) {
            ProducerThread p1 = new ProducerThread(b, i);
            i++;
            p1.start();
        }

        int j = 0;
        while (j < 5) {
            ConsumerThread c1 = new ConsumerThread(b,j);
            j++;
            c1.start();
        }
    }
}
