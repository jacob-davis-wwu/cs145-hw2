
public class Homework2 {
    public void run() {
        SparseMatrix mA = new SparseMatrix(2,2);
        mA.insert(1,1,1);
        mA.insert(1,2,2);
        mA.insert(2,1,3);
        mA.insert(2,2,4);
        SparseMatrix mB = mA.transpose();
        mA.print();
        mA.produce(mB).print();
        mA.produce(mA).print();
    }
}
