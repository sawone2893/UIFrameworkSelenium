package utilities;

public class LocatorGenerator {

    public static String generateLocator(String locatorIdentifier,String params){
        String xpath=locatorIdentifier;
        if(params.contains("~")){
            String values[]=params.split("~");
            for (int i=0;i< values.length;i++){
                String newXpath=xpath.replace("#"+i+"#",values[i]);
                xpath=newXpath;
            }
        }else{
            String newXpath=xpath.replace("#0#",params);
            xpath=newXpath;
        }

        return xpath;
    }
}