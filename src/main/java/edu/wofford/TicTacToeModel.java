package edu.wofford;


public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };
    protected Mark[][] board;
    public enum Move {Xmove, Omove};
    private Move PlayersMove;
    private Result CurrentResult;

    public TicTacToeModel() {
        board = new Mark[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = Mark.EMPTY;
            }
        }
        PlayersMove = Move.Xmove;
        CurrentResult = Result.NONE;
    }
    
    public boolean setMarkAt(int row, int col) {
        if((row>=3 || row < 0) || (col>=3 || col < 0)  ){
            return false;
        }
        else{
            if(getResult() == Result.NONE){
                if(PlayersMove == Move.Xmove  && ((board[row][col] == Mark.EMPTY))) {
                    board[row][col] = Mark.XMARK;
                    PlayersMove = Move.Omove;
                    return true;
                }
                else if(PlayersMove == Move.Omove  && ((board[row][col] == Mark.EMPTY))) {
                    board[row][col] = Mark.OMARK;
                    PlayersMove = Move.Xmove;
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }



        }
    }
    
    public Mark getMarkAt(int row, int col) {
        if((row >=3 || row < 0 ) || (col >= 3 || col <0)){
            return Mark.EMPTY;

        }
        else{
            return board[row][col];
        }
    }

    private boolean Owins(Mark A,Mark B, Mark C){

        if( ((A.equals(Mark.OMARK)) && B.equals(Mark.OMARK)) && C.equals(Mark.OMARK)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean Xwins(Mark A, Mark B, Mark C){
        if(((A.equals(Mark.XMARK))&& B.equals(Mark.XMARK))&& C.equals(Mark.XMARK)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean XcheckRows(){
        for(int i=0; i<3; i++){
            if(Xwins(board[i][0], board[i][1], board[i][2] )) {
                return true;
            }
        }
        return false;
    }

    private boolean OcheckRows(){
        for(int i=0; i<3; i++){
            if (Owins(board[i][0], board[i][1], board[i][2]     )){
                return true;
            }
        }
        return false;
    }

    private boolean XcheckCols(){
        for(int i=0; i<3; i++){
            if(Xwins(board[0][i], board[1][i], board[2][i]  )){
                return true;
            }
        }
        return false;
    }

    private boolean OcheckCols(){
        for(int i=0; i<3; i++){
            if (Owins(board[0][i], board[1][i], board[2][i])) {
                return true;

            }
        }
            return false;
    }

    private boolean Xdiag(){
        if(Xwins(board[0][0], board[1][1], board[2][2]) || Xwins(board[2][0], board[1][1], board[0][2])){
            return true;
        }

        else{
            return false;
        }
    }
    private boolean ODiag(){
        if(Owins(board[0][0], board[1][1], board[2][2])  || Owins(board[2][0], board[1][1], board[0][2])) {
            return true;
        }
        else{
            return false;
        }
        }

    private boolean isBoardFull(){
        for(int i =0; i<3; i++){
            for(int j=0; j <3; j++){
                if(board[i][j].equals(Mark.EMPTY)   ){
                    return false;
                }
            }
        }

        return true;
    }

    public Result getResult() {
        if((Xdiag()  || XcheckRows() || XcheckCols() )){
            return Result.XWIN;
        }
        else if(OcheckCols() || OcheckRows() || ODiag()){
            return Result.OWIN;
        }
        else if (isBoardFull()){
            return Result.TIE;
        }
        else {
            return Result.NONE;
        }




    }

    private String getFirstRow(){
        String builder = "";
        for(int i=0; i < 3; i++){
            if (board[0][i] == Mark.XMARK) {
                builder = builder + "X";
            }
            else if (board[0][i] == Mark.OMARK){
                builder = builder + "O";
            }
            else{
                builder = builder + " ";
            }
        }
        return builder;
    }

    private String getSecondRow(){
        String builder = "";
        for(int i=0; i < 3; i++){
            if (board[1][i] == Mark.XMARK) {
                builder = builder + "X";
            }
            else if (board[1][i] == Mark.OMARK){
                builder = builder + "O";
            }
            else{
                builder = builder + " ";
            }
        }
        return builder;
    }

    private String getThirdRow(){
        String builder = "";
        for(int i=0; i < 3; i++){
            if (board[2][i] == Mark.XMARK) {
                builder = builder + "X";
            }
            else if (board[2][i] == Mark.OMARK){
                builder = builder + "O";
            }
            else{
                builder = builder + " ";
            }
        }
        return builder;
    }



    public String toString() {
        String firstRowString = getFirstRow();
        String secondRowString = getSecondRow();
        String thirdRowString = getThirdRow();

        String firstRow = firstRowString.substring(0,1) + "|" + firstRowString.substring(1,2) + "|" + firstRowString.substring(2,3);
        String secondRow = secondRowString.substring(0,1) + "|" + secondRowString.substring(1,2) + "|" + secondRowString.substring(2,3);
        String thirdRow = thirdRowString.substring(0,1) + "|" + thirdRowString.substring(1,2) + "|" + thirdRowString.substring(2,3);

        String seperator = "-----";
        String builder = firstRow + "\n" + seperator + "\n" + secondRow + "\n" + seperator + "\n" + thirdRow;


        return builder;

    }    

}