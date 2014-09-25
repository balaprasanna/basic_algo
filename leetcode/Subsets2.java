public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        if (null == num || num.length == 0)
            return subsets;
        Arrays.sort(num);
        int j, lastLength = 0;
        for (int i = 0; i < num.length; i++) {
            if (i != 0 && num[i] == num[i - 1])
                j = lastLength;
            else
                j = 0;
            lastLength = subsets.size();
            for (; j < lastLength; j++) {
                ArrayList<Integer> temp = (ArrayList<Integer>) subsets.get(j);
                temp = (ArrayList<Integer>) temp.clone();
                temp.add(num[i]);
                subsets.add(temp);
            }
        }
        return subsets;
    }
}
