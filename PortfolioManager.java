import java.io.FileWriter;
import java.io.IOException;

public class PortfolioManager {

    public static void savePortfolio(User user){

        try{

            FileWriter writer=
                new FileWriter("portfolio.txt");

            writer.write(
                "Portfolio\n"
            );

            writer.write(
                user.getPortfolio().toString()
            );

            writer.write(
                "\nBalance: Rs."
                +user.getBalance()
            );

            writer.close();

            System.out.println(
                "Portfolio Saved!"
            );

        }
        catch(IOException e){

            System.out.println(
                "Error Saving File"
            );
        }
    }
} 