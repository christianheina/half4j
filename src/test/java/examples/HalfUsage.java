/*
 * Copyright 2023 Christian Heina
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package examples;

import com.christianheina.math.half4j.Half;

/**
 * Half usage example
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class HalfUsage {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        short zeroBits = 0;
        System.out.println(Half.shortBitsToHalf(zeroBits).floatValue());
        System.out.println(Half.POSITIVE_ZERO.floatValue());

        short negZeroBits = -32768;
        System.out.println(Half.shortBitsToHalf(negZeroBits).floatValue());
        System.out.println(Half.NEGATIVE_ZERO.floatValue());

        short infBits = 31744;
        System.out.println(Half.shortBitsToHalf(infBits).floatValue());
        System.out.println(Half.POSITIVE_INFINITY.floatValue());

        short negInfBits = -1024;
        System.out.println(Half.shortBitsToHalf(negInfBits).floatValue());
        System.out.println(Half.NEGATIVE_INFINITY.floatValue());

        short nanBits = 31745;
        System.out.println(Half.shortBitsToHalf(nanBits).floatValue());
        System.out.println(Half.NaN.floatValue());

        short negTwoBits = -16384;
        System.out.println(Half.shortBitsToHalf(negTwoBits).doubleValue());

        short oneBits = 15360;
        System.out.println(Half.shortBitsToHalf(oneBits).floatValue());

        short smallestBits = 1;
        System.out.println(Half.shortBitsToHalf(smallestBits).doubleValue());
        System.out.println(Half.MIN_VALUE.doubleValue());
        System.out.println(Half.shortBitsToHalf(smallestBits).floatValue());
        System.out.println(Half.MIN_VALUE.floatValue());

        System.out.println(Half.valueOf(Half.POSITIVE_INFINITY.floatValue()).doubleValue());
        System.out.println(Half.valueOf(Float.NaN).doubleValue());
        System.out.println(Half.MAX_VALUE.floatValue());
        System.out.println(Half.MIN_VALUE.floatValue());
        System.out.println(Half.MIN_NORMAL.floatValue());
        System.out.println(Half.POSITIVE_INFINITY.floatValue());

        System.out.println((double) Float.NaN);
        System.out.println(Float.floatToIntBits(Float.NaN));
        System.out.println(Double.doubleToLongBits(Double.NaN));
        System.out.println((double) Float.POSITIVE_INFINITY);
        System.out.println((double) Float.NEGATIVE_INFINITY);

        System.out.println(Double.MAX_VALUE);
        System.out.println((float) Double.MAX_VALUE);
        System.out.println(Half.valueOf(Double.MAX_VALUE).doubleValue());
        System.out.println(Half.valueOf(-Float.MAX_VALUE).floatValue());

        // short bits = (short)0x0401; // 6.103515625E-5
        // short bits = (short)0x1; // 5.9604645E-8
        System.out.println(Half.MAX_VALUE.floatValue());
        System.out.println(Half.MAX_VALUE.floatValue() / 1e8);
        Half halfVal = Half.valueOf(Half.MAX_VALUE.floatValue() / 1e8);
        short bits = Half.halfToShortBits(halfVal);
        long s = ((bits >> 15) == 0) ? 1 : -1;
        long e = ((bits >> 10) & 0x1f);
        long m = (e == 0) ? (bits & 0x3ff) << 1 : (bits & 0x3ff) | 0x400;
        System.out.println((e == 0) ? (bits & 0x3ff) << 1 : (bits & 0x3ff));
        System.out.println(0x400);
        System.out.println(s * m * (float) Math.pow(2, e - 25));
        System.out.println(halfVal.floatValue());
        System.out.println(Half.halfToShortBits(halfVal));
        System.out.println(Half.shortBitsToHalf((short) 4444));
        System.out.println(Half.shortBitsToHalf((short) 4446));

        s = ((bits >> 31) == 0) ? 1 : -1;
        e = ((bits >> 23) & 0xff);
        m = (e == 0) ? (bits & 0x7fffff) << 1 : (bits & 0x7fffff) | 0x800000;
        System.out.println(s * m * Math.pow(2, e - 150));
        System.out.println(Float.MIN_VALUE);
        s = ((bits >> 63) == 0) ? 1 : -1;
        e = ((bits >> 52) & 0x7ffL);
        m = (e == 0) ? (bits & 0xfffffffffffffL) << 1 : (bits & 0xfffffffffffffL) | 0x10000000000000L;
        System.out.println(s * m * Math.pow(2, e - 1075));
        System.out.println(Double.MIN_VALUE);

        /*
         * Half half = Half.MIN_VALUE; long totalTime = 0; float a = 10; long startTime; long stopTime; long nCalcs =
         * (long) 1e18; int nAveraging = 100; for (int r = 1; r <= nAveraging; r++) { startTime = System.nanoTime(); for
         * (long i = 0; i < nCalcs; i++) { continue; } stopTime = System.nanoTime(); totalTime += stopTime - startTime;
         * } // System.out.println("Total time run " + r + ": " + totalTime + " ns"); //
         * System.out.println("Number of conversions run " + r + ": " + nAveraging); System.out.println("Average time: "
         * + (totalTime / (double) nAveraging) / 1e9 + " s per " + Long.toString(nCalcs) + " calculations");
         */

        System.out.println(Float.floatToIntBits(Float.MAX_VALUE));
        System.out.println(Float.floatToIntBits(Float.sum(Float.MAX_VALUE, 1f)));
        System.out.println(Float.floatToIntBits(Float.MAX_VALUE + 1f));

        System.out.println(Float.MAX_VALUE + 10d);
        System.out.println((float) (Float.MAX_VALUE + Float.MAX_VALUE / 100000000d));
        System.out.println((float) (Float.MAX_VALUE / 100000000d));

        System.out.println(Double.doubleToLongBits(Float.MAX_VALUE + 10d));
        System.out.println(Float.floatToIntBits((float) (Float.MAX_VALUE + Float.MAX_VALUE / 2d)));
    }

}
