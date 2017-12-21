package taimer;

public class MainTimer {

    public static void main(String[] args) {

        long zeroTime = System.currentTimeMillis();
        Object lock=new Object();


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        try {
                            lock.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Thread starter2 " + Thread.currentThread().getName() + "  time(msec):  " + (System.currentTimeMillis() - zeroTime));
                    }
                }
            }
        });

        ThredTimerOne thredTimerOne=new ThredTimerOne(zeroTime,lock);
        Thread thread1=new Thread(thredTimerOne);
        ThredTimerTwo thredTimerTwo=new ThredTimerTwo(zeroTime,lock);
        Thread thread2=new Thread(thredTimerTwo);
        thread.start();
        thread1.start();
        thread2.start();


    }



}
