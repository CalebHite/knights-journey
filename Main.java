import java.text.DecimalFormat;
 
public class Main
{
    public static void main (String[] args)
    {
       int[][] board = new int[8][8];
       startBoard(board);
       showBoard(board);

        for(int i = 0; i < 64; i++){
            nextMove(board);
        }
    }
    
    // Initializes the 2D board array with 0s and 1 at the top-left.
    public static void startBoard(int[][] brd)
    {
       for(int[] col : brd){
           for(int spot : col){
               spot = 0;
           }
       }
       brd[0][0] = 1;
    }
    
    // Displays a matrix of board values using the 2-digit format.
    public static void showBoard(int[][] brd)
    {
       for(int[] col : brd){
           for(int spot : col){
               
               System.out.print(spot + " ");
           }
           System.out.println();
       }
       System.out.println();
    }       
    
    // Used by method nextMove to see if a board location was visited.
    public static boolean checkVisit(int[][] brd, int r, int c)
    {
       if(brd[r][c] != 0){
           return true;
       }
       return false;
    } 
    
    // Finds a knight-type move to the next location, if possible.
    public static void nextMove(int[][] brd)
    {
        int placeValue = 2;
        int row = 0;
        int col = 0;

        int max = 0;

        for(int i = 0; i < brd.length; i++){
            for(int j = 0; j < brd[i].length; j++){
                if(brd[i][j] > max){
                    max = brd[i][j];

                    row = i;
                    col = j;
                }
            }
        }

        boolean[] posMoves = getPossibleMoves(brd, row, col);
        
        if(posMoves[6]){
            brd[row+1][col-2] = max + 1;
        }
        else if(posMoves[7]){
            brd[row+2][col-1] = max + 1;
        }
        else if(posMoves[0]){
            brd[row+2][col+1] = max + 1;
        }
        else if(posMoves[1]){
            brd[row+1][col+2] = max + 1;
        }
        else if(posMoves[2]){
            brd[row-1][col+2] = max + 1;
        }
        else if(posMoves[3]){
            brd[row-2][col+1] = max + 1;
        }
        else if(posMoves[4]){
            brd[row-2][col-1] = max + 1;
        }
        else if(posMoves[5]){
            brd[row-1][col-2] = max + 1;
        }

        showBoard(brd);
    }

    public static boolean[] getPossibleMoves(int[][] brd, int r, int c){

        boolean[] posMoves = new boolean[8];

        if(r <= 5 && c <= 6){
            if(!checkVisit(brd, r + 2, c + 1)){
                posMoves[0] = true;
            }
        }
        if(r <= 6 && c <= 5){
            if(!checkVisit(brd, r + 1, c + 2)){
                posMoves[1] = true;
            }
        }
        if(r >= 1 && c <= 5){
            if(!checkVisit(brd, r - 1, c + 2)){
                posMoves[2] = true;
            }
        }
        if(r >= 2 && c <= 6){
            if(!checkVisit(brd, r - 2, c + 1)){
                posMoves[3] = true;
            }
        }
        if(r >= 2 && c >= 1){
            if(!checkVisit(brd, r - 2, c - 1)){
                posMoves[4] = true;
            }
        }
        if(r >= 1 && c >= 2){
            if(!checkVisit(brd, r - 1, c - 2)){
                posMoves[5] = true;
            }
        }
        if(r <= 6 && c >= 2){
            if(!checkVisit(brd, r + 1, c - 2)){
                posMoves[6] = true;
            }
        }
        if(r <= 5 && c >= 1){
            if(!checkVisit(brd, r + 2, c - 1)){
                posMoves[7] = true;
            }
        }

        return posMoves;
    }
}