class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        boolean[] remove=new boolean[s.length()];
        //traverse through string indexes 
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            //if the c is "(" pushing into the stack
            if(c=='('){
                stack.push(i);
            }
            //c is ")" ->pop item from stack
            else if(c==')'){
                //if stack is not empty pop item
                if(!stack.isEmpty()){
                    stack.pop();
                }
                //stack is empty-> then this specific index char i should be removed
                else{
                    remove[i]=true;
                }
            }
        }
        //checking any extra brackets left in the stack
        while(!stack.isEmpty()){
            remove[stack.pop()]=true; 
        }
        // creating the result string
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!remove[i]){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}