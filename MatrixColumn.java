public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    // Inserts a new value into the row in order
    public void insert(ValueNode value) {
        // Start at first value
        ValueNode next = this.first;
        ValueNode prev = null;
        // Check if <next> is 'past' the new value. If not, <next> -> <prev>,
        // and then move next down the row
        while (next != null && next.getRow() < value.getRow()) {
            prev = next;
            if (next.getNextRow() != null) {
                next = next.getNextRow();
            } else {
                next = null;
            }
        }
        // Once in place, set the nextRow of <value> to <next>, and set the
        // nextRow of <prev> to <value> (unless its the first value <=> <prev>
        // is null)
        value.setNextRow(next);
        if (prev != null) {
            prev.setNextRow(value);
        } else {
            this.first = value;
        }
    }

    // Iterates through the col, if a valueNode has a row matching <position>
    // then the value of that node is returned. Else returns 0.
    public int get(int position) {
        ValueNode value = this.first;
        while (value != null) {
            if (value.getRow() == position) {
                return value.getValue();
            }
            value = value.getNextRow();
        }
        return 0;
    }

}
