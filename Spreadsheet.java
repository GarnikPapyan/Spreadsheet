
 public class Spreadsheet {

		
	private Cell[][] cell;
    private int columns;
    private int rows;

	public Spreadsheet(int columns,int rows) {
		if (columns <= 0 || rows <= 0) {
            throw new RuntimeException("Rows and Columns can't have negativ cordinats");
        }

        this.columns = columns;
        this.rows = rows;
        this.cell = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cell[i][j] = new Cell();
            }
        }
	}


	public void addColumn(int newColumn) {
		if(newColumn<0 || newColumn>columns) {
			throw new RuntimeException("Chi lini avelacnel qani vor ayn syuneri qanakic mece kam 0-ic poqr");
		}

		columns++;
		Cell[][] newCell = new Cell[rows][columns];
		for(int i=0;i<rows;i++){
			for(int j=0;j<newColumn;j++) {

				newCell[i][j] = cell[i][j];	
			}
			newCell[i][newColumn] = new Cell();
			for(int x = newColumn+1; x < columns; x++ ) {
				newCell[i][x] = cell[i][x-1];
			}
		}

		cell = newCell;
	}

	public void addRow(int newRow) {
		if(newRow<0 || newRow>columns) {
			throw new RuntimeException("Chi lini avelacnel qani vor ayn toxer qanakic mece kam 0-ic poqr");
		}

		rows++;
		Cell[][] newCell = new Cell[rows][columns];
		for (int i = 0; i < newRow; i++) {
            newCell[i] = cell[i];
        }
        newCell[newRow] = new Cell[columns];
        for (int i = newRow + 1; i < rows; i++) {
            newCell[i] = cell[i - 1];
        }
        for (int i = 0; i < columns; i++) {
            newCell[newRow][i] = new Cell();
        }

		cell = newCell;
	}

	public void setValueAt(int row, int column, Object value) {
		if(row<0 || column<0 || row>rows || column>columns) {
			throw new RuntimeException("voch korekt row kam cloumn eq tvel");
		}
		cell[row][column].setValue(value);
	}

	public Object getValueAt(int row, int column) {

		if(row<0 || column<0 || row>rows || column>columns) {
			throw new RuntimeException("voch korekt row kam cloumn eq tvel");
		}

		return cell[row][column].getValue();

	}


	public void setColorAt(int row, int column , Color color) {

		if(row<0 || column<0 || row>rows || column>columns) {
			throw new RuntimeException("voch korekt row kam cloumn eq tvel");
		}

		cell[row][column].setColor(color);

	}


	public Object getColorAt( int row, int column) {

		if(row<0 || column<0 || row>rows || column>columns) {
			throw new RuntimeException("voch korekt row kam cloumn eq tvel");
		}

		return cell[row][column].getColor();

	}

	public void reset() {
		for(int i = 0;i<rows; i++) {
			for(int j = 0; j<columns;j++) {
				cell[i][j].reset();
			}
		}
	}


	public void resetCellAt(int row, int column) {

		if(row<0 || column<0 || row>rows || column>columns) {
			throw new RuntimeException("voch korekt row kam cloumn eq tvel");
		}

		cell[row][column].reset();
	}

	public double getColumnSum(int column) {
		if(column<0 || column>columns) {
			throw new RuntimeException("Voch valid syunak");
		}

		double sum = 0;
		for (int i = 0;i<rows;i++) {

			Object value = cell[i][column].getValue();

			if(value instanceof Number) {
				sum += ((Number) value).doubleValue();
			}
		}
		return sum;
	}

	public double getRownSum(int row) {
		if(row<0 || row>columns) {
			throw new RuntimeException("Voch valid tox");
		}

		double sum = 0;
		for (int i = 0;i<columns;i++) {

			Object value = cell[row][i].getValue();

			if(value instanceof Number) {
				sum += ((Number) value).doubleValue();
			}
		}
		return sum;
	}

	public double getAreaSum(int row1, int column1, int row2, int column2) {

		if(row1<0 || row2<0 || column1<0 || column2<0 || row2>rows || row1>rows || column1>columns || column2>columns) {
			throw new RuntimeException("voch korekt row kam cloumn eq tvel");
		}

		double sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {

                Object value = cell[i][j].getValue();

                if(value instanceof Number) {

				sum += ((Number) value).doubleValue();

				}

            }

        }
        return sum;
	}

	public double getColumnAverage(int column) {

		if(column<0 || column>columns) {
			throw new RuntimeException("Voch valid syunak");
		}

        return getColumnSum(column)/rows;
    }

    public double getRowAverage(int row) {

    	if(row<0 || row>columns) {
			throw new RuntimeException("Voch valid tox");
		}
		double sum = getRownSum(row);
        return sum/columns;
    }


    public double getAreaAverage(int row1, int column1, int row2, int column2) {

    	if(row1<0 || row2<0 || column1<0 || column2<0 || row2>rows || row1>rows || column1>columns || column2>columns) {
			throw new RuntimeException("voch korekt row kam cloumn eq tvel");
		}
        double sum = 0;
        int count = 0;

        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                Object value = cell[i][j].getValue();

                if(value instanceof Number) {

				sum += ((Number) value).doubleValue();
                count++;
            	}
            }

        }
        return sum/count;
    }

    
     public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(cell[i][j].getValue()).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
