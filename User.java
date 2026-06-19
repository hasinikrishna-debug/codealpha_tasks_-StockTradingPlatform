import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String name;
    private double balance;

    private HashMap<String,Integer> portfolio;
    private ArrayList<Transaction> history;

    public User(String name,double balance){

        this.name=name;
        this.balance=balance;

        portfolio=new HashMap<>();
        history=new ArrayList<>();
    }

    public double getBalance(){
        return balance;
    }

    public HashMap<String,Integer> getPortfolio(){
        return portfolio;
    }

    public ArrayList<Transaction> getHistory(){
        return history;
    }

    public void buyStock(Stock stock,int qty){

        double cost=stock.getPrice()*qty;

        if(balance>=cost){

            balance-=cost;

            portfolio.put(
                stock.getSymbol(),
                portfolio.getOrDefault(stock.getSymbol(),0)+qty
            );

            history.add(
                new Transaction(
                    "BUY",
                    stock.getSymbol(),
                    qty
                )
            );

            System.out.println("Purchase Successful");
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    public void sellStock(Stock stock,int qty){

        int owned=
            portfolio.getOrDefault(
                stock.getSymbol(),
                0
            );

        if(owned>=qty){

            balance+=stock.getPrice()*qty;

            portfolio.put(
                stock.getSymbol(),
                owned-qty
            );

            history.add(
                new Transaction(
                    "SELL",
                    stock.getSymbol(),
                    qty
                )
            );

            System.out.println("Sale Successful");
        }
        else{
            System.out.println("Not Enough Shares");
        }
    }
} 