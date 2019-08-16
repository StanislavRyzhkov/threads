package company.ryzhkov.counter;

public class App {
    public static void main(String[] args) {
        SimpleCounter simpleCounter = new SimpleCounter();
        Runnable inc = () -> {
            for(int i = 0; i < 1000; i++) {
                synchronized (simpleCounter) {
                    simpleCounter.setNumber(simpleCounter.getNumber() + 1);
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (simpleCounter) {
                    simpleCounter.setNumber(simpleCounter.getNumber() - 1);
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(dec);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----");
        System.out.println(simpleCounter.getNumber());
    }
}
