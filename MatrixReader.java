import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MatrixReader {

    public SparseMatrix read(String file){
        SparseMatrix m;
        try {
            File inputFile = new File(file);
            Scanner inputLine = new Scanner(inputFile);

            int rows = inputLine.nextInt();
            inputLine.nextLine();
            int cols = inputLine.nextInt();
            inputLine.nextLine();
            m = new SparseMatrix(rows,cols);

            int currentRow = 1;
            while ( inputLine.hasNext() ) {
                String newLine = inputLine.nextLine();
                String[] valStrings = newLine.trim().split(" ");
                for ( String valString : valStrings ) {
                    String[] values = valString.split(",");
                    int col = Integer.parseInt(values[0]);
                    m.insert(currentRow, Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                }
                currentRow++;
            }
            return m;

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, please try again.");
        }
        return null;
    }
}
