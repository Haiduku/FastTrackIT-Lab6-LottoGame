package fasttrackit.lottogame;

import java.util.*;

public class LottoV1 {

    private static final int MAXVALUE = 49;
    private static final int MAX_EXTRACTION_NUMBERS = 6;

    public static void main(String[] args) {

        //  read users' numbers and store them
        //  prepare the lotto machine and init it
        //  generate the lotto numbers
        // compare the user numbers with the lotto numbers and tell if won something (4,5,6)

        // all in one or in different classes
        // all in one and a single method or in different methods


        // here is the simple and the most dummy idea

        // comment
        // ...

        // 1 read

        int howManyWons = 0;
        int[] wonNumbers = new int[MAX_EXTRACTION_NUMBERS];
        int tentatives = 0;
        long starttime = System.currentTimeMillis();

        // 2 prepare the lotto machine and init it
        Random lottoMachine = new Random();
        lottoMachine.setSeed(System.currentTimeMillis());
        // 2 generate the numbers
        int[] sixGeneratedNumbers;
        do {
            sixGeneratedNumbers = extragereLoto6din49(lottoMachine);
        } while (
                sixGeneratedNumbers[0] != sixGeneratedNumbers[1] && sixGeneratedNumbers[0] != sixGeneratedNumbers[2] &&
        sixGeneratedNumbers[0] != sixGeneratedNumbers[3] && sixGeneratedNumbers[0] != sixGeneratedNumbers[4] &&
        sixGeneratedNumbers[0] != sixGeneratedNumbers[5] && sixGeneratedNumbers[1] != sixGeneratedNumbers[2] &&
        sixGeneratedNumbers[1] != sixGeneratedNumbers[3] && sixGeneratedNumbers[1] != sixGeneratedNumbers[4] &&
        sixGeneratedNumbers[1] != sixGeneratedNumbers[5] && sixGeneratedNumbers[2] != sixGeneratedNumbers[3] &&
        sixGeneratedNumbers[2] != sixGeneratedNumbers[4] && sixGeneratedNumbers[2] != sixGeneratedNumbers[5] &&
        sixGeneratedNumbers[3] != sixGeneratedNumbers[4] && sixGeneratedNumbers[3] != sixGeneratedNumbers[5] &&
        sixGeneratedNumbers[4] != sixGeneratedNumbers[5]);
        tentatives++;

//        do {
//            int[] myNumbers = new int[MAX_EXTRACTION_NUMBERS];
//            Random myNumbersMachine = new Random();
//
//            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++) {
//                int nr = myNumbersMachine.nextInt(MAXVALUE) + 1;
//                //check if nr is not already in the array, if it is generate a new one
//                for (int j = 0; j < i; j++)
//                    if (myNumbers[j] == nr) nr = myNumbersMachine.nextInt(MAXVALUE) + 1;
//                myNumbers[i] = nr;
//            }
//            // here are my numbers
//            System.out.println("here are my numbers:");
//            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
//                System.out.print(myNumbers[i] + " |");
//
//            System.out.println("");
//
//
//
//
//
//            //compare and tell if won
//
//
//
//            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
//                for (int j = 0; j < MAX_EXTRACTION_NUMBERS; j++) {
//
//                    if (myNumbers[i] == sixGeneratedNumbers[j]) {
//                        howManyWons++;
//                        wonNumbers[howManyWons - 1] = sixGeneratedNumbers[j];
//                    }
//                }
//
//            switch (howManyWons) {
//
//                case 4: // that is 4 numbers
//                    System.out.println("congrat, you won at 3rd category");
//                    break;
//                case 5: // that is 5 numbers
//                    System.out.println("congrat, you won at 2rd category");
//                    break;
//                case 6: // that is 6 numbers
//                    System.out.println("WOW, you won at 1st category");
//                    break;
//                default:
//                    System.out.println("you are a looser, but keep trying, you guessed " + howManyWons + " numbers");
//                    break;
//            }
//        tentatives++;
//        }while(howManyWons < 5);

        long endTime = System.currentTimeMillis();
        long time = (endTime - starttime) / 1000;

//        if(howManyWons > 5) {
        System.out.println("here is what you won: ");
        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
            if (wonNumbers[i] != 0)
                System.out.print(wonNumbers[i] + " |");
        System.out.println("Numar de incercari: " + tentatives);
        System.out.println("Timp necesar: " + time);
//        }

    }

    private static int[] extragereLoto6din49(Random lottoMachine) {
        int[] sixGeneratedNumbers = new int[MAX_EXTRACTION_NUMBERS];
        int nr;
        boolean sirBun;
        do {
            sirBun = true;
            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++) {
                nr = lottoMachine.nextInt(MAXVALUE) + 1;
                sixGeneratedNumbers[i] = nr;
            }

            Arrays.sort(sixGeneratedNumbers);
            for (int i = 0; i < sixGeneratedNumbers.length - 1; i++) {
                if (sixGeneratedNumbers[i] == sixGeneratedNumbers[i + 1]) {
                    sirBun = false;
                }

            }
        } while (!sirBun);
        // 3 print the extraction
        System.out.println("here is the extraction today:");
        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
            System.out.print(sixGeneratedNumbers[i] + " |");

        System.out.println("");
        return sixGeneratedNumbers;
    }
}
