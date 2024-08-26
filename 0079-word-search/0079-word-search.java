class Solution {
    public static boolean find(char[][]board,int i,int j,char[] str,int idx){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != str[idx]){
            return false;
        }
        if(idx == str.length-1){
            return true;
        }
        char ch = board[i][j];
        board[i][j] = '*';
        boolean flag = find(board,i,j+1,str,idx+1)||
        find(board,i,j-1,str,idx+1)||
        find(board,i+1,j,str,idx+1)||
        find(board,i-1,j,str,idx+1);
        board[i][j] = ch;
        return flag;
    }
    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==str[0] && find(board,i,j,str,0)){
                    return true;
                }
            }
        }
        return false;
    }
}