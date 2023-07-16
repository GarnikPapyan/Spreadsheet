import java.util.Arrays;
public class Main {

	public static void main(String[] args) {

		Spreadsheet spreadsheet = new Spreadsheet(3, 3);

        spreadsheet.setValueAt(0, 0, 1);
        spreadsheet.setValueAt(0, 1, 2);
        spreadsheet.setValueAt(0, 2, 3);
        spreadsheet.setValueAt(1, 0, 4);
        spreadsheet.setValueAt(1, 1, 5);
        spreadsheet.setValueAt(1, 2, 6);
        spreadsheet.setValueAt(2, 0, 7);
        spreadsheet.setValueAt(2, 1, 8);
        spreadsheet.setValueAt(2, 2, 9);

        System.out.println(spreadsheet.toString());

        System.out.println("Sum of column 1: " + spreadsheet.getColumnSum(1));
        System.out.println("Sum of row 0: " + spreadsheet.getRownSum(0));
        System.out.println("Sum of area (0, 0) to (2, 1): " + spreadsheet.getAreaSum(0, 0, 2, 1));

        spreadsheet.addRow(1);
        spreadsheet.addColumn(2);

        spreadsheet.setValueAt(1, 0, 42);
        spreadsheet.setValueAt(1, 1, 42);
        spreadsheet.setValueAt(1, 2, 42);
        spreadsheet.setValueAt(1, 3, 42);
        spreadsheet.setValueAt(0, 2, 24);
        
        spreadsheet.setValueAt(2, 2, 24);
        spreadsheet.setValueAt(3, 2, 24);

        System.out.println(spreadsheet.toString());

        System.out.println("Average of column 2: " + spreadsheet.getColumnAverage(2));
        System.out.println("Average of row 0: " + spreadsheet.getRowAverage(0));
        System.out.println("Average of area (1, 1) to (3, 2): " + spreadsheet.getAreaAverage(1, 1, 3, 2));
		
	}
}