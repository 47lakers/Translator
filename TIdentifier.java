package prob0719;

public class TIdentifier extends AToken {
    private final String stringValue;

    public TIdentifier(StringBuffer stringBuffer){
        stringValue = new String(stringBuffer);
    }

    public String getStringValue(){
        return stringValue;
    }


    @Override
    public String getDescription(){
        return String.format("Identifier = %s", stringValue);
    }
}
