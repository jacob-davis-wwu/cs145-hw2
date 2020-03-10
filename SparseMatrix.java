
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

    }

    public MatrixRow getRow(int position) {
        return null;
    }

    public MatrixColumn getColumn(int position) {
        return null;
    }

    public int getValue(int row, int column) {
        return 0;
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
