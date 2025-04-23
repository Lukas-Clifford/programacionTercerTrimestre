import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

    String password = "";

    public PasswordChecker(String password){
        this.password = password;
    }

    public void checkDigit() throws PassWordExceptions.DigitNotFound {
        Matcher matcher = Pattern.compile("[^a-zA-Z]").matcher(this.password);
        if(!matcher.find()) throw new PassWordExceptions.DigitNotFound();
    }


    public void checkNegativeNumber() throws PassWordExceptions.NegativeNumber {
        Matcher matcher = Pattern.compile("[^-]").matcher(this.password);
        if(!matcher.find()) throw new PassWordExceptions.NegativeNumber();
    }


    public void checkValidLenght() throws PassWordExceptions.InvalidLength {
        Matcher matcher = Pattern.compile(".{8}").matcher(this.password);
        if(!matcher.find()) throw new PassWordExceptions.InvalidLength();
    }


    public void checkHashtagSymbol() throws PassWordExceptions.HashtagNotFound, PassWordExceptions.TooManyHashtags{
        // Checks if there's a '#'
        Matcher matcher1 = Pattern.compile("#").matcher(this.password);
        if(!matcher1.find()) throw new PassWordExceptions.HashtagNotFound();

        // Checks that there's only ONE '#' symbol
        Matcher matcher2 = Pattern.compile("^[^#]*#[^#]*$").matcher(this.password);
        if(!matcher2.find()) throw new PassWordExceptions.TooManyHashtags();
    }


    public void checkAsteriskSymbol() throws PassWordExceptions.AsteriskNotFound, PassWordExceptions.TooManyAsterisks {

        // Same as checkHashtagSymbol()

        // Checks if there's a '*'
        Matcher matcher1 = Pattern.compile("[*]").matcher(this.password);
        if(!matcher1.find()) throw new PassWordExceptions.AsteriskNotFound();

        // It checks that there's only ONE '*' symbol
        Matcher matcher2 = Pattern.compile("^[^*]*[*][^*]*$").matcher(this.password);
        if(!matcher2.find()) throw new PassWordExceptions.TooManyAsterisks();
    }


    public void check() throws PassWordExceptions.InvalidPassword {
        Matcher matcher = Pattern.compile("^[0-9#*]{8}$").matcher(this.password);
        if(!matcher.find()) throw new PassWordExceptions.InvalidPassword();
    }



}
