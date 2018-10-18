public class MaxMatrixSum{
    public static int matrixScore(int[][] A) { 
        int row = A.length; 
        int col = A[0].length; 
        int sum=0; 
        //1. if a row's first column is 0, flip that row
        for(int i=0; i<row; i++) {
            if(A[i][0] ==0) flipRow(A, i, col);
        }
    
        //2. check if in a column, except first column, amount of 0 is more than amount of 1, if so, flip that column
        for(int i=1; i<col; i++){
            int count=0; //count how many 0's 
            for(int j=0; j<row; j++) {
                if(A[j][i]==0) count++;
            }
            if (count> row/2) //number of 0 exceeds half of the column
                flipColumn(A, i, row); 
        }
        for (int m=0; m<row; m++) {
            for (int n=0; n<col; n++) {
                sum = sum + A[m][n] * (1<<(col-n-1)); //1 << x means to push x bit to the left, so if x is 2, 0001 is 0100, so 1 becomes 4
            }
        }
        return sum; 
    }
    private static void flipRow(int[][] array, int rowNumber, int col) {
        for(int i=0; i<col; i++){
            array[rowNumber][i] = array[rowNumber][i] ^ 1; //^ is xor... when A ^ 1, it will return 1 if A is 0, and return 0 if A is 1, in short it'll return 1 if two things xor together are different
        }
    }
    private static void flipColumn(int[][] array, int colNumber, int row) {
        for (int i=0; i<row; i++) {
            array[i][colNumber] = array[i][colNumber] ^ 1; 
        }
    }
    public static void main(String []args){
        int[][] array={{0,0,1,1},{1,0,1,0},{1,1,0,0}}; 
        int result = matrixScore(array); 
        System.out.println("result is "+result+"\n");
    }
}
