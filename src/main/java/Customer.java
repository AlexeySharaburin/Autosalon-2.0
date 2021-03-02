import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Customer {

    private Autosalon autosalon;

    private int ID;

    public Customer(Autosalon autosalon) {
        this.autosalon = autosalon;
    }

    public synchronized Auto buyAuto() {

        String nameCustomer = Thread.currentThread().getName();
        Auto auto = null;

        try {
            System.out.printf("%s зашёл в автосалон\n", nameCustomer);

            while (autosalon.getAuto().size() == 0) {
                System.out.println("Нет автомобилей в наличии");
                wait();
            }

            auto = autosalon.getAuto().remove(0);


            System.out.printf("%s уехал домой на %s\n", nameCustomer, auto.getNameAuto());

        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return auto;

    }

    public synchronized void recieveAuto() {
        try {
            notify();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
