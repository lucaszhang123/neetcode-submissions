class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> opening = new Stack<>();
        Stack<Integer> closing = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opening.push(i);
                System.out.println("push opening");
            }
            if (s.charAt(i) == ')') {
                if (opening.size() == 0) {
                    closing.push(i);
                    System.out.println("push closing");
                    continue;
                }

                opening.pop();
                System.out.println("remove opening");
            }
        }

        String ans = "";
        
        Set<Integer> contained = new HashSet<>();
        while (opening.size() != 0) {
            int x = opening.pop();
            contained.add(x);
            System.out.println(x);
            
        }
        while (closing.size() != 0) {
            int x = closing.pop();
            contained.add(x);
            System.out.println(x);
        }

        for (int i = 0; i < s.length(); i++) {
            if (contained.contains(i)) continue;
            
            ans += s.charAt(i);
        }

        return ans;
        
    }
}