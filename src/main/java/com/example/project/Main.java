package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main{
    
    
    /** Inserts toInsert after each String in stringList
    *  that contains the letter "i"
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0, toInsert.length() > 0
    *
    *  @param stringList  original arraylist of Strings
    *  @param str String to insert
    */
    public static ArrayList<String> insertAfterI(ArrayList<String> stringList, String str) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).contains("i")) {
                stringList.add(i + 1, str);
            }
        }
        return stringList;
    }



    /** Removes all Strings from stringList that have a length of 3
   *
   *  DOES mutate (modify) elements of stringList.
   *  PRECONDITION: stringList.size() > 0
   *
   *  @param stringList  original arraylist of Strings
   */
    public static ArrayList<String> removeThree(ArrayList<String> stringList){
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).length() == 3) {
                stringList.remove(i);
                i--;
            }
        }
        return stringList;
    }



    /** Returns an ArrayList with all elements of arr reversed
   *
   *  Does NOT mutate (modify) elements in intList.
   *  PRECONDITION: intList.size() > 0
   *
   *  @param intList  original array of integers
   */
    public static ArrayList<Integer> reverseArray(int[] intList) {
        ArrayList<Integer> reverse = new ArrayList<Integer>();
        for (int i = intList.length - 1; i >= 0; i--) {
            reverse.add(intList[i]);
        }
        return reverse;
    }



    /** Appends an uppercase version of each string to the end of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0,
     *                 all words in wordList are initially lowercase
     *
     *  @param wordList  arraylist of Strings
     */
    public static ArrayList<String> duplicateUpperEnd(ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            wordList.add(wordList.get(i).toUpperCase());
        }
        return wordList;
    }



    /** Returns an arraylist of Strings that represents the input sentence parsed
   *  into separate words, using a single space (" ") as the delimiter
   *
   *  For example, if sentence = "This is my sentence!"
   *  this method return the arraylist: [This, is, my, sentence!]
   *
   *  PRECONDITION: sentence does not end with a space and each word is
   *                separated by exactly one space
   *
   *  @param sentence  the input String
   *  @return  new arraylist of Strings containing the words of sentence
   */

    public static ArrayList<String> parseSentence(String sentence) {
        ArrayList<String> parsedSentence = new ArrayList<String>();
        for (int i = 1; i < sentence.length(); i++) {
            if (sentence.contains(" ")) {
                if (sentence.substring(0, i).contains(" ")) {
                    parsedSentence.add(sentence.substring(0, i - 1));
                    sentence = sentence.substring(i);
                    i = 1;
                }
            } else {
                parsedSentence.add(sentence);
                return parsedSentence;
            }
        }
        return parsedSentence;
    }



    /** Moves all words in wordList that begin with "b" to the front of
   *  wordList; all "b" words that are moved should appear in the same order
   *  in the modified arrayList as they did before being moved
   *
   *  For example, this method will take a wordList:
   *  ["apple", "banana", "cherry", "donut", "Bagel", "danish", "berry", "baguette", "soda"]
   *  and modify it to
   *  ["banana", "Bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
   *
   *  DOES mutate (modify) elements in wordList
   *  PRECONDITIONS: - wordList.size() > 0
   *                 - all strings in wordList have length >= 1
   *
   *  @param wordList  arraylist of words
   */
    public static ArrayList<String> moveBWords(ArrayList<String> wordList){
        ArrayList<String> bWords = new ArrayList<String>();
        int count = 0;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).contains("b") || wordList.get(i).contains("B")) {
                bWords.add(wordList.get(i));
                wordList.remove(i);
                wordList.add(count, bWords.get(bWords.size() - 1));
                count++;
            }
        }
        return wordList;
    }



    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> intList) {
        if (intList.size() <= 1) {
            return intList;
        }
        int i = 1;
        while (i < intList.size()) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (intList.get(i).equals(intList.get(j))) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                intList.remove(i);
            } else {
                i++;
            }
        }
        return intList;
    }

    // Given an array of ints, 
    // return true if the array is length 1 or more, 
    // and the first element and the last element are equal.
    // sameFirstLast([1, 2, 3]) → false
    // sameFirstLast([1, 2, 3, 1]) → true
    // sameFirstLast([1, 2, 1]) → true
    //sameFirstLast([]) -> false
    public static boolean sameFirstLast(ArrayList<Integer> list){
        return list.size() >= 1 && list.get(0) == list.get(list.size() - 1);
    }



    // Given an array of ints, swap the first and last elements in the array. 
    // Return the modified array. The array length will be at least 1.
    // swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    // swapEnds([1, 2, 3]) → [3, 2, 1]
    // swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    // swapEnds([]->[])
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list){      
        if (list.size() == 0) {
            return list;
        }  
        int temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);
        return list;
    }



    // Return an array that contains the exact same numbers as the given array, 
    // but rearranged so that all the zeros are grouped at the start of the array. 
    // The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. 
    // You may modify and return the given array or make a new array.
    // zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    // zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    // zeroFront([1, 0]) → [0, 1]
    public static ArrayList<Integer> zeroFront(ArrayList<Integer> list){
        ArrayList<Integer> zeroes = new ArrayList<Integer>();
        ArrayList<Integer> nonzeroes = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                zeroes.add(list.get(i));
            } else {
                nonzeroes.add(list.get(i));
            }
        }
        ArrayList<Integer> fin = zeroes;
        for (int i = 0; i < nonzeroes.size(); i++) {
            fin.add(nonzeroes.get(i));
        }
        return fin;
    }



    // We'll say that an element in an array is "alone" if there are values before and after it, 
    // and those values are different from it. If the value is at the end compare to the left and if its at the beginning compare to the right
    //Return a version of the given array where every instance 
    // of the given value which is alone is replaced by whichever value to its left or right is larger.
    // notAlone([1, 2, 3], 2) → [1, 3, 3]
    // notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 5]
    // notAlone([3, 4], 3) → [4,4]
    public static ArrayList<Integer> notAlone(ArrayList<Integer> list, int val){
        int greater;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) == val && list.get(i) != list.get(i - 1) && list.get(i) != list.get(i + 1)) {
                if (list.get(i - 1) > list.get(i + 1)) {
                    greater = list.get(i - 1);
                } else {
                    greater = list.get(i + 1);
                }
                list.set(i, greater);
            }
        }
            if (list.get(0) != list.get(1) && list.get(0) == val) {
                if (list.get(1) > list.get(list.size() - 1)) {
                    list.set(0, list.get(1));
                } else {
                    list.set(0, list.get(list.size() - 1));
                }
            }
            if (list.get(list.size() - 1) != list.get(list.size() - 2) && list.get(list.size() - 1) == val) {
                if (list.get(list.size() - 2) > list.get(0)) {
                    list.set(list.size() - 1, list.get(list.size() - 2));
                } else {
                    list.set(list.size() - 1, list.get(0));
                }
            }
            return list; 
    }



    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. 
    // You may modify and return the given array;
    // shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    // shiftLeft([1, 2]) → [2, 1]
    // shiftLeft([1]) → [1]

    public static ArrayList<Integer> shiftLeft(ArrayList<Integer> list){
        int temp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            list.set(i - 1, list.get(i));
        }
        list.set(list.size() - 1, temp);
        return list;
    }
    


    // Return an array that contains exactly the same numbers as the given array, 
    // but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
    // but every other number may move. The array contains the same number of 3's and 4's, 
    // every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
    // fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    // fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    // fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    public static ArrayList<Integer> fix34(ArrayList<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) {
                while (count < list.size() && (list.get(count) != 4 || count > 0 && list.get(count - 1) == 3)) {
                    count++;
                }
                if (count < list.size()) {
                    int temp = list.get(i + 1);
                    list.set(i + 1, 4);
                    list.set(count, temp);
                }
            }
        }
        return list;
    }



    /** Returns an arraylist of Integers that contain all mode(s) of the array numList.
   *  The mode of a list is the value that appears the greatest number of times.
   *  A list can have one mode, multiple mode, or no mode.
   *
   *  If all elements in the list appear the exact same number of times, there is no
   *  mode and this method should return an empty arraylist.
   *
   *  For example, if numList is: [1, 2, 6, 2, 3, 4, 6, 5, 5, 6, 7],
   *  then numList contains one mode: 6
   *  and this method returns an arrayList containing 6
   *
   *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6],
   *  then numList contains two modes: 2, 5
   *  and this method returns an arraylist containing 2 and 5 (in any order)
   *
   *  If numList is: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6],
   *  then numList contains no mode because all values appear the same number of times
   *  and this method returns an empty arrayList: []
   *
   *  Does NOT mutate (modify) elements in numList
   *  PRECONDITIONS: numList.length > 0
   *
   *  @param numList  numList of ints
   */
  public static ArrayList<Integer> modes(int[] numList) {
    ArrayList<Integer> modes = new ArrayList<>();
    if (numList.length == 0) {
        return modes;
    }
    int max = numList[0];
    for (int i = 1; i < numList.length; i++) {
        if (numList[i] > max) {
            max = numList[i];
        }
    }
    int[] numCount = new int[max + 1];
    int maxCount = 0;
    for (int i = 0; i < numList.length; i++) {
        numCount[numList[i]]++;
        if (numCount[numList[i]] > maxCount) {
            maxCount = numCount[numList[i]];
        }
    }
    boolean same = true;
    int firstNonZeroCount = 0;
    for (int i = 0; i <= max; i++) {
        if (numCount[i] != 0) {
            if (firstNonZeroCount == 0) {
                firstNonZeroCount = numCount[i];
            } else if (numCount[i] != firstNonZeroCount) {
                same = false;
                break;
            }
        }
    }
    if (maxCount == 1 || same) {
        return modes;
    }
    boolean[] added = new boolean[max + 1];
    for (int i = 0; i < numList.length; i++) {
        if (numCount[numList[i]] == maxCount && !added[numList[i]]) {
            modes.add(numList[i]);
            added[numList[i]] = true;
        }
    }
    return modes;
}
}
