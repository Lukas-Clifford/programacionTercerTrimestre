import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please, enter a password: ");
        String pass = sc.next();
//        String pass = "1234#6*1";

        PasswordChecker passwordChecker = new PasswordChecker(pass);

        // It’s not a number digit
        try{
            passwordChecker.checkDigit();
        }catch (PassWordExceptions.DigitNotFound ex){
            ex.printStackTrace();
        }

        // It’s a negative number
        try{
            passwordChecker.checkNegativeNumber();
        }catch (PassWordExceptions.NegativeNumber ex){
            ex.printStackTrace();
        }

        // It’s not a lenght valid
        try{
            passwordChecker.checkValidLenght();
        }catch (PassWordExceptions.InvalidLength ex){
            ex.printStackTrace();
        }

        // It hasn’t a # symbol or has more than one
        try{
            passwordChecker.checkHashtagSymbol();
        }catch (PassWordExceptions.HashtagNotFound | PassWordExceptions.TooManyHashtags ex){
            ex.printStackTrace();
        }

        // It hasn’t a * symbol or has more than one
        try{
            passwordChecker.checkAsteriskSymbol();
        }catch (PassWordExceptions.AsteriskNotFound | PassWordExceptions.TooManyAsterisks ex){
            ex.printStackTrace();
        }

        // Generic exception
        try{
            passwordChecker.check();
            System.out.println("Password is valid!");
        }catch (PassWordExceptions.InvalidPassword ex){
            ex.printStackTrace();
        }

    }



}
