import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canArrange(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int mod = arr[i] % k;
            int target = mod == 0 ? 0 : k - mod;
            int target2 = mod == 0 ? 0 : -k - mod;
            if (map.containsKey(target)) {
                int c = map.remove(target);
                c--;
                if (c != 0) {
                    map.put(target, c);
                }
            } else if (map.containsKey(-mod)) {
                int c = map.remove(-mod);
                c--;
                if (c != 0) {
                    map.put(-mod, c);
                }
            } else if (map.containsKey(target2)) {
                int c = map.remove(target2);
                c--;
                if (c != 0) {
                    map.put(target2, c);
                }
            } else {
                int c = map.getOrDefault(mod, 0);
                c++;
                map.put(mod, c);
            }

        }

        return map.isEmpty();
    }
}