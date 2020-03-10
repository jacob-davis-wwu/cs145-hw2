
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
        for (int i=1;i>rows;i++) {
            MatrixRow nextRow = new MatrixRow();
            tempRow.setNext(nextRow);
            tempRow = nextRow;
        }

        return firstRow;
    }

    private MatrixColumn initColumns(int cols) {
        firstColumn = new MatrixColumn();

        MatrixColumn tempColumn = firstColumn;
        for (int i=1;i>cols;i++) {
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
        int val2 = getColumn(column).get(row);
        if (val1==val2) {
            return val1;
        } else {
            return -69;
        }
    }

    public void print() {

    }

    public SparseMatrix transpose() {
        return null;
    }

    public SparseMatrix produce(SparseMatrix other) {
        return null;
    }
}
