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

package com.christianheina.math.half4j;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for {@link HalfMath}.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class HalfMathTest {

    private static final Half LARGEST_SUBNORMAL = Half.shortBitsToHalf((short) 0x3ff);

    @Test
    public void ulpTest() {
        // Special cases
        Assert.assertEquals(HalfMath.ulp(Half.NaN), Half.NaN);
        Assert.assertEquals(HalfMath.ulp(Half.POSITIVE_INFINITY), Half.POSITIVE_INFINITY);
        Assert.assertEquals(HalfMath.ulp(Half.NEGATIVE_INFINITY), Half.POSITIVE_INFINITY);
        Assert.assertEquals(HalfMath.ulp(Half.NEGATIVE_ZERO), Half.MIN_VALUE);
        Assert.assertEquals(HalfMath.ulp(Half.POSITIVE_ZERO), Half.MIN_VALUE);
        Assert.assertEquals(HalfMath.ulp(Half.MAX_VALUE), Half.valueOf(Math.pow(2, 5)));
        Assert.assertEquals(HalfMath.ulp(Half.NEGATIVE_MAX_VALUE), Half.valueOf(Math.pow(2, 5)));

        // Regular cases
        Assert.assertEquals(HalfMath.ulp(Half.MIN_NORMAL), Half.MIN_VALUE);
        Assert.assertEquals(HalfMath.ulp(LARGEST_SUBNORMAL), Half.MIN_VALUE);

        Assert.assertEquals(HalfMath.ulp(Half.shortBitsToHalf((short) 0x7ff)), Half.MIN_VALUE);
        Assert.assertEquals(HalfMath.ulp(Half.shortBitsToHalf((short) 0x7ff)), Half.MIN_VALUE);
    }

    @Test
    public void getExponentTest() {
        // Special cases
        Assert.assertEquals(HalfMath.getExponent(Half.NaN), Half.MAX_EXPONENT + 1);
        Assert.assertEquals(HalfMath.getExponent(Half.POSITIVE_INFINITY), Half.MAX_EXPONENT + 1);
        Assert.assertEquals(HalfMath.getExponent(Half.NEGATIVE_INFINITY), Half.MAX_EXPONENT + 1);
        Assert.assertEquals(HalfMath.getExponent(Half.POSITIVE_ZERO), Half.MIN_EXPONENT - 1);
        Assert.assertEquals(HalfMath.getExponent(Half.NEGATIVE_ZERO), Half.MIN_EXPONENT - 1);
        Assert.assertEquals(HalfMath.getExponent(Half.MIN_VALUE), Half.MIN_EXPONENT - 1);
        Assert.assertEquals(HalfMath.getExponent(LARGEST_SUBNORMAL), Half.MIN_EXPONENT - 1);

        // Regular cases
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(0.0002f)), -13);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(0.002f)), -9);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(0.02f)), -6);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(0.2f)), -3);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(2.0f)), 1);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(20.0f)), 4);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(200.0f)), 7);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(2000.0f)), 10);
        Assert.assertEquals(HalfMath.getExponent(Half.valueOf(20000.0f)), 14);
    }

    @Test
    public void absTest() {
        // Special cases
        Assert.assertEquals(HalfMath.abs(Half.POSITIVE_INFINITY), Half.POSITIVE_INFINITY);
        Assert.assertEquals(HalfMath.abs(Half.NEGATIVE_INFINITY), Half.POSITIVE_INFINITY);

        Assert.assertEquals(HalfMath.abs(Half.NaN), Half.NaN);
        Assert.assertEquals(HalfMath.abs(Half.shortBitsToHalf((short) 0x7e04)), Half.shortBitsToHalf((short) 0x7e04));
        Assert.assertEquals(HalfMath.abs(Half.shortBitsToHalf((short) 0x7fff)), Half.shortBitsToHalf((short) 0x7fff));

        // Regular cases
        Assert.assertEquals(HalfMath.abs(Half.POSITIVE_ZERO), Half.POSITIVE_ZERO);
        Assert.assertEquals(HalfMath.abs(Half.NEGATIVE_ZERO), Half.POSITIVE_ZERO);
        Assert.assertEquals(HalfMath.abs(Half.MAX_VALUE), Half.MAX_VALUE);
        Assert.assertEquals(HalfMath.abs(Half.NEGATIVE_MAX_VALUE), Half.MAX_VALUE);
    }

}
