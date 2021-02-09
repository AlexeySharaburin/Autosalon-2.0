import java.util.ArrayList;
import java.util.List;

public class Autosalon {
    int iMax = 10;
    List<Auto> auto = new ArrayList<>(iMax);
    Customer customer = new Customer(this);

    public void sellAuto() {
        System.out.printf("%s открыл продажи автомобилей!\n\n", Thread.currentThread().getName());
        try {
            while (iMax != 0) {
                Thread.sleep(5000);
                System.out.printf("%s подготовил автомобиль к продаже\n", Thread.currentThread().getName());
                auto.add(new Auto());
                customer.recieveAuto();
                iMax--;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Auto buyAuto() {
        return customer.buyAutos();
    }

    List<Auto> getAuto() {
        return auto;
    }

}
