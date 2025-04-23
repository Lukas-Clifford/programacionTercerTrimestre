public class PassWordExceptions {

    public static class DigitNotFound extends Exception{
        public DigitNotFound(){ super("Error code=0"); }}

    public static class NegativeNumber extends Exception{
        public NegativeNumber(){ super("Error code=1"); }}

    public static class InvalidLength extends Exception{
        public InvalidLength(){ super("Error code=2"); }}

    public static class HashtagNotFound extends Exception{
        public HashtagNotFound(){ super("Error code=3.1"); }}

    public static class TooManyHashtags extends Exception{
        public TooManyHashtags(){ super("Error code=3.2"); }}

    public static class AsteriskNotFound extends Exception{
        public AsteriskNotFound(){ super("Error code=4.1"); }}

    public static class TooManyAsterisks extends Exception{
        public TooManyAsterisks(){ super("Error code=4.2"); }}

    public static class InvalidPassword extends Exception{
        public InvalidPassword(){ super("Error code=5"); }}

}

