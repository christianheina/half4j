package examples;

import com.christianheina.langx.half4j.Half;

/**
 * Short bits to Half example usage.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class ShortBitsToHalfUsage {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        short negTwoBits = -16384; // -2 half short representation
        Half negTwoHalf = Half.shortBitsToHalf(negTwoBits);
        System.out.println("short representation: " + negTwoBits + " == half value: " + negTwoHalf);

        short oneBits = 15360; // 1.0 half short representation
        Half oneHalf = Half.shortBitsToHalf(oneBits);
        System.out.println("short representation: " + oneBits + " == half value: " + oneHalf);

        short smallestBits = 1; // Smallest half value short representation
        Half smallestHalf = Half.shortBitsToHalf(smallestBits);
        System.out.println("short representation: " + smallestBits + " == half value: " + smallestHalf);
    }

}
