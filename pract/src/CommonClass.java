public class CommonClass {


    public synchronized void deposit(double amount) throws InterruptedException {
        System.out.println("checking deposit..");
        synchronized (this) {
            Thread.sleep(5000);
            System.out.println("deposited: " + amount);
            System.out.println(Thread.currentThread().getName());
        }

    }

    public void withdraw(double amount) throws InterruptedException {
        System.out.println("checking withdraw..");
        synchronized (this) {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
            System.out.println("withdrawn: " + amount);
        }

    }
}
