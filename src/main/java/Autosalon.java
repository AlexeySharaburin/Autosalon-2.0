import java.util.ArrayList;
import java.util.List;

public class Autosalon {


    static int maxQuantity = 10;
    static List<Auto> autos = new ArrayList<>(maxQuantity);

    Customer customer = new Customer(this);

    public void sellAuto() {
        String autosalon = Thread.currentThread().getName();
        int i = 0;

        try {
            System.out.printf("%s открыл продажи автомобилей!\n", autosalon);

            while (maxQuantity != 0) {
                i++;
                Thread.sleep(5000);
                Auto auto = new Auto("Авто " + i);
                getAuto().add(auto);
                System.out.printf("%s подготовил %s к продаже\n", autosalon, auto.getNameAuto());
                customer.recieveAuto();
                maxQuantity--;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void comeCustomer() {
        customer.buyAuto();
    }

    public List<Auto> getAuto() {
        return autos;
    }

}
