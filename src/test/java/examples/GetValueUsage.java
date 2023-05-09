package examples;

import com.christianheina.langx.half4j.Half;

/**
 * Get Half value as type, such as doubleValue, example usage.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class GetValueUsage {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Half halfValue = Half.NEGATIVE_MAX_VALUE;

        System.out.println("Byte value: " + halfValue.byteValue());
        System.out.println("Short value: " + halfValue.shortValue());
        System.out.println("Integer value: " + halfValue.intValue());
        System.out.println("Long value: " + halfValue.longValue());
        System.out.println("Float value: " + halfValue.floatValue());
        System.out.println("Double value: " + halfValue.doubleValue());
    }

}
