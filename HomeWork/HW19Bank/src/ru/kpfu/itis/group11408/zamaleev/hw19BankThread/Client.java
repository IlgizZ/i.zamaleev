package ru.kpfu.itis.group11408.zamaleev.hw19BankThread;

/**
 * Created by Ilgiz on 05.05.2015.
 */
public class Client {
    private long id;
    private int money;

    public Client(long id, int money) {
        this.id = id;
        this.money = money;
    }

    public int getBalance(){
        return money;
    }

    public void getMoney(int money){
        this.money += money;
    }

    public void setMoney(int money){
        this.money -= money;
    }

    public long getId(){
        return id;
    }

    public Client(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
