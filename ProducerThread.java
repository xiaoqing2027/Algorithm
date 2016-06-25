import java.util.Random;

/**
 * Created by maggie on 6/23/16.
 */
public class ProducerThread extends Thread {
    Buffer<Integer> b;

    int p = 0;
    ProducerThread(Buffer<Integer> b, int p){
        this.b =b;
        this.p =p;

    }

    public void run(){
        try{

            while(1<2){
                Random rand = new Random();
                Integer t = rand.nextInt(20);
                b.put(t);
                System.out.println("producer" + p + " put  " +t);
                this.sleep(10);
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}


