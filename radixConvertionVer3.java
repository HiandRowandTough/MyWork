import java.math.BigInteger;
import java.util.Scanner;

public class radixConvertionVer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radixBase = 0;
        System.out.println("基数変換したい数を入力してください（10進数）：");
        BigInteger inputNum = new BigInteger(sc.next());
        System.out.println("何進数表記にしますか？（1進数から36進数まで）：");
        radixBase = sc.nextInt();
        while (radixBase < 1 ||  37 < radixBase) {
            System.out.println("１～３６進数までしか対応しておりません。もう一度入力：");
            radixBase = sc.nextInt();
        }
        if (radixBase == 1) {
            printNumInUnary(inputNum);
        } else {
            printNumInGivenRadix(inputNum, radixBase);
        }
    }
    public static void printNumInUnary(BigInteger inputNum) {
        for (int i = 0; inputNum.compareTo(BigInteger.valueOf(i)) > 0; i++) {
            System.out.print(1);
        }
    }
    public static void printNumInGivenRadix(BigInteger inputNum, int radixBase) {
        int i = 0;
        String numInGivenRadix = "";
        while (inputNum.compareTo(BigInteger.valueOf(radixBase).pow(i)) >= 0) {
            i++;
        }
        BigInteger[] numRemained = new BigInteger[i + 1];
        numRemained[i] = inputNum;
        for (; i > 0; i--) {
            int j = 1;
            for (; j < radixBase; j++) {
                if (BigInteger.valueOf(radixBase).pow(i - 1).multiply(BigInteger.valueOf(j)).compareTo(numRemained[i]) > 0) {
                    break;
                }
            }
            j--;
            if (j > 9) {
                String numInAlpha = parseAlphabet(j);
                numInGivenRadix += numInAlpha;
            } else {
                numInGivenRadix += j;
            }
            numRemained[i - 1] = numRemained[i].subtract(BigInteger.valueOf(radixBase).pow(i - 1).multiply(BigInteger.valueOf(j)));
        }
        System.out.println(numInGivenRadix);
    }
    public static String parseAlphabet(int j) {
        String numInAlpha ="";
        if (j == 10) {
            numInAlpha = "A";
        } else if (j == 11) {
            numInAlpha = "B";
        } else if (j == 12) {
            numInAlpha = "C";
        }else if (j == 13) {
            numInAlpha = "D";
        }else if (j == 14) {
            numInAlpha = "E";
        }else if (j == 15) {
            numInAlpha = "F";
        }else if (j == 16) {
            numInAlpha = "G";
        }else if (j == 17) {
            numInAlpha = "H";
        }else if (j == 18) {
            numInAlpha = "I";
        }else if (j == 19) {
            numInAlpha = "J";
        }else if (j == 20) {
            numInAlpha = "K";
        }else if (j == 21) {
            numInAlpha = "L";
        }else if (j == 22) {
            numInAlpha = "M";
        }else if (j == 23) {
            numInAlpha = "N";
        }else if (j == 24) {
            numInAlpha = "O";
        }else if (j == 25) {
            numInAlpha = "P";
        }else if (j == 26) {
            numInAlpha = "Q";
        }else if (j == 27) {
            numInAlpha = "R";
        }else if (j == 28) {
            numInAlpha = "S";
        }else if (j == 29) {
            numInAlpha = "T";
        }else if (j == 30) {
            numInAlpha = "U";
        }else if (j == 31) {
            numInAlpha = "V";
        }else if (j == 32) {
            numInAlpha = "W";
        }else if (j == 33) {
            numInAlpha = "X";
        }else if (j == 34) {
            numInAlpha = "Y";
        }else if (j == 35) {
            numInAlpha = "Z";
        }
        return numInAlpha;
    }
}
