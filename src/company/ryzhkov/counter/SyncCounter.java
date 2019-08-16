package company.ryzhkov.counter;

public class SyncCounter {
    private int number = 0;

    public synchronized void incNumber() {
        number++;
    }

    public synchronized void decNumber() {
        number--;
    }
}
