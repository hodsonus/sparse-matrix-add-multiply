import java.util.LinkedList;
import java.util.Iterator;

public class SparseMatrix implements SparseInterface {

  //private member values
  private int numCols, numRows;
  private LinkedList<element> list;

  /* this constructor initializes the list of elements. the size of the
  SparseMatrix will be set using the setSize() method. */
  public SparseMatrix() {

    this.list = new LinkedList<element>();
    this.numCols = 5;
    this.numRows = 5;
  }

  /* Should clear the matrix of all entries (make all entries 0) */
  @Override
  public void clear() {

    //just point list to a new blank linked list
    this.list = new LinkedList<element>();
  }

  /*
      Sets maximum size of the matrix, should also clear the matrix (make all elements 0)
   */
  @Override
  public void setSize(int numRows, int numCols) {

    clear();
    this.numRows = numRows;
    this.numCols = numCols;
  }

  /* Row data member getter */
  @Override
  public int getNumRows() {

    return this.numRows;
  }

  /* column data member getter */
  @Override
  public int getNumCols() {

    return this.numCols;
  }

  /*
      Adds an element to the row and column passed as arguments (overwrites if element is already present at that position).
      Throws an error if row/column combination is out of bounds.
   */
  @Override
  public void addElement(int row, int col, int data) {

    if (data == 0) return;

    //check to see if the row and column are valid arguments
    try {

      if (!(row < numRows && col < numCols) || (row < 0) || (col < 0)) throw new OutOfBoundsException("Not a valid row/column combination.");
    }
    catch (OutOfBoundsException e) {

      //if the either the row or the column weren't valid arguments, print the message and return with no element added
      System.out.println(e.toString());
      return;
    }

    //remove the element, if it exists, from the list
    removeElement(row, col);

    //find where the element should be placed
    int i = 0;

    for (element elem : list) {

      if (elem.getRow() < row) i++;

      else if (elem.getRow() == row) {

        if (elem.getCol() < col) i++;
      }
    }

    //place the element in sorted order
    list.add(i, new element(row, col, data));
  }

  /*
      Remove (make 0) the element at the specified row and column.
      Throws an error if row/column combination is out of bounds.
   */
  @Override
  public void removeElement(int row, int col) {

    //check to see if the row and column are valid arguments
    try {

      if (!(row < numRows && col < numCols) || (row < 0) || (col < 0)) throw new OutOfBoundsException("Not a valid row/column combination.");
    }
    catch (OutOfBoundsException e) {

      //if the either the row or the column weren't valid arguments, print the message and return with no element added
      System.out.println(e.toString());
      return;
    }

    //two elements are identical if they are in the same position. 0 is a sentinel value
    list.remove(new element(row, col, 0));
  }

  /*
      Return the element at the specified row and column
      Throws an error if row/column combination is out of bounds.
   */
  @Override
  public int getElement(int row, int col) {

    //check to see if the row and column are valid arguments
    try {

      if (!(row < numRows && col < numCols) || (row < 0) || (col < 0)) throw new OutOfBoundsException("Not a valid row/column combination.");
    }
    catch (OutOfBoundsException e) {

      //if the either the row or the column weren't valid arguments, print the message and return with no element added
      System.out.println(e.toString());
      return 0;
    }

    //utilize the overridden Object equals method and the list indexOf method to determine if the element is present in the list.
    int pos = list.indexOf(new element(row, col, 0));

    //if the element isn't in the list the data value is 0
    if (pos == -1) return 0;

    //since the element is in the list, grab it from the list and get it's data value
    return ((element)list.get(pos)).getData();
  }

  /*
  Should return the nonzero elements of your sparse matrix as a string.
  The String should be k lines, where k is the number of nonzero elements.
  Each line should be in the format "row column data" where row and column are the "coordinate" of the data and all are separated by spaces.
  An empty matrix should return an empty string.
  The print should be from left to right and from top to bottom (like reading a book) i.e. the matrix

                                                   3 0 1
                                                   0 2 0
                                                   0 0 4

                                               Should print as:
                                                   0 0 3
                                                   0 2 1
                                                   1 1 2
                                                   2 2 4

   */
  @Override
  public String toString() {

    //create a temporary variables and an iterator
    String temp = "";
    element elem;
    Iterator iter = list.iterator();

    //iterate over each node in the lsit
    while (iter.hasNext()) {

      //grab the current node
      elem = (element)iter.next();

      // /* add the node's particular data items to the string and add a new line */
      temp += elem.getRow() + " " + elem.getCol() + " " + elem.getData() + "\n";
    }

    //return the string that we have been concatenating data on
    return temp;
  }

  /* takes another matrix as input and returns the sum of the two matrices
  return NULL if sizes incompatible */
  @Override
  public SparseInterface addMatrices(SparseInterface matrixToAdd) {

    return null;
  }

  /*takes another matrix as input and returns the product of the two matrices*/
  /*return NULL if sizes incompatible*/
  @Override
  public SparseInterface multiplyMatrices(SparseInterface matrixToMultiply) {

    return null;
  }
}
