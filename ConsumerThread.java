/**
 * Created by maggie on 6/23/16.
 */
public class ConsumerThread extends Thread {
    Buffer<Integer> b;
    int c;
    public ConsumerThread(Buffer<Integer> b, int c){
        this.b = b;
        this.c = c;
    }

    public void run(){
        try{

            while(1<2){
                System.out.println("Consumer" + c +" get "+ b.get());
                this.sleep(10);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
