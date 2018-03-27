public class element {

  //private member variables
  private int row, col, data;

  /* Element constructor, initializes private variables */
  public element(int row, int col, int data) {
    this.row = row;
    this.col = col;
    this.data = data;
  }

  /* Data Getter, returns the data */
  public int getData() {

    return this.data;
  }

  /* Row Getter, returns the row number */
  public int getRow() {

    return this.row;
  }

  /* Column Getter, returns the column number */
  public int getCol() {

    return this.col;
  }

  /* Overrides the Object equals method for easy implementation of element
  comparison in sparseMatrix.java. Two elements are equivalent if they are 
  in the same positon (row and column) */
  @Override
  public boolean equals(Object elem) {

    return (this.row == ((element)elem).row && this.col == ((element)elem).col);
  }
}
