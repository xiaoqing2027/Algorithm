import java.util.*;


public class SudokuSolver {
    private final int dim = 9;
    private final int square_dim = 3;

    public void solveSudoku(char[][] board) {
        //find the first empty cell
        int i = getNextEmptyCell(board, 0);
        //only fill empty cells
        solve(board, i /dim , i%dim);
    }

    public boolean solve(char[][] board, int i, int j){
        //get possible number I fill in empty cell
        List<Character> candidates = getCandidates(board,i,j);
        //trivial case/base case
        boolean isLastCell = getNextEmptyCell(board, i * dim + j + 1) == -1;
        if(isLastCell && candidates.size() != 0) {
            board[i][j] = candidates.get(0);
            return true;
        }

        for(char c : candidates){
            board[i][j]= c;
            int next = getNextEmptyCell(board, i* dim + j + 1);
            if(solve(board, next/dim, next%dim )){
                return true;
            }else {
                board[i][j] = '.';
            };
        }
        return false;
    }

    // get next index of '.' in the board. including currentCell
    // to get first '.' use getNextEmptyCell(board, 0)
    // -1 will be returned when no available '.' is found.
    public int getNextEmptyCell(char[][] board, int currentCell){
        if(currentCell > dim * dim -1) {
            return -1;
        }
        int i = currentCell / dim;
        int j = currentCell % dim;
        while(board[i][j] != '.'){
            currentCell++;
            if(currentCell > dim* dim -1) {
                return -1;
            }
            i = currentCell / dim;
            j = currentCell % dim;
        }
        return i * dim + j;
    }

    public List<Character> getCandidates(char[][] board, int i, int j){
        //candidate list

        List<Character> candidates = new ArrayList<Character>();
        for(int c = 1; c<= dim; c++) {
            candidates.add((char)((int)'0' + c));
        }
        // check i-th row
        for(int k=0;k<dim;k++){
            if(board[i][k]!='.'){
                candidates.remove(new Character(board[i][k]));
            }
        }
        // check j-th column
        for(int k=0;k<dim;k++){
            if(board[k][j]!='.'){
                candidates.remove(new Character(board[k][j]));
            }
        }
        // check 3x3 square
        int x0 = square_dim * (i / square_dim);
        int y0 = square_dim * (j / square_dim);
        for(int m = x0; m < x0 + square_dim; m++) {
            for(int n = y0; n < y0 + square_dim; n++) {
                if(board[m][n]!='.'){
                    candidates.remove(new Character(board[m][n]));
                }
            }
        }
        long seed = System.nanoTime();
        Collections.shuffle(candidates, new Random(seed));
        return candidates;
    }

    public void printBoard(char[][] board) {
        for(int i=0; i< dim ;i++){
            for(int j=0; j<dim; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        sudokuSolver.printBoard(board);

    }

}
