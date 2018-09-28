package com.wzj.destination.bytedance.a;



import java.util.HashSet;
import java.util.Scanner;

public class Main {
    HashSet<String> res = new HashSet<>();
    int maxLength = 0;
    TrieNode trie = new TrieNode();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt(), k = in.nextInt();
        in.nextLine();
        String[] words = new String[k];
        for(int i = 0; i < k; i++){
            words[i] = in.next();
        }
        char[][] board = new char[n][m];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] = in.next().charAt(0);
            }
        }

        Main main = new Main();
        HashSet<String> res = main.findWords(board, words);
        for(String str : words){
            if(res.contains(str)) System.out.println(str);
        }

    }
    public HashSet<String> findWords(char[][] board, String[] words) {
        if(words.length == 0) return res;
        for(String s : words){
            trie.add(s);
            maxLength = Math.max(s.length(), maxLength);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(trie.words[board[i][j] - 'a'] != null)
                    dfs(board, trie.words[board[i][j] - 'a'], i, j, 0);
            }
        }
        return res;
    }
    public void dfs(char[][] board, TrieNode trie, int i, int j, int count){
        if(trie == null || count == maxLength) return;

        if(trie.str != null){
            res.add(trie.str);
            trie.str = null;
        }
        char tmp = board[i][j];
        board[i][j] = '#';

        if(j > 0 && board[i][j - 1] != '#')dfs(board, trie.words[board[i][j - 1] - 'a'], i, j - 1, count + 1);
        if(j < board[0].length - 1 && board[i][j + 1] != '#') dfs(board, trie.words[board[i][j + 1] - 'a'], i, j + 1, count + 1);
        if(i > 0 && board[i - 1][j] != '#') dfs(board, trie.words[board[i - 1][j] - 'a'], i - 1, j, count + 1);
        if(i < board.length - 1 && board[i + 1][j] != '#') dfs(board, trie.words[board[i + 1][j] - 'a'], i + 1, j, count + 1);

        board[i][j] = tmp;


    }

    private static class TrieNode{
        TrieNode[] words = new TrieNode[26];
        String str;
        public void add(String word){
            TrieNode[] tmp = words;
            for(int i = 0; i < word.length(); i++){
                char a = word.charAt(i);
                if(tmp[a - 'a'] == null){
                    tmp[a - 'a'] = new TrieNode();
                }
                if(i == word.length() - 1){
                    tmp[a - 'a'].str = word;
                }
                tmp = tmp[a - 'a'].words;

            }
        }
    }
}
