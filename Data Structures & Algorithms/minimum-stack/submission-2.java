class MinStack {
    Stack<Integer> s;
    Stack<Integer> minVals;

    public MinStack() {
        s = new Stack<Integer>();
        minVals = new Stack<Integer>();
    }
    
    public void push(int val) {
        s.push(val);
        if (minVals.empty() || val <= minVals.peek()) minVals.push(val);
    }
    
    public void pop() {
        int pushed = s.pop();
        if (pushed == minVals.peek()) minVals.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minVals.peek();
    }
}
