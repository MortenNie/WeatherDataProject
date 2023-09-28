package dat;


import java.util.Scanner;

public class WeatherInputManager {


    public static String cityInput() {

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your city of interest: København, Odense or Gladsaxe");

            String city = sc.nextLine();
            System.out.println("You have searched for : " + city);

            return city;


        }
}
