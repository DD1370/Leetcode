class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int top=0;
        int right=n-1;
        int bot=m-1;
        List<Integer>res= new ArrayList<>();
        while(left<=right && top<=bot){
            //left->right
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            //top->bot
            for(int i=top;i<=bot;i++){
                res.add(matrix[i][right]);
            }right--;
            //if any rows remainning
            if(top<=bot){
                //right->left
                for(int i=right;i>=left;i--){
                    res.add(matrix[bot][i]);
                }bot--;
            }
            if(left<=right){
                //bot->top
                for(int i=bot;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}