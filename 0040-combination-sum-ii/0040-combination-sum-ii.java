class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int[] candidates, int target, int start,
                          List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            list.add(candidates[i]);

            backtrack(candidates, target - candidates[i], i + 1, list, result);

            list.remove(list.size() - 1);
        }
    }
}