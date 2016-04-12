package main.utility;

/**
 * A helper class that can be useful for timing specific aspects of an algorithm.
 * Idea:
 *   long start = System.nanoTime();
 *   long end = System.nanoTime();
 *   TimeCounter.time1 += end - start;
 *   TimeCounter.iterations++;
 */
public class TimeCounter {
    public static long timeA;
    public static long timeB;
    public static long timeC;
    public static long timeD;
    public static long timeE;

    public static int counterA;
    public static int counterB;
    public static int counterC;
    public static int counterD;
    public static int counterE;
    
    public static int iterations;
    
    private static boolean isFrozen;
    public static long timeA_freeze;
    public static long timeB_freeze;
    public static long timeC_freeze;
    public static long timeD_freeze;
    public static long timeE_freeze;
    public static int counterA_freeze;
    public static int counterB_freeze;
    public static int counterC_freeze;
    public static int counterD_freeze;
    public static int counterE_freeze;
    public static int iterations_freeze;
    
    public static void reset() {
        unfreeze();
        timeA = 0;
        timeB = 0;
        timeC = 0;
        timeD = 0;
        timeE = 0;
        counterA = 0;
        counterB = 0;
        counterC = 0;
        counterD = 0;
        counterE = 0;
        iterations = 0;
    }
    
    /**
     * Temporarily freeze the counter by storing the values.
     */
    public static void freeze() {
        if (isFrozen) return;
        timeA_freeze = timeA;
        timeB_freeze = timeB;
        timeC_freeze = timeC;
        timeD_freeze = timeD;
        timeE_freeze = timeE;
        counterA_freeze = counterA;
        counterB_freeze = counterB;
        counterC_freeze = counterC;
        counterD_freeze = counterD;
        counterE_freeze = counterE;
        iterations_freeze = iterations;
        
        isFrozen = true;
    }
    
    /**
     * Unfreeze the counter 
     */
    public static void unfreeze() {
        if (!isFrozen) return;
        tryRetrieveFrozenValues();
        
        isFrozen = false;
    }
    
    private static void tryRetrieveFrozenValues() {
        if (!isFrozen) return;
        timeA = timeA_freeze;
        timeB = timeB_freeze;
        timeC = timeC_freeze;
        timeD = timeD_freeze;
        timeE = timeE_freeze;
        counterA = counterA_freeze;
        counterB = counterB_freeze;
        counterC = counterC_freeze;
        counterD = counterD_freeze;
        counterE = counterE_freeze;
        iterations = iterations_freeze;
    }

    private static double toSecs(long value) {
        return value / 1000000.;
    }

    private static double toSecsPer(long value) {
        return value / 1000000. / iterations;
    }

    private static double per(int value) {
        return (double)value / iterations;
    }

    public static void print() {
        tryRetrieveFrozenValues();
        
        System.out.println("Time A: " + toSecs(timeA));
        System.out.println("Time B: " + toSecs(timeB));
        System.out.println("Time C: " + toSecs(timeC));
        System.out.println("Time D: " + toSecs(timeD));
        System.out.println("Time E: " + toSecs(timeE));
        if (counterA != 0) System.out.println("Count A: " + counterA);
        if (counterB != 0) System.out.println("Count B: " + counterB);
        if (counterC != 0) System.out.println("Count C: " + counterC);
        if (counterD != 0) System.out.println("Count D: " + counterD);
        if (counterE != 0) System.out.println("Count E: " + counterE);

        System.out.println("Iterations: " + iterations);
    }

    public static void printAverage() {
        tryRetrieveFrozenValues();
        
        System.out.println("Time A: " + toSecsPer(timeA));
        System.out.println("Time B: " + toSecsPer(timeB));
        System.out.println("Time C: " + toSecsPer(timeC));
        System.out.println("Time D: " + toSecsPer(timeD));
        System.out.println("Time E: " + toSecsPer(timeE));
        if (counterA != 0) System.out.println("Count A: " + per(counterA));
        if (counterB != 0) System.out.println("Count B: " + per(counterB));
        if (counterC != 0) System.out.println("Count C: " + per(counterC));
        if (counterD != 0) System.out.println("Count D: " + per(counterD));
        if (counterE != 0) System.out.println("Count E: " + per(counterE));

        System.out.println("Iterations: " + iterations);
    }
    
    
}
