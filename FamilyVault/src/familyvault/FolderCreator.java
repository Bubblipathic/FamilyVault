import java.io.File;
import java.util.Scanner;

public class FolderCreator {
    public static void main(String[] args) {
        // Get the user's home directory
        String userHome = System.getProperty("user.home");

        // Create a File object representing the desktop folder
        File desktop = new File(userHome, "Desktop");

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the name of the folder
        System.out.print("Enter your family name: ");
        String familyName = scanner.nextLine();

        // Create a File object representing the new folder on the desktop
        File newFolder = new File(desktop, "Fvault " + familyName);

        // Check if the folder already exists
        if (newFolder.exists()) {
            System.out.println("Folder already exists.");
        } else {
            // Attempt to create the folder
            boolean folderCreated = newFolder.mkdir();
            if (folderCreated) {
                System.out.println("Folder created successfully on the desktop.");
                // Get the path of the newly created folder
                String folderPath = newFolder.getAbsolutePath();
                // Create an array to store folder paths
                String[] folderPaths = {folderPath};
                // Print the folder path
                System.out.println("Folder path: " + folderPath);
                // Print the folder path from the array
                System.out.println("String Inside the array: " + folderPaths[0]);
            } else {
                System.out.println("Failed to create folder.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
