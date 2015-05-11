package ru.kpfu.itis.group11408.zamaleev.hw19BankThread;

import java.util.ArrayList;

/**
 * Created by Ilgiz on 05.05.2015.
 */
public class Bank {

    private long money;
    private ArrayList<Client> clients;

    public Bank(long money) {
        this.money = money;
        this.clients = new ArrayList<Client>();
    }

    public void addMoney(long money){
        this.money += money;
    }

    public long getBalance() {
        return money;
    }

    public void removeMoney(long money) throws BankException {
        synchronized (this){
            if (this.money >= money){
                this.money -= money;
            } else {
                throw new BankException("Bank hasn't got so mach money!");
            }
        }
    }

    public void addClient(Client client){
        synchronized (clients){
            if (!clients.add(client))
                try {
                    throw new BankException("Bank has got this client in data!");
                } catch (BankException e) {
                    e.printStackTrace();
                }
        }
    }

    public void removeClient(Client client){
        synchronized (clients){
            if (hasClient(client)){
                clients.remove(client);
            }
        }
    }

    public boolean hasClient(Client client){
        return clients.contains(client);
    }
}
