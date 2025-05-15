class RandomizedCollection {

    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    Random r = new Random();

    public RandomizedCollection() {

    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            list.add(val);
            map.get(val).add(list.size() - 1);
            return false;
        } else {
            list.add(val);
            HashSet<Integer> s = new HashSet<>();
            s.add(list.size() - 1);
            map.put(val, s);
            return true;
        }
        
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }
        int idx1 = -1;
        //retrieve the first random index from the set
        for (int i : map.get(val)) {
            idx1 = i;
            break;
        }

        int idx2 = list.size() - 1;

        //if idx1 is already the last index, remove directly
        if (idx1 == idx2) {
            map.get(val).remove(idx1);
            list.remove(idx1);
            if (map.get(val).size() == 0) {
                map.remove(val);
            }
            return true;
        } else {
            //get the set of the val from map and remove the idx1
            map.get(val).remove(idx1);
            
            //get the set of idx2 element of the list from the map and add idx1
            map.get(list.get(idx2)).add(idx1);

            //get the idx2 element of the list from the map and remove idx2
            map.get(list.get(idx2)).remove(idx2);

            //swap the idx2 and idx1 element in the list
            int temp = list.get(idx1);
            list.set(idx1, list.get(idx2));
            list.set(idx2, temp);

            //remove the last element of the list in O(1) time complexity
            list.remove(idx2);

            if (map.get(val).size() == 0) {
                map.remove(val);
            }

            return true;
        }

    }

    public int getRandom() {

        return list.get(r.nextInt(list.size()));

    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */