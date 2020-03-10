
public class Homework2 {
    public void run() {
        SparseMatrix mA = new SparseMatrix(5,5);
        mA.insert(2,4,5);
        mA.insert(1,4,5);
        mA.insert(1,3,5);
        System.out.println(mA.getValue(1,5));
        mA.print();
    }
}
