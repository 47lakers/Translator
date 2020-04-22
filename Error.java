package prob0719;

public class Error extends ACode {
    private final String errorMessage;
    public Error(String errMessage){
        errorMessage = errMessage;
    }
    @Override
    public String generateListing(){
        return "ERROR: " + errorMessage + "\n";
    }
    public String generateCode(){
        return "";
    }
}
