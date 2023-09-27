package dat;


import java.util.Scanner;

public class WeatherInputManager {


    public static String cityInput() {


        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your city of interest: København, Odense or Gladsaxe");

            String city = sc.nextLine();
            System.out.println("You have searched for : " + city);

            sc.close();

            return city;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        }
}
