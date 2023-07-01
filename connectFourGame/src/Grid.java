import Util.GlobalEnum;

public class Grid {
    private int rows;
    private int columns;
    private int[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        initGrid();
    }

    private void initGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; i < columns; j++) {
                grid[i][j] = GlobalEnum.EMPTY.ordinal();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int placePiece(int column, GlobalEnum piece){
        if(piece == GlobalEnum.EMPTY){
            throw new Error("Wrong Piece");
        }
        if(column <  0 || column >= this.columns){
            throw new Error("Wrong column");
        }
        for(int i = this.rows - 1; i >= 0; i-- ){
            if(this.grid[i][column] == GlobalEnum.EMPTY.ordinal()){
                this.grid[i][column] = piece.ordinal();
                return i;
            }
        }
        return -1;
    }

    public boolean checkStatus(int connectX, int row, int column, GlobalEnum piece){
        int count = 0;
        for(int i = 0; i < this.columns; i++){
            if(this.grid[row][i]== piece.ordinal()){
                count++;
            }else{
                count = 0;
            }
            if(count == connectX){
                return true;
            }
        }

        count = 0;
        for(int i = 0; i < this.rows; i++){
            if(this.grid[i][column]== piece.ordinal()){
                count++;
            }else{
                count = 0;
            }
            if(count == connectX){
                return true;
            }
        }

        count = 0;
        for(int i = 0; i < this.rows; i++){
            int c = row + column - i;
            if(c >= 0 && c < this.columns && this.grid[i][c]== piece.ordinal()){
                count++;
            }else{
                count = 0;
            }
            if(count == connectX){
                return true;
            }
        }

        count = 0;
        for(int i = 0; i < this.rows; i++){
            int c = column - row + i;
            if(c >= 0 && c < this.columns && this.grid[i][c]== piece.ordinal()){
                count++;
            }else{
                count = 0;
            }
            if(count == connectX){
                return true;
            }
        }

        return false;
    }
}
