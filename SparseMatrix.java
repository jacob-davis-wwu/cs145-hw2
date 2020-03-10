
public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        this.firstRow = initRows(totalRows);
        this.firstColumn = initColumns(totalColumns);
    }

    private MatrixRow initRows(int rows) {
        firstRow = new MatrixRow();

        MatrixRow tempRow = firstRow;
        for (int i=1;i<rows;i++) {
            MatrixRow nextRow = new MatrixRow();
            tempRow.setNext(nextRow);
            tempRow = nextRow;
        }

        return firstRow;
    }

    private MatrixColumn initColumns(int cols) {
        firstColumn = new MatrixColumn();

        MatrixColumn tempColumn = firstColumn;
        for (int i=1;i<cols;i++) {
            MatrixColumn nextColumn = new MatrixColumn();
            tempColumn.setNext(nextColumn);
            tempColumn = nextColumn;
        }

        return firstColumn;
    }

    public void insert(int row, int column, int value) {
        ValueNode newNode = new ValueNode(row, column, value);

        MatrixRow newRow = getRow(row);
        MatrixColumn newCol = getColumn(column);

        newRow.insert(newNode);
        newCol.insert(newNode);
    }

    public MatrixRow getRow(int position) {
        MatrixRow p = this.firstRow;
        for (int i=1; i<position; i++) {
            p = p.getNext();
        }
        return p;
    }

    public MatrixColumn getColumn(int position) {
        MatrixColumn p = this.firstColumn;
        for (int i=1; i<position; i++) {
            p = p.getNext();
        }
        return p;
    }

    public int getValue(int row, int column) {
        int val1 = getRow(row).get(column);
        return val1;
    }

    public void print() {
        for (int i=1; i<=totalRows; i++) {
            String printStr = "| ";
            for (int j=1; j<=totalColumns; j++) {
                printStr = printStr + getValue(i,j) + " ";
                // printStr = printStr + i + "," + j + " ";
            }
            printStr = printStr + "|";
            System.out.println(printStr);
        }
    }

    public SparseMatrix transpose() {
        SparseMatrix tMat = new SparseMatrix(totalColumns, totalRows);
        for (int i=1; i<=totalRows; i++) {
            for (int j=1; j<=totalColumns; j++) {
                int val = this.getValue(i,j);
                if (val != 0) {
                    tMat.insert(j,i,val);
                }
            }
        }
        return tMat;
    }

    public SparseMatrix produce(SparseMatrix other) {
        SparseMatrix mProd = new SparseMatrix(this.getTotalRows(), other.getTotalColumns() );
        if (this.getTotalColumns() == other.getTotalRows() ) {
            for (int i=1; i<=mProd.totalRows; i++) {
                for (int j=1; j<=mProd.totalRows; j++) {
                    int nVal = 0;
                    for (int k=0; k<=this.getTotalColumns(); k++) {
                        nVal += this.getValue(i,k) * other.getValue(k,j);
                    }
                    if (nVal != 0) {
                        mProd.insert(i,j,nVal);
                    }
                }
            }
        } else {
            System.out.println("Mismatched matrices, make sure matrices are compatible before mutltiplying");
        }
        return mProd;
    }

    public int getTotalRows() {
        return this.totalRows;
    }

    public int getTotalColumns() {
        return this.totalColumns;
    }
}
