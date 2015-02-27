package fasttrackit.lottogame;

import java.util.*;

public class LottoV2 {

    private static final int MAXVALUE = 49;
    private static final int MAX_EXTRACTION_NUMBERS = 6;
    private static final int WINNINGS = 8645659;
    private static final int WINNINGS_2ND_CAT = 19113;
    private static final int WINNINGS_3RD_CAT = 257;
    private static final int TICKET_PRICE = 5;

    public static void main(String[] args) {

//
//        int howManyWons = 0;
//        Set<Integer> wonNumbers = new HashSet<Integer>();
//        int tentatives = 0;
//        double starttime = System.currentTimeMillis();
//        int investedMoney = 0;
//        int secondCategory = 0;
//        int thirdCategory = 0;
//
//        //  prepare the lotto machine and init it
//        Random lottoMachine = new Random();
//        lottoMachine.setSeed(System.currentTimeMillis());
//        //  generate the numbers
//        Set<Integer> sixGeneratedNumbers = extractSixUniqueNumbers(lottoMachine);
//
//        //generate my numbers
//        do {
//            howManyWons = 0;  //reinitialize howManyWons
//            Random myNumbersMachine = new Random();
//           Set<Integer> myNumbers = extractSixUniqueNumbers(myNumbersMachine);
//
//
//            // here are my numbers
//            System.out.println("here are my numbers:");
//            // create an iterator
//            Iterator iterator = myNumbers.iterator();
//
//            // check values
//            while (iterator.hasNext()){
//                System.out.print(iterator.next() + "| ");
//            }
//            System.out.println("");
//
//            //compare and tell if won
//
//            iterator = myNumbers.iterator();
//
//            // check values
//            while (iterator.hasNext()){
//
//            }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
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
//                    thirdCategory++;
//                    break;
//                case 5: // that is 5 numbers
//                    secondCategory++;
//                    break;
//
//
//            }
//            tentatives++;
//        } while (howManyWons != 6);
//
//        double endTime = System.currentTimeMillis();
//        double time = (endTime - starttime) / 1000;
//        investedMoney = TICKET_PRICE * tentatives;
//
//        // 3 print the extraction
//        System.out.println("here is the extraction today:");
//        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
//            System.out.print(sixGeneratedNumbers[i] + " |");
//        System.out.println("");
//
//
//        System.out.println("here is what you won:" +WINNINGS);
//        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
//            if (wonNumbers[i] != 0)
//                System.out.print(wonNumbers[i] + " |");
//        System.out.println("\nNumber of trials: " + tentatives);
//        System.out.println("Times won at the 2nd Category: " +secondCategory);
//        System.out.println("Times won at the 3rd Category: " +thirdCategory);
//        System.out.println("Elapsed time: " + time+ " s");
//        System.out.println("Invested money: " + investedMoney + " RON");
//        System.out.println("Overall gain:" + ((WINNINGS + WINNINGS_2ND_CAT * secondCategory + WINNINGS_3RD_CAT *thirdCategory )- investedMoney)+ " RON");
    }

    private static Set<Integer> extractSixUniqueNumbers(Random lottoMachine) {
        Set<Integer> sixGeneratedNumbers =  new HashSet<Integer> ();
        int nr;

           for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++) {
               nr = lottoMachine.nextInt(MAXVALUE) + 1;
               while (!sixGeneratedNumbers.add(nr)) {
                   nr = lottoMachine.nextInt(MAXVALUE) + 1;
                   sixGeneratedNumbers.add(nr);
               }
           }



        return sixGeneratedNumbers;
    }
}
