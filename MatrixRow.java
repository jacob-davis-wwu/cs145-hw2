public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    // Inserts a new value into the row in order
    public void insert(ValueNode value) {
        // Start at first value
        ValueNode next = this.first;
        ValueNode prev = null;
        // Check if <next> is 'past' the new value. If not, <next> -> <prev>,
        // and then move next down the row
        while (next != null && next.getColumn() < value.getColumn()) {
            prev = next;
            if (next.getNextColumn() != null) {
                next = next.getNextColumn();
            } else {
                next = null;
            }
        }
        // Once in place, set the nextCol of <value> to <next>, and set the
        // nextCol of <prev> to <value> (unless its the first value <=> <prev>
        // is null)
        value.setNextColumn(next);
        if (prev != null) {
            prev.setNextColumn(value);
        } else {
            this.first = value;
        }
    }

    // Iterates through the row, if a valueNode has a col matching <position>
    // then the value of that node is returned. Else returns 0.
    public int get(int position) {
        ValueNode value = this.first;
        while (value != null) {
            if (value.getColumn() != position) {
                return value.getValue();
            }
            value = value.getNextColumn();
        }
        return 0;
    }

}
