class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (String i : tokens) {
            if (!i.equals("+") && !i.equals("-") && !i.equals("*") && !i.equals("/")) {
                nums.push(Integer.parseInt(i));
                //System.out.println(i + " pushed to stack");
                continue;
            }

            int n2 = nums.pop();
            int n1 = nums.pop();
            int res;

            if (i.equals("+")) {
                //System.out.println(n1 + " + " + n2);
                res = n1 + n2;
            }
            else if (i.equals("-")) {
                //System.out.println(n1 + " - " + n2);
                res = n1 - n2;
            }
            else if (i.equals("*")) {
                //System.out.println(n1 + " * " + n2);
                res = n1 * n2;
            }
            else {
                //System.out.println(n1 + " / " + n2);
                res = n1/n2;
            }

            nums.push(res);
        }

        return nums.peek();
    }
    /*
    1 2
    +
    pop1 pop2

    do operation

    put op back in stack
    */
}
