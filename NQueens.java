import java.util.ArrayList;
import java.util.List;

/**
 * Created by maggie on 12/21/15.
 */
public class NQueens {
    List<List<String>> solutions = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {

        ArrayList<String> solution = createSolutionList(n);


        solveNQueensHelper(solution, 0, n);

        return solutions;
    }

    public void printSolutions(List<List<String>> solutions,int n){
        for(int i =0; i< solutions.size(); i++){
            for(int j =0; j< solutions.get(0).size(); j++){
                for(int k =0; k<n; k++){
                    System.out.print(solutions.get(i).get(j).charAt(k));
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    public void solveNQueensHelper( ArrayList<String> solution, int row, int n){
        //trivial case
        if(row == n) {
            solutions.add((List<String>)solution.clone());
            return;
        }


        for(int i =0; i< n; i++){
            if(validQueen(solution, row,i,n)){
                replaceACharInString(solution,row,i,'Q');
                solveNQueensHelper(solution,row+1,n);
                replaceACharInString(solution,row,i,'.');
            }
        }
    }

    public void replaceACharInString(List<String> solution, int row, int column, char c){
        StringBuilder newString = new StringBuilder(solution.get(row));
        newString.setCharAt(column,c);
        solution.set(row,newString.toString());

    }

    public ArrayList<String> createSolutionList(int n){
        ArrayList<String> solution = new ArrayList<String>();
        for(int i = 0; i< n; i++){
            String row = "";
            for(int j = 0; j < n; j++){
                row = row + '.';
            }
            solution.add(row);
        }
        return solution;
    }

    public boolean validQueen(List<String> solution, int row, int column, int n){
        //column
        for(int i =0; i< row; i++){
            if(solution.get(i).charAt(column) == 'Q'){
                return false;
            }
        }
        //diagonal
        for(int i = row-1, j = column -1; i>=0 && j>=0; i--,j--){
            if(solution.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        for(int i = row-1, j = column +1; i>=0 && j<n; i--,j++){
            if(solution.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }
}
