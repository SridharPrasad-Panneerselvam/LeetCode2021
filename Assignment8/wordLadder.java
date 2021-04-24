//3). https://leetcode.com/problems/word-ladder/

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> w = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 1; 
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                char[] current = q.poll().toCharArray();
                for(int j=0;j<current.length;j++) {
                    char temp = current[j];
                    for(char c='a';c<='z';c++) {
                        current[j] = c;
                        String next = new String(current);
                        if(w.contains(next)) {
                            if(next.equals(endWord))
                                return count+1;
                            w.remove(next);
                            q.add(next);
                        }
                    }
                    current[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }

    public static void main(String args[]) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] w = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(w));
        System.out.println("Word Ladder is " + ladderLength(beginWord, endWord, wordList));
    }
}