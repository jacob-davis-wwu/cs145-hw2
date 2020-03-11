
public class Homework2 {
    public void run() {
        MatrixReader reader = new MatrixReader();
        SparseMatrix mA = reader.read("matrixA.txt");
        mA.print();
        SparseMatrix mB = reader.read("matrixB.txt");
        mB.print();
        mA.transpose().print();
        mB.transpose().print();
        mA.produce(mB).print();
    }
}
