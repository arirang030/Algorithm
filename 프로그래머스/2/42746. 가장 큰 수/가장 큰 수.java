import java.util.*;

class Solution {
    
    StringBuilder sb = new StringBuilder();
    
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(list, (n1, n2) 
                         -> Integer.parseInt(n2 + n1) - Integer.parseInt(n1 + n2));
        
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        
        return list.get(0).equals("0") ? "0" : sb.toString();
    }
}