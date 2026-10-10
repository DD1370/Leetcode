class Solution {
    static boolean check(char[][] board,int row,int col,char num){
		for(int I = 0; I < 9; I++){
			//check row
			if(board[row][I] == num) return false;
			//check cols
			if(board[I][col] == num) return false;
			//Box check 3*3
			int boxRow = 3*(row/3) + (I/3);
			int boxCol = 3*(col/3) + (I%3);
			if(board[boxRow][boxCol] == num) return false;
			}return true;
        } 
    public static boolean solve(char[][] board){
        //find empty cell
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                //if we find empty cell
                if(board[row][col] == '.'){
                    //check from 1 to 9 which fits there
                    for(char num = '1'; num <= '9'; num++){
                        if(check(board,row,col,num)){
                            board[row][col] = num;
                            //explore for remaining cells(recursive call)
                            if(solve(board)){
                                return true;//if the board is solved,return true at every recursive step
                            }
                            //undo/backtracking
                            board[row][col] = '.';//the number we placed is not correct number.check next
                        }
                    }return false;//1 to 9 we cannot fix any numbers
                }
            }
        }return true;

    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}