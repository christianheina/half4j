package examples;

import com.christianheina.math.half4j.Half;

/**
 * Half to short bits example usage.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class HalfToShortBitsUsage {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Half infinity short representation
        Short infinityHalfShortRepresentation = Half.halfToShortBits(Half.POSITIVE_INFINITY);
        System.out.println("Half infinity short representation: " + infinityHalfShortRepresentation);

        // Half max value short representation
        Short maxHalfValueShortRepresentation = Half.halfToShortBits(Half.MAX_VALUE);
        System.out.println("Half max value short representation: " + maxHalfValueShortRepresentation);

        // Half "quiet" signaling NaN value short representation
        Short quietNanHalfValueShortRepresentation = Half.halfToShortBits(Half.NaN);
        System.out.println("Half quiet signaling NaN short representation: " + quietNanHalfValueShortRepresentation);

        // Half signaling NaN value short representation
        Short signalingNanHalfValueShortRepresentation = Half.halfToRawShortBits(Half.shortBitsToHalf((short) 0x7e04));
        System.out.println("Half signaling NaN short representation: " + signalingNanHalfValueShortRepresentation);
    }

}
