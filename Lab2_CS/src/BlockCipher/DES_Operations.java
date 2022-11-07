package BlockCipher;

import static BlockCipher.Constants.*;
import static BlockCipher.Conversions.hextoBin;

public class DES_Operations {

    // function to perform permutations according to permutation table
    public static String permutation(int[] permutationtable, String permbytes)
    {
        String resultbytes = "";
        permbytes = hextoBin(permbytes);
        for (int i = 0; i < permutationtable.length; i++)
            resultbytes += permbytes.charAt(permutationtable[i] - 1);
        resultbytes = Conversions.binToHex(resultbytes);
        return resultbytes;
    }
//Step 2: Generating 16 keys
//left circular shift bits for key: Step 2
public static String CircularShift(String input, int numBits)
{
    int n = input.length() * 4;
    int perm[] = new int[n];
    for (int i = 0; i < n - 1; i++)
        perm[i] = (i + 2);
    perm[n - 1] = 1;
    while (numBits-- > 0)
        input = permutation(perm, input);
    return input;
}
    // preparing 16 keys for 16 rounds : Step 2
    public static String[] getKeys(String key)
    {
        String keys[] = new String[16];
        // first key permutation using PC1
        key = permutation(PC1, key);
        //after permutation concatenate keys
        for (int i = 0; i < 16; i++) {
            key = CircularShift(key.substring(0, 7), shiftBits[i]) + CircularShift(key.substring(7, 14), shiftBits[i]);
            // perform permutation again using PC-2
            keys[i] = permutation(PC2, key);
        }
        return keys;
    }
    //perform xor on 2 hexadecimal strings
   public static String xor(String a, String b)
    {
        // hexadecimal to decimal(base 10)
        long t_a = Long.parseUnsignedLong(a, 16);
        // hexadecimal to decimal(base 10)
        long t_b = Long.parseUnsignedLong(b, 16);
        // xor
        t_a = t_a ^ t_b;
        // decimal to hexadecimal
        a = Long.toHexString(t_a);
        // prepend 0's to maintain length
        while (a.length() < b.length())
            a = "0" + a;
        return a;
    }

    // s-box lookup : Step 3
   public static String sBox(String inputkey)
    {
        String outputkey = "";
        inputkey = hextoBin(inputkey);
        for (int i = 0; i < 48; i += 6) {
            String temp = inputkey.substring(i, i + 6);
            int num = i / 6;
            int row = Integer.parseInt(
                    temp.charAt(0) + "" + temp.charAt(5),
                    2);
            int col = Integer.parseInt(
                    temp.substring(1, 5), 2);
            outputkey += Integer.toHexString(
                    sbox[num][row][col]);
        }
        return outputkey;
    }
   public static String round(String input, String key, int num)
    {
        // split subkey
        String left = input.substring(0, 8);
        String temp = input.substring(8, 16);
        String right = temp;
        // Expansion permutation
        temp = permutation(EP, temp);
        // xor temp and round key
        temp = xor(temp, key);
        // lookup in s-box table
        temp = sBox(temp);
        // Straight D-box
        temp = permutation(P, temp);
        // xor
        left = xor(left, temp);
        System.out.println("Round " + (num + 1) + " "
                + right.toUpperCase() + " "
                + left.toUpperCase() + " "
                + key.toUpperCase());

        // swapper
        return right + left;
    }

}
