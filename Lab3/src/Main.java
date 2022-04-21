import utils.ConsoleUI;

public class Main {
    public static void main(String[] args){
        try {
            ConsoleUI.startApp();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    }

