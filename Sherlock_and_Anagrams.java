import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


public static final int ALPHABET_CNT = 26;

   static boolean isAnagrams(String str1, String str2)
    {
        HashMap<Character, Integer> hmap1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmap2 = new HashMap<Character, Integer>();
        char arr1[] = str1.toCharArray();
        char arr2[]    = str2.toCharArray();
        //map first  string
        for(int i = 0; i < arr1.length; i++)
        {
            if (hmap1.get(arr1[i]) == null)
            {
                hmap1.put(arr1[i], 1);
            }
            else
            {
                Integer c = (int)hmap1.get(arr1[i]);
                hmap1.put(arr1[i],++c);
            }
        }
        /*for(int i = 0; i <arr2.length; i++)
            System.out.println("i:"+ i + "arr:" + arr2[i]);
        System.out.println("hmap2[1]"+hmap2.get(arr2[0]));
        */
        for (int i = 0; i < arr2.length; i++)
        {
            if(hmap2.get(arr2[i]) == null)
            {
                hmap2.put(arr2[i], 1);
            }
            else
            {
                Integer c = (int)hmap2.get(arr2[i]);
                hmap2.put(arr2[i], ++c);
            }
        }
        /*System.out.println("arr1:" + hmap1);
        System.out.println("arr2:" + hmap2);*/
        if (hmap1.equals(hmap2))
            return true;
        else
            return false;
    }
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

 int cnt = 0;
        for (int i = 1, n = s.length(); i < n; i++) {
            List<String> subsetList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i + j <= n) {
                    subsetList.add(s.substring(j, i + j));
                }
            }

            for (int k = 0, size = subsetList.size(); k < size; k++) {
                for (int l = k + 1; l < size; l++) {
                    if (isAnagrams(subsetList.get(k), subsetList.get(l))) {
                        cnt++;
                    }
                }
            }
        }


        return cnt;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
