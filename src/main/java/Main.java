public class Main {

    public static void main(String[] args) throws InterruptedException {

        final Autosalon autosalon = new Autosalon();

        new Thread(null, autosalon::sellAuto, "Автосалон").start();

        for (int i = 1; i < 11; i++) {
            Thread.sleep(3000);
            new Thread(null, autosalon::buyAuto, "Покупатель " + i).start();
        }
    }
}
