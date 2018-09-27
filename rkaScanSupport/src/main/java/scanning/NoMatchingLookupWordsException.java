package scanning;

public class NoMatchingLookupWordsException extends Exception{

    public NoMatchingLookupWordsException() {
        super();
    }

    public NoMatchingLookupWordsException(String message) {
        super(message);
    }

    public NoMatchingLookupWordsException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
