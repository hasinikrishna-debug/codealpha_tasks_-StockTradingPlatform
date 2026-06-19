import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user =
            new User("Hasini",100000);

        Stock[] stocks = {

            new Stock("TCS",3500),
            new Stock("INFY",1500),
            new Stock("WIPRO",500),
            new Stock("HCL",1700),
            new Stock("RELIANCE",2800)
        };

        while(true){

            System.out.println("\n========== STOCK MARKET ==========");

            System.out.println("1.Display Stocks");
            System.out.println("2.Buy Stock");
            System.out.println("3.Sell Stock");
            System.out.println("4.View Portfolio");
            System.out.println("5.Transaction History");
            System.out.println("6.Save Portfolio");
            System.out.println("7.Exit");

            System.out.print("Choice : ");

            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    for(int i=0;i<stocks.length;i++){

                        System.out.println(
                            (i+1)+". "+stocks[i]
                        );
                    }

                    break;

                case 2:

                    for(int i=0;i<stocks.length;i++){

                        System.out.println(
                            (i+1)+". "+stocks[i]
                        );
                    }

                    System.out.print("Select Stock : ");
                    int buy=sc.nextInt();

                    System.out.print("Quantity : ");
                    int qty=sc.nextInt();

                    user.buyStock(
                        stocks[buy-1],
                        qty
                    );

                    break;

                case 3:

                    for(int i=0;i<stocks.length;i++){

                        System.out.println(
                            (i+1)+". "+stocks[i]
                        );
                    }

                    System.out.print("Select Stock : ");
                    int sell=sc.nextInt();

                    System.out.print("Quantity : ");
                    int sellQty=sc.nextInt();

                    user.sellStock(
                        stocks[sell-1],
                        sellQty
                    );

                    break;

                case 4:

                    System.out.println(
                        "Portfolio : "
                    );

                    System.out.println(
                        user.getPortfolio()
                    );

                    System.out.println(
                        "Balance : Rs."
                        +user.getBalance()
                    );

                    break;

                case 5:

                    System.out.println(
                        "Transaction History"
                    );

                    for(Transaction t:
                        user.getHistory()){

                        System.out.println(t);
                    }

                    break;

                case 6:

                    PortfolioManager
                        .savePortfolio(user);

                    break;

                case 7:

                    System.out.println(
                        "Thank You!"
                    );

                    System.exit(0);
            }
        }
    }
} 