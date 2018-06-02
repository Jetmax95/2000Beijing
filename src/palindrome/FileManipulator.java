package palindrome;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class FileManipulator {

    public static void main(String args[]) {
        try {
            File file = new File("/home/ioannis/IdeaProjects/2000Beijing/2000Beijing/src/palindrome/PALIN.IN");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String length = br.readLine();
            int len = Integer.parseInt(length);
            String content = br.readLine();

            fr.close();

            int result = getResult(content.toCharArray(), 0, content.length()-1);
            System.out.println(result);

            BufferedWriter writer = new BufferedWriter(new FileWriter("PALIN.OUT"));
            writer.write("" + result);
            writer.close();

        } catch (IOException e) {
            System.err.println("IOException occurred");
        }
    }


    public static int getResult(char str[], int l, int h) {
        // Base Cases

        System.out.println("Started a new getResult()");
        for(int i = 0; i <= h; i++){
            System.out.print(" "+i+" ");
        }
        System.out.println("");
        for(int i = 0; i <= h; i++){
            System.out.print("[" + str[i] + "]");
        }
        System.out.println("");

        if (l > h) return Integer.MAX_VALUE;
        System.out.println(" l > h check " + " l = " + l + " h = " + h);
        if (l == h) return 0;
        System.out.println(" l == h check " + " l = " + l + " h = " + h);
        if (l == h - 1) return (str[l] == str[h]) ? 0 : 1;
        System.out.println(" l > h - 1 check " + " l = " + l + " h - 1 = " + (h - 1));

        System.out.println("================== END OF BASE CASES ===================");
        // Check if the first and last characters
        // are same. On the basis of the  comparison
        // result, decide which subrpoblem(s) to call

        System.out.println("================= START OF INDUCTIVE STEP =================");
        if(str[l] == str[h]){
            System.out.println("Entered the case where str[l] == str[h]");
            System.out.println("str[l] = "  +str[l] + " str[h] = " + str[h]);
            return getResult(str, l + 1, h - 1);
        }else{
            return (Integer.min(getResult(str, l, h - 1),
                    getResult(str, l + 1, h)) + 1);
        }
    }


}
