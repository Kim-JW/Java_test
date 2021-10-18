class Solution {
    public int solution(int[] numbers) {
        var map = new int[10];

        for (int v : numbers) map[v] = 1;

        int sum = 0;
        for (int v = 0; v < map.length; v++) sum += (map[v] == 0) ? v : 0;

        return sum;
    }
}