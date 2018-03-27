import java.util.Scanner;

public class mainMethod {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    SparseMatrix mat = new SparseMatrix();

    System.out.print("Enter the size of your matrix: ");
    mat.setSize(scan.nextInt());

    boolean running = true;
    int choice = -1;
    int x = -1;
    int y = -1;

    System.out.println("Make a choice from the menu.");

    while (running) {

      System.out.println();
      System.out.println("\t1. Clear the matrix (set all elements to 0).");
      System.out.println("\t2. Set the size.");
      System.out.println("\t3. Return the size.");
      System.out.println("\t4. Add an element.");
      System.out.println("\t5. Remove an element.");
      System.out.println("\t6. Get an element.");
      System.out.println("\t7. Get the determinant.");
      System.out.println("\t8. Print the matrix.");
      System.out.println("\t9. End the program.");

      System.out.print("\t\tMenu Choice: ");
      choice = scan.nextInt();

      //clear the matrix
      if (choice == 1) {

        mat.clear();
        System.out.println("Matrix cleared!");
      }

      //set the matrix size
      else if (choice == 2) {

        System.out.print("Set size to: ");
        mat.setSize(scan.nextInt());

        System.out.println("Size set!");
      }

      //print the matrix size
      else if (choice == 3) {

        System.out.println("Current size: " + mat.getSize());
      }

      //add an element
      else if (choice == 4) {

        System.out.print("Row of element to add: ");
        x = scan.nextInt();

        System.out.print("Column of element to add: ");
        y = scan.nextInt();

        System.out.print("Value of element to add: ");
        mat.addElement(x, y, scan.nextInt());
      }

      //remove an element
      else if (choice == 5) {

        System.out.print("Row of element to remove: ");
        x = scan.nextInt();

        System.out.print("Column of element to remove: ");
        y = scan.nextInt();

        mat.removeElement(x,y);
      }

      //get an element
      else if (choice == 6) {

        System.out.print("Row of element to retrieve: ");
        x = scan.nextInt();

        System.out.print("Column of element to retrieve: ");
        y = scan.nextInt();

        System.out.println("Element: " + mat.getElement(x,y));
      }

      //print the determinant
      else if (choice == 7) {

        System.out.println("Determinant: " + mat.determinant());
      }

      //print the matrix
      else if (choice == 8) {

        System.out.println("Nonzero elements:\n" + mat);
      }

      //end the program
      else if (choice == 9) {

        System.out.println("Bye!");
        running = false;
      }

      //invalid menu choice
      else {

        System.out.println("Improper menu choice. Please input an integer from 1 to 9, inclusive.");
      }
    }
  }
}
