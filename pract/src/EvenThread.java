public class EvenThread extends Thread {
    public EvenThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 2; i <= 10; i+=2) {
            if (System.currentTimeMillis() -  start > 1) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(i);

        }
    }
}
