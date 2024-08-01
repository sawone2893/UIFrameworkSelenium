package core;

public class ToolFactory {
    private static IActionUI toolInstance=null;
    public static IActionUI getToolInstance(String toolName){

        switch (toolName.toUpperCase()){
            case "SELENIUM":
                toolInstance=new UiActionSelenium();
                break;
            default:
                System.out.println("Unsupported tool name: "+toolName);
        }
            return toolInstance;
    }
}