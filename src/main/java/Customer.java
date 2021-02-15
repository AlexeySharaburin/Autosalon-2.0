import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Customer {

    private Autosalon autosalon;

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Customer(Autosalon autosalon) {
        this.autosalon = autosalon;
    }

    public Auto buyAutos() {

        try {
            lock.lock();
            System.out.printf("%s зашёл в автосалон\n", Thread.currentThread().getName());
            Thread.sleep(3000);
            
            while (autosalon.getAuto().size() == 0) {
                System.out.println("Нет автомобилей в наличии");
                condition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.printf("%s уехал домой на новом автомобиле\n", Thread.currentThread().getName());
        return autosalon.getAuto().remove(0);
    }

    public void recieveAuto() {
        try {
            lock.lock();
            Thread.sleep(1000);
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
