package ru.kpfu.itis.group11408.zamaleev.hw19BankThread;

/**
 * Created by Ilgiz on 11.05.2015.
 */
public class Bankomat {
    private int money;
    private Bank bank; //инкасатор

    public Bankomat(Bank bank) throws BankException {
        if (bank.getBalance() > 100000){
            this.money = 100000;
        } else throw new BankException("Bank hasn't got so mach money to create new bankomat!");
        this.bank = bank;
        this.bank.removeMoney(100000);
    }

    public void getMoney(Client client, int money){
        if (this.money >= money){
            client.setMoney(money);
            this.money -= money;
            if (this.money < 5000){
                try {
                    bank.removeMoney(100000);
                    this.money += 100000;
                } catch (BankException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Bankomat hasn't got this money!");
        }
    }

    public void putMoney(Client client, int money){
        this.money += money;
        client.getMoney(money);
        if (getBalance() > 500000){
            bank.addMoney(getBalance() - 100000);
            this.money = 100000;
        }
    }

    public int getBalance() {
        return money;
    }

    public void inkasate(){
        bank.addMoney(this.money);
        this.money = 0;
    }
}
