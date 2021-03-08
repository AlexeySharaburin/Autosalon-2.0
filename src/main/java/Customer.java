import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Customer {

    private Autosalon autosalon;


    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Customer(Autosalon autosalon) {
        this.autosalon = autosalon;
    }

//    public synchronized Auto buyAuto() {
        public Auto buyAuto() {

        String nameCustomer = Thread.currentThread().getName();
        Auto auto = null;

        try {

            lock.lock();

          System.out.printf("%s зашёл в автосалон\n", nameCustomer);

            while (autosalon.getAuto().size() == 0) {
                System.out.println("Нет автомобилей в наличии");
                condition.await();
//                wait();
            }

            auto = autosalon.getAuto().remove(0);


            System.out.printf("%s уехал домой на %s\n", nameCustomer, auto.getNameAuto());

        } catch (
                Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }

        return auto;

    }

//    public synchronized void recieveAuto() {
        public void recieveAuto() {
        try {
            lock.lock();
            Thread.sleep(1000);
            condition.signal();
//            notify();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
