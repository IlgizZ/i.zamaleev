package ru.kpfu.itis.group11408.zamaleev.hw19BankThread;

/**
 * Created by Ilgiz on 11.05.2015.
 */
public class Main {
    private class BankomatRan implements Runnable{
        Bankomat bankomat;
        Client client;
        public BankomatRan(Bank bank, Client client) {
            try {
                bankomat = new Bankomat(bank);
                this.client = client;
            } catch (BankException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            if (bankomat != null){
                int r = (int)(Math.random() * 2);
                if (r == 0){
                    int money = (int)(Math.random() * 50000);
                    System.out.println("Клиент №" + client.getId() +
                            " снял: " + money + " рублей.");
                    bankomat.getMoney(client, money);
                } else {
                    int money = (int)(Math.random() * (client.getBalance() + 1));
                    System.out.println("Клиент №" + client.getId() +
                            " положил: " + money + " рублей.");
                    bankomat.putMoney(client, money);
                }
                bankomat.inkasate();
            }
        }
    }
    public static void main(String[] args) {
        Bank akBars = new Bank(1000001);
        Client[] clients = new Client[10];
        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client(i, 1000 + (int)(Math.random() * 50000));
            akBars.addClient(clients[i]);
        }
        Main main = new Main();
        for (int i = 0; i < clients.length; i++) {
            new Thread(main.new BankomatRan(akBars, clients[i])).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Баланс банка: " + akBars.getBalance());
    }
}
