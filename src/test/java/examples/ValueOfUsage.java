package examples;

import com.christianheina.math.half4j.Half;

/**
 * Half valueOf example usage.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class ValueOfUsage {

    private static final Half POSITIVE_TWO_HALF = Half.shortBitsToHalf((short) 0x4000);

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println("Value of decimal string: " + Half.valueOf("2.0"));
        System.out.println("Value of hex string : " + Half.valueOf("0x1.0p1"));
        System.out.println("Value of float: " + Half.valueOf(2.0f));
        System.out.println("Value of Float: " + Half.valueOf(Float.valueOf(2.0f)));
        System.out.println("Value of double: " + Half.valueOf(2.0d));
        System.out.println("Value of Double: " + Half.valueOf(Double.valueOf(2.0d)));
        System.out.println("Value of Half: " + Half.valueOf(POSITIVE_TWO_HALF));
    }

}
