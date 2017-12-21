package taimer;

public class ThredTimerTwo implements Runnable {
    long zeroTime;

    Object lock;

    ThredTimerTwo(long zeroTime,Object lock){
        this.zeroTime=zeroTime;
        this.lock=lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    lock.wait(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread starter3 " + Thread.currentThread().getName() + "  time(msec):  " + (System.currentTimeMillis() - zeroTime));
            }
        }

    }
}
