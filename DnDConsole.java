import java.util.Scanner;

public class DnDConsole{
    private Scanner scanner;

    public DnDConsole(){
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message){
        System.out.println(message);
    }

    public String getInput(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public int getIntInput(String prompt){
        int input;
        while (true){
            try{
                String userInput = getInput(prompt);
                input = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e){
                displayMessage("Please enter a valid number!");
            }
        }
        return input;
    }

    public void endTheGame(){
        scanner.close();
    }

}