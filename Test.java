public class Test {

    /*
        This is a small set of testing code to make sure you are implementing our SparseInterface.
        You should be getting all "true" for the output

        This is NOT the full extent of our testing, but passing these cases are essential to
        passing our full tests.
    */

    public static void main(String[] args){
        SparseInterface myTest = new SparseMatrix();

        myTest.addElement(0, 0, 16);

        myTest.addElement(0, 1, 4);

        myTest.removeElement(0,1);

        String correctString = "0 0 16\n";

        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

        myTest.setSize(3);

        System.out.println("Size is 3: " + (myTest.getSize() == 3));

        correctString = "";

        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

        myTest.addElement(2,2,4);

        myTest.addElement(1,0,-3);

        correctString = "1 0 -3\n2 2 4\n";

        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

        System.out.println("The determinant is 0: " + (myTest.determinant() == 0));

        SparseInterface myMinor = myTest.minor(1,1);

        System.out.println("The (1,1) element of the minor is 4: " + (myMinor.getElement(1, 1) == 4));

        myTest.clear();
    }
}
