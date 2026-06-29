class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n=word.length();
        int count=0;
        for (int i=0;i<patterns.length;i++){
        if(word.contains(patterns[i]))count++;
        }
        return count;
    }
}