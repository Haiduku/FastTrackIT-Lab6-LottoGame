package fasttrackit.lottogame;

import java.util.*;

public class LottoV1 {

    private static final int MAXVALUE = 40;
    private static final int MAX_EXTRACTION_NUMBERS = 5;

    public static void main(String[] args) {


        int howManyWons = 0;
        int[] wonNumbers = new int[MAX_EXTRACTION_NUMBERS];
        int tentatives = 0;
        long starttime = System.currentTimeMillis();

        //  prepare the lotto machine and init it
        Random lottoMachine = new Random();
        lottoMachine.setSeed(System.currentTimeMillis());
        //  generate the numbers
        int[] generatedNumbers = extractUniqueNumbers(lottoMachine);

        //generate my numbers
        do {
            howManyWons = 0;  //reinitialize howManyWons
            Random myNumbersMachine = new Random();
            int[] myNumbers = extractUniqueNumbers(myNumbersMachine);


            // here are my numbers
            System.out.println("here are my numbers:");
            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
                System.out.print(myNumbers[i] + " |");
            System.out.println("");

            //compare and tell if won
            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
                for (int j = 0; j < MAX_EXTRACTION_NUMBERS; j++) {

                    if (myNumbers[i] == generatedNumbers[j]) {
                        howManyWons++;
                        wonNumbers[howManyWons - 1] = generatedNumbers[j];
                    }
                }

//            switch (howManyWons) {
//
//                case 4: // that is 4 numbers
//                    System.out.println("congrat, you won at 3rd category");
//                    break;
//                case 5: // that is 5 numbers
//                    System.out.println("congrats, you won at 2rd category");
//                    break;
//                case 6: // that is 6 numbers
//                    System.out.println("WOW, you won at 1st category");
//                    break;
//                default:
//                    System.out.println("you are a looser, but keep trying, you guessed " + howManyWons + " numbers");
//                    break;
//            }
            tentatives++;
        } while (howManyWons != MAX_EXTRACTION_NUMBERS);

        long endTime = System.currentTimeMillis();
        long time = (endTime - starttime) / 1000;

        // 3 print the extraction
        System.out.println("here is the extraction today:");
        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
            System.out.print(generatedNumbers[i] + " |");
        System.out.println("");


        System.out.println("here is what you won: ");
        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
            if (wonNumbers[i] != 0)
                System.out.print(wonNumbers[i] + " |");
        System.out.println("\nNumar de incercari: " + tentatives);
        System.out.println("Timp necesar: " + time);
    }

    private static int[] extractUniqueNumbers(Random lottoMachine) {
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


        return sixGeneratedNumbers;
    }
}
