package Notebook;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class CreateFile {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter File name");
        String fileName = userInput.nextLine();

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Downloads\\" + fileName + ".txt"));
            Scanner userInput2 = new Scanner(System.in);
            System.out.println("Enter file contents");
            String userInformation = userInput2.nextLine();
            writer.write(userInformation);
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}