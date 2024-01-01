import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacter {
    
    public static void main(String[] args) {
        // String[] words = {"cook", "lock", "cool"};
        String[] words = {"bella","label","roller"};

        commonChars(words);
    }

    public static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        // Arrays.sort(words);
        // System.out.println(Arrays.toString(words));
        Map<Character, Integer> oMap = new LinkedHashMap<>();
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for(int i=0; i < words[0].length(); i++) {
            char key = words[0].charAt(i);
            oMap.put(key, oMap.getOrDefault(key, 0)+1);
        }

        // System.out.println(oMap);

        for(int i=1; i < words.length; i++) {
            String curr = words[i];
            countMap.clear();
            for(int j=0; j < curr.length(); j++) {
                char key = curr.charAt(j);
                countMap.put(key, countMap.getOrDefault(key, 0)+1);
            }
            System.out.println("countMap" + countMap);
            removeUnique(oMap, countMap);
            System.out.println("after" + oMap);
        }

        // System.out.println(oMap);

        for(Map.Entry<Character, Integer> entry : oMap.entrySet()) {
            List val = Collections.nCopies(entry.getValue(), entry.getKey());
            list.addAll(val);
        }
        
        // System.out.println(list);

        return list;
    }

    static void removeUnique(Map<Character, Integer> oMap, Map<Character, Integer> countMap) {
        ArrayList<Character> list = new ArrayList<>(oMap.keySet());
        for(Character oKey : list) {
            if(countMap.containsKey(oKey)) {
                oMap.put(oKey, Math.min(oMap.get(oKey), countMap.get(oKey)));
            } else {
                oMap.remove(oKey);
            }
        }
    }
    
}
