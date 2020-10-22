import java.util.Scanner;

public class GregorianCalendar {
    public static void main(String[] args) {
        int year = whichYear();
        int shiftCounter;
        boolean isLeapYear = leapYearChecker(year);
        System.out.println(year + "年のカレンダー");
        for (int i = 1; i < 13; i++) {
            shiftCounter = howManyDaysToShift(year,isLeapYear, i);
            printMonth(i);
            printWeek();
            printDays(shiftCounter,isLeapYear, i);
        }
    }

    public static int whichYear() {
        Scanner sc = new Scanner(System.in);
        System.out.print("何年のカレンダーを見ますか？: ");
        int yearGiven = sc.nextInt();
        return yearGiven;
    }
    public static void printMonth(int month) {
        System.out.println(month + "月");
    }
    public static void printWeek() {
        System.out.println(" 日  月 火 水 木  金 土");
    }
    public static int howManyDaysToShift(int year,boolean isLeapYear, int i) {
        int shiftCounterSeed;;
        int[] shiftCnt4Month = {3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2};
        int previousYear = year - 1;
        // 1月1日は何曜日か。 0は日曜日
        shiftCounterSeed = (previousYear + ((int)previousYear / 4) -((int)previousYear / 100) +
                        ((int)previousYear / 400) + 1);
        while (i > 1) {
            if(i == 3 && isLeapYear) {
                shiftCounterSeed++;
            }
            shiftCounterSeed += shiftCnt4Month[i - 2];
            i = i-1;
        }
        int shiftCounter = shiftCounterSeed % 7;
        return shiftCounter;
    }
    public static boolean leapYearChecker(int year) {
        //4で割り切れ、100で割り切れず、400で割り切れれば閏年で真を返す
        return year % 4 == 0 || year % 100 != 0 || year % 400 == 0;
    }
    public static void printDays(int shiftCounter, boolean isLeapyear, int i) {
        int daysOfMonth;
        if (i == 4 || i == 6 || i == 9 || i == 11) {
            daysOfMonth = 30;
        } else if (i == 2 && isLeapyear == false) {
            daysOfMonth = 28;
        } else if (i == 2) {
            daysOfMonth = 29;
        } else {
            daysOfMonth = 31;
        }
        for (int j = shiftCounter; j > 0; j--) {
            System.out.print("   ");
        }
        for (int days = 1; days < daysOfMonth + 1; days++) {
            if (days < 10) {
                System.out.print("  " + days);
            } else {
                System.out.print(" " + days);
            }
            shiftCounter++;
            if (shiftCounter == 7) {
                System.out.println();
                shiftCounter = 0;
            }
        }
        System.out.println("");
    }
}
