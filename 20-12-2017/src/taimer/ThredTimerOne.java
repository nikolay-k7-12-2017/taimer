package taimer;

public class ThredTimerOne implements Runnable{

        long zeroTime;

        Object lock;

    ThredTimerOne(long zeroTime,Object lock){
        this.zeroTime=zeroTime;
        this.lock=lock;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread starter2 " + Thread.currentThread().getName() + "  time(msec):  " + (System.currentTimeMillis() - zeroTime));
            }
        }
    }
}
