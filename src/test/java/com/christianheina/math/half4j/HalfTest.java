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
 * Unit test for {@link Half}.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class HalfTest {

    private static final short POSITIVE_INFINITY_SHORT_VALUE = (short) 0x7c00;
    private static final short NEGATIVE_INFINITY_SHORT_VALUE = (short) 0xfc00;
    private static final short NaN_SHORT_VALUE = (short) 0x7e00;
    private static final short MAX_VALUE_SHORT_VALUE = (short) 0x7bff;
    private static final short MIN_NORMAL_SHORT_VALUE = (short) 0x0400;
    private static final short MIN_VALUE_SHORT_VALUE = (short) 0x1;
    private static final int MAX_EXPONENT = 15;
    private static final int MIN_EXPONENT = -14;
    private static final int SIZE = 16;
    private static final int BYTES = 2;
    private static final short POSITIVE_ZERO_SHORT_VALUE = (short) 0x0;
    private static final short NEGATIVE_ZERO_SHORT_VALUE = (short) 0x8000;

    private static final short LOWEST_ABOVE_ONE_SHORT_VALUE = (short) 0x3c01;
    private static final Half LOWEST_ABOVE_ONE = Half.shortBitsToHalf(LOWEST_ABOVE_ONE_SHORT_VALUE);
    private static final short NEGATIVE_MAX_VALUE_SHORT_VALUE = (short) 0xfbff;
    private static final Half NEGATIVE_MAX_VALUE = Half.shortBitsToHalf(NEGATIVE_MAX_VALUE_SHORT_VALUE);

    @Test
    public void publicStaticClassVariableTest() {
        Assert.assertEquals(Half.halfToShortBits(Half.POSITIVE_INFINITY), POSITIVE_INFINITY_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.NEGATIVE_INFINITY), NEGATIVE_INFINITY_SHORT_VALUE);

        Assert.assertEquals(Half.halfToShortBits(Half.NaN), NaN_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.MAX_VALUE), MAX_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.MIN_NORMAL), MIN_NORMAL_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.MIN_VALUE), MIN_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.MAX_EXPONENT, MAX_EXPONENT);

        Assert.assertEquals(Half.MIN_EXPONENT, MIN_EXPONENT);
        Assert.assertEquals(Half.SIZE, SIZE);
        Assert.assertEquals(Half.BYTES, BYTES);
        Assert.assertEquals(Half.halfToShortBits(Half.POSITIVE_ZERO), POSITIVE_ZERO_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.NEGATIVE_ZERO), NEGATIVE_ZERO_SHORT_VALUE);
    }

    @Test
    public void shortBitsToHalfTest() {
        Assert.assertEquals(Half.shortBitsToHalf(POSITIVE_INFINITY_SHORT_VALUE).floatValue(), Float.POSITIVE_INFINITY);
        Assert.assertEquals(Half.shortBitsToHalf(NEGATIVE_INFINITY_SHORT_VALUE).floatValue(), Float.NEGATIVE_INFINITY);
        Assert.assertEquals(Half.shortBitsToHalf(NaN_SHORT_VALUE).floatValue(), Float.NaN);
        Assert.assertEquals(Half.shortBitsToHalf(MAX_VALUE_SHORT_VALUE).floatValue(), 65504f);
        Assert.assertEquals(Half.shortBitsToHalf(MIN_NORMAL_SHORT_VALUE).floatValue(), 6.103515625e-5f);
        Assert.assertEquals(Half.shortBitsToHalf(MIN_VALUE_SHORT_VALUE).floatValue(), 5.9604645e-8f);
        Assert.assertEquals(Half.shortBitsToHalf(POSITIVE_ZERO_SHORT_VALUE).floatValue(), 0f);
        Assert.assertEquals(Half.shortBitsToHalf(NEGATIVE_ZERO_SHORT_VALUE).floatValue(), -0f);

        Assert.assertEquals(Half.shortBitsToHalf(LOWEST_ABOVE_ONE_SHORT_VALUE).floatValue(), 1.00097656f);
    }

    @Test
    public void halfToShortBitsTest() {
        Assert.assertEquals(Half.halfToShortBits(Half.POSITIVE_INFINITY), POSITIVE_INFINITY_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.NEGATIVE_INFINITY), NEGATIVE_INFINITY_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.NaN), NaN_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.MAX_VALUE), MAX_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.MIN_NORMAL), MIN_NORMAL_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.MIN_VALUE), MIN_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.POSITIVE_ZERO), POSITIVE_ZERO_SHORT_VALUE);
        Assert.assertEquals(Half.halfToShortBits(Half.NEGATIVE_ZERO), NEGATIVE_ZERO_SHORT_VALUE);

        Assert.assertEquals(Half.halfToShortBits(LOWEST_ABOVE_ONE), LOWEST_ABOVE_ONE_SHORT_VALUE);
    }

    @Test
    public void halfToRawShortBitsTest() {
        Assert.assertEquals(Half.halfToRawShortBits(Half.POSITIVE_INFINITY), POSITIVE_INFINITY_SHORT_VALUE);
        Assert.assertEquals(Half.halfToRawShortBits(Half.NEGATIVE_INFINITY), NEGATIVE_INFINITY_SHORT_VALUE);
        Assert.assertEquals(Half.halfToRawShortBits(Half.NaN), (short) 0x7c00);
        Assert.assertEquals(Half.halfToRawShortBits(Half.MAX_VALUE), MAX_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.halfToRawShortBits(Half.MIN_NORMAL), MIN_NORMAL_SHORT_VALUE);
        Assert.assertEquals(Half.halfToRawShortBits(Half.MIN_VALUE), MIN_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.halfToRawShortBits(Half.POSITIVE_ZERO), POSITIVE_ZERO_SHORT_VALUE);
        Assert.assertEquals(Half.halfToRawShortBits(Half.NEGATIVE_ZERO), NEGATIVE_ZERO_SHORT_VALUE);

        Assert.assertEquals(Half.halfToRawShortBits(LOWEST_ABOVE_ONE), LOWEST_ABOVE_ONE_SHORT_VALUE);
    }

    @Test
    public void shortValueTest() {
        Assert.assertEquals(Half.POSITIVE_INFINITY.shortValue(), Short.MAX_VALUE);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.shortValue(), Short.MIN_VALUE);
        Assert.assertEquals(Half.NaN.shortValue(), (short) 0);
        Assert.assertEquals(Half.MAX_VALUE.shortValue(), Short.MAX_VALUE);
        Assert.assertEquals(NEGATIVE_MAX_VALUE.shortValue(), Short.MIN_VALUE);
        Assert.assertEquals(Half.MIN_NORMAL.shortValue(), (short) 0);
        Assert.assertEquals(Half.MIN_VALUE.shortValue(), (short) 0);
        Assert.assertEquals(Half.POSITIVE_ZERO.shortValue(), (short) 0);
        Assert.assertEquals(Half.NEGATIVE_ZERO.shortValue(), (short) 0);

        Assert.assertEquals(LOWEST_ABOVE_ONE.shortValue(), (short) 1);
    }

    @Test
    public void intValueTest() {
        Assert.assertEquals(Half.POSITIVE_INFINITY.intValue(), Integer.MAX_VALUE);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.intValue(), Integer.MIN_VALUE);
        Assert.assertEquals(Half.NaN.intValue(), 0);
        Assert.assertEquals(Half.MAX_VALUE.intValue(), 65504);
        Assert.assertEquals(Half.MIN_NORMAL.intValue(), 0);
        Assert.assertEquals(Half.MIN_VALUE.intValue(), 0);
        Assert.assertEquals(Half.POSITIVE_ZERO.intValue(), 0);
        Assert.assertEquals(Half.NEGATIVE_ZERO.intValue(), 0);

        Assert.assertEquals(LOWEST_ABOVE_ONE.intValue(), 1);
    }

    @Test
    public void longValueTest() {
        Assert.assertEquals(Half.POSITIVE_INFINITY.longValue(), Long.MAX_VALUE);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.longValue(), Long.MIN_VALUE);
        Assert.assertEquals(Half.NaN.longValue(), 0);
        Assert.assertEquals(Half.MAX_VALUE.longValue(), 65504);
        Assert.assertEquals(Half.MIN_NORMAL.longValue(), 0);
        Assert.assertEquals(Half.MIN_VALUE.longValue(), 0);
        Assert.assertEquals(Half.POSITIVE_ZERO.longValue(), 0);
        Assert.assertEquals(Half.NEGATIVE_ZERO.longValue(), 0);

        Assert.assertEquals(LOWEST_ABOVE_ONE.longValue(), 1);
    }

    @Test
    public void floatValueTest() {
        Assert.assertEquals(Half.POSITIVE_INFINITY.floatValue(), Float.POSITIVE_INFINITY);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.floatValue(), Float.NEGATIVE_INFINITY);
        Assert.assertEquals(Half.NaN.floatValue(), Float.NaN);
        Assert.assertEquals(Half.MAX_VALUE.floatValue(), 65504f);
        Assert.assertEquals(Half.MIN_NORMAL.floatValue(), 6.103515625e-5f);
        Assert.assertEquals(Half.MIN_VALUE.floatValue(), 5.9604645e-8f);
        Assert.assertEquals(Half.POSITIVE_ZERO.floatValue(), 0f);
        Assert.assertEquals(Half.NEGATIVE_ZERO.floatValue(), -0f);

        Assert.assertEquals(LOWEST_ABOVE_ONE.floatValue(), 1.00097656f);
    }

    @Test
    public void doubleValueTest() {
        Assert.assertEquals(Half.POSITIVE_INFINITY.doubleValue(), Double.POSITIVE_INFINITY);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.doubleValue(), Double.NEGATIVE_INFINITY);
        Assert.assertEquals(Half.NaN.doubleValue(), Double.NaN);
        Assert.assertEquals(Half.MAX_VALUE.doubleValue(), 65504d);
        Assert.assertEquals(Half.MIN_NORMAL.doubleValue(), 6.103515625e-5d);
        Assert.assertEquals(Half.MIN_VALUE.doubleValue(), 5.9604644775390625E-8d);
        Assert.assertEquals(Half.POSITIVE_ZERO.doubleValue(), 0d);
        Assert.assertEquals(Half.NEGATIVE_ZERO.doubleValue(), -0d);

        Assert.assertEquals(LOWEST_ABOVE_ONE.doubleValue(), 1.0009765625d);
    }

    @Test
    public void valueOfStringTest() {
        Assert.assertEquals(Half.valueOf("Infinity"), Half.POSITIVE_INFINITY);
        Assert.assertEquals(Half.valueOf("-Infinity"), Half.NEGATIVE_INFINITY);
        Assert.assertEquals(Half.valueOf("NaN"), Half.NaN);
        Assert.assertEquals(Half.valueOf("65504"), Half.MAX_VALUE);
        Assert.assertEquals(Half.valueOf("6.103515625e-5"), Half.MIN_NORMAL);
        Assert.assertEquals(Half.valueOf("5.9604645e-8"), Half.MIN_VALUE);
        Assert.assertEquals(Half.valueOf("0"), Half.POSITIVE_ZERO);
        Assert.assertEquals(Half.valueOf("-0"), Half.NEGATIVE_ZERO);

        Assert.assertEquals(Half.valueOf("1.00097656f"), LOWEST_ABOVE_ONE);
    }

    @Test
    public void valueOfDoubleTest() {
        Assert.assertEquals(Half.valueOf(Double.valueOf(Double.POSITIVE_INFINITY)), Half.POSITIVE_INFINITY);
        Assert.assertEquals(Half.valueOf(Double.valueOf(Double.NEGATIVE_INFINITY)), Half.NEGATIVE_INFINITY);
        Assert.assertEquals(Half.valueOf(Double.valueOf(Double.NaN)), Half.NaN);
        Assert.assertEquals(Half.valueOf(Double.valueOf(65504d)), Half.MAX_VALUE);
        Assert.assertEquals(Half.valueOf(Double.valueOf(6.103515625e-5d)), Half.MIN_NORMAL);
        Assert.assertEquals(Half.valueOf(Double.valueOf(5.9604644775390625E-8d)), Half.MIN_VALUE);
        Assert.assertEquals(Half.valueOf(Double.valueOf(0d)), Half.POSITIVE_ZERO);
        Assert.assertEquals(Half.valueOf(Double.valueOf(-0d)), Half.NEGATIVE_ZERO);

        Assert.assertEquals(Half.valueOf(Double.valueOf(1.0009765625d)), LOWEST_ABOVE_ONE);
    }

    @Test
    public void valueOfFloatTest() {
        Assert.assertEquals(Half.valueOf(Float.valueOf(Float.POSITIVE_INFINITY)), Half.POSITIVE_INFINITY);
        Assert.assertEquals(Half.valueOf(Float.valueOf(Float.NEGATIVE_INFINITY)), Half.NEGATIVE_INFINITY);
        Assert.assertEquals(Half.valueOf(Float.valueOf(Float.NaN)), Half.NaN);
        Assert.assertEquals(Half.valueOf(Float.valueOf(65504f)), Half.MAX_VALUE);
        Assert.assertEquals(Half.valueOf(Float.valueOf(6.103515625e-5f)), Half.MIN_NORMAL);
        Assert.assertEquals(Half.valueOf(Float.valueOf(5.9604645e-8f)), Half.MIN_VALUE);
        Assert.assertEquals(Half.valueOf(Float.valueOf(0f)), Half.POSITIVE_ZERO);
        Assert.assertEquals(Half.valueOf(Float.valueOf(-0f)), Half.NEGATIVE_ZERO);

        Assert.assertEquals(Half.valueOf(Float.valueOf(1.00097656f)), LOWEST_ABOVE_ONE);
    }

    @Test
    public void isNaNTest() {
        Assert.assertFalse(Half.POSITIVE_INFINITY.isNaN());
        Assert.assertFalse(Half.NEGATIVE_INFINITY.isNaN());
        Assert.assertTrue(Half.NaN.isNaN());
        Assert.assertFalse(Half.MAX_VALUE.isNaN());
        Assert.assertFalse(Half.MIN_NORMAL.isNaN());
        Assert.assertFalse(Half.MIN_VALUE.isNaN());
        Assert.assertFalse(Half.POSITIVE_ZERO.isNaN());
        Assert.assertFalse(Half.NEGATIVE_ZERO.isNaN());

        Assert.assertFalse(LOWEST_ABOVE_ONE.isNaN());
    }

    @Test
    public void isInfiniteTest() {
        Assert.assertTrue(Half.POSITIVE_INFINITY.isInfinite());
        Assert.assertTrue(Half.NEGATIVE_INFINITY.isInfinite());
        Assert.assertFalse(Half.NaN.isInfinite());
        Assert.assertFalse(Half.MAX_VALUE.isInfinite());
        Assert.assertFalse(Half.MIN_NORMAL.isInfinite());
        Assert.assertFalse(Half.MIN_VALUE.isInfinite());
        Assert.assertFalse(Half.POSITIVE_ZERO.isInfinite());
        Assert.assertFalse(Half.NEGATIVE_ZERO.isInfinite());

        Assert.assertFalse(LOWEST_ABOVE_ONE.isInfinite());
    }

    @Test
    public void isFiniteTest() {
        Assert.assertFalse(Half.POSITIVE_INFINITY.isFinite());
        Assert.assertFalse(Half.NEGATIVE_INFINITY.isFinite());
        Assert.assertFalse(Half.NaN.isFinite());
        Assert.assertTrue(Half.MAX_VALUE.isFinite());
        Assert.assertTrue(Half.MIN_NORMAL.isFinite());
        Assert.assertTrue(Half.MIN_VALUE.isFinite());
        Assert.assertTrue(Half.POSITIVE_ZERO.isFinite());
        Assert.assertTrue(Half.NEGATIVE_ZERO.isFinite());

        Assert.assertTrue(LOWEST_ABOVE_ONE.isFinite());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals(Half.POSITIVE_INFINITY.toString(), "Infinity");
        Assert.assertEquals(Half.NEGATIVE_INFINITY.toString(), "-Infinity");
        Assert.assertEquals(Half.NaN.toString(), "NaN");
        Assert.assertEquals(Half.MAX_VALUE.toString(), "65504.0");
        Assert.assertEquals(Half.MIN_NORMAL.toString().toLowerCase(), "6.1035156e-5");
        Assert.assertEquals(Half.MIN_VALUE.toString().toLowerCase(), "5.9604645e-8");
        Assert.assertEquals(Half.POSITIVE_ZERO.toString(), "0.0");
        Assert.assertEquals(Half.NEGATIVE_ZERO.toString(), "-0.0");

        Assert.assertEquals(LOWEST_ABOVE_ONE.toString().toLowerCase(), "1.0009766");
    }

    @Test
    public void toHexStringTest() {
        // TODO: implement unit test
    }

    @Test
    public void equalsTest() {
        Assert.assertTrue(Half.POSITIVE_INFINITY.equals(Half.POSITIVE_INFINITY));
        Assert.assertTrue(Half.NEGATIVE_INFINITY.equals(Half.NEGATIVE_INFINITY));
        Assert.assertTrue(Half.NaN.equals(Half.NaN));
        Assert.assertTrue(Half.MAX_VALUE.equals(Half.MAX_VALUE));
        Assert.assertTrue(Half.MIN_NORMAL.equals(Half.MIN_NORMAL));
        Assert.assertTrue(Half.MIN_VALUE.equals(Half.MIN_VALUE));
        Assert.assertTrue(Half.POSITIVE_ZERO.equals(Half.POSITIVE_ZERO));
        Assert.assertTrue(Half.NEGATIVE_ZERO.equals(Half.NEGATIVE_ZERO));

        Assert.assertTrue(LOWEST_ABOVE_ONE.equals(LOWEST_ABOVE_ONE));

        Assert.assertFalse(Half.POSITIVE_INFINITY.equals(Half.NEGATIVE_INFINITY));
        Assert.assertFalse(Half.NEGATIVE_INFINITY.equals(Half.POSITIVE_INFINITY));
        Assert.assertFalse(Half.NaN.equals(Half.POSITIVE_INFINITY));
        Assert.assertFalse(Half.MAX_VALUE.equals(Half.NaN));
        Assert.assertFalse(Half.MIN_NORMAL.equals(Half.MIN_VALUE));
        Assert.assertFalse(Half.MIN_VALUE.equals(Half.POSITIVE_ZERO));
        Assert.assertFalse(Half.POSITIVE_ZERO.equals(Half.NEGATIVE_ZERO));
        Assert.assertFalse(Half.NEGATIVE_ZERO.equals(Half.POSITIVE_ZERO));

        Assert.assertFalse(LOWEST_ABOVE_ONE.equals(Half.MIN_NORMAL));

        Assert.assertFalse(LOWEST_ABOVE_ONE.equals(null));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(Half.POSITIVE_INFINITY.hashCode(), POSITIVE_INFINITY_SHORT_VALUE);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.hashCode(), NEGATIVE_INFINITY_SHORT_VALUE);
        Assert.assertEquals(Half.NaN.hashCode(), NaN_SHORT_VALUE);
        Assert.assertEquals(Half.MAX_VALUE.hashCode(), MAX_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.MIN_NORMAL.hashCode(), MIN_NORMAL_SHORT_VALUE);
        Assert.assertEquals(Half.MIN_VALUE.hashCode(), MIN_VALUE_SHORT_VALUE);
        Assert.assertEquals(Half.POSITIVE_ZERO.hashCode(), POSITIVE_ZERO_SHORT_VALUE);
        Assert.assertEquals(Half.NEGATIVE_ZERO.hashCode(), NEGATIVE_ZERO_SHORT_VALUE);

        Assert.assertEquals(LOWEST_ABOVE_ONE.hashCode(), LOWEST_ABOVE_ONE_SHORT_VALUE);
    }

    @Test
    public void compareToTest() {
        // Left
        Assert.assertEquals(Half.POSITIVE_INFINITY.compareTo(Half.NEGATIVE_INFINITY), 1);
        Assert.assertEquals(Half.MAX_VALUE.compareTo(Half.NEGATIVE_INFINITY), 1);
        Assert.assertEquals(Half.NaN.compareTo(Half.NEGATIVE_INFINITY), 1);
        Assert.assertEquals(Half.MAX_VALUE.compareTo(Half.MIN_NORMAL), 1);
        Assert.assertEquals(Half.MIN_NORMAL.compareTo(Half.MIN_VALUE), 1);
        Assert.assertEquals(Half.MIN_VALUE.compareTo(Half.POSITIVE_ZERO), 1);
        Assert.assertEquals(Half.POSITIVE_ZERO.compareTo(Half.NEGATIVE_ZERO), 1);
        Assert.assertEquals(LOWEST_ABOVE_ONE.compareTo(Half.NEGATIVE_ZERO), 1);

        // Right
        Assert.assertEquals(Half.NEGATIVE_INFINITY.compareTo(Half.POSITIVE_INFINITY), -1);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.compareTo(Half.MAX_VALUE), -1);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.compareTo(Half.NaN), -1);
        Assert.assertEquals(Half.MIN_NORMAL.compareTo(Half.MAX_VALUE), -1);
        Assert.assertEquals(Half.MIN_VALUE.compareTo(Half.MIN_NORMAL), -1);
        Assert.assertEquals(Half.POSITIVE_ZERO.compareTo(Half.MIN_VALUE), -1);
        Assert.assertEquals(Half.NEGATIVE_ZERO.compareTo(Half.POSITIVE_ZERO), -1);
        Assert.assertEquals(Half.NEGATIVE_ZERO.compareTo(LOWEST_ABOVE_ONE), -1);

        // Equals
        Assert.assertEquals(Half.POSITIVE_INFINITY.compareTo(Half.POSITIVE_INFINITY), 0);
        Assert.assertEquals(Half.NEGATIVE_INFINITY.compareTo(Half.NEGATIVE_INFINITY), 0);
        Assert.assertEquals(Half.NaN.compareTo(Half.NaN), 0);
        Assert.assertEquals(Half.MAX_VALUE.compareTo(Half.MAX_VALUE), 0);
        Assert.assertEquals(Half.MIN_NORMAL.compareTo(Half.MIN_NORMAL), 0);
        Assert.assertEquals(Half.MIN_VALUE.compareTo(Half.MIN_VALUE), 0);
        Assert.assertEquals(Half.POSITIVE_ZERO.compareTo(Half.POSITIVE_ZERO), 0);
        Assert.assertEquals(Half.NEGATIVE_ZERO.compareTo(Half.NEGATIVE_ZERO), 0);
        Assert.assertEquals(LOWEST_ABOVE_ONE.compareTo(LOWEST_ABOVE_ONE), 0);
    }

    @Test
    public void sumTest() {
        Assert.assertEquals(Half.sum(Half.POSITIVE_INFINITY, Half.MAX_VALUE), Half.POSITIVE_INFINITY);
        Assert.assertEquals(Half.sum(Half.POSITIVE_INFINITY, Half.NEGATIVE_INFINITY), Half.NaN);
        Assert.assertEquals(Half.sum(Half.NaN, Half.NaN), Half.NaN);
        Assert.assertEquals(Half.sum(Half.NaN, Half.MAX_VALUE), Half.NaN);
        Assert.assertEquals(Half.sum(Half.MIN_NORMAL, Half.MIN_VALUE), Half.valueOf(6.109476E-5f));
        Assert.assertEquals(Half.sum(Half.MIN_VALUE, Half.POSITIVE_ZERO), Half.MIN_VALUE);
        Assert.assertEquals(Half.sum(Half.MAX_VALUE, LOWEST_ABOVE_ONE), Half.MAX_VALUE);
        Assert.assertEquals(Half.sum(Half.POSITIVE_ZERO, Half.NEGATIVE_ZERO), Half.POSITIVE_ZERO);

        Assert.assertEquals(Half.sum(Half.NaN, LOWEST_ABOVE_ONE), Half.NaN);
    }

    @Test
    public void maxTest() {
        Assert.assertEquals(Half.max(Half.POSITIVE_INFINITY, Half.MAX_VALUE), Half.POSITIVE_INFINITY);
        Assert.assertEquals(Half.max(Half.POSITIVE_INFINITY, Half.NEGATIVE_INFINITY), Half.POSITIVE_INFINITY);
        Assert.assertEquals(Half.max(Half.NaN, Half.NaN), Half.NaN);
        Assert.assertEquals(Half.max(Half.NaN, Half.MAX_VALUE), Half.NaN);
        Assert.assertEquals(Half.max(Half.MIN_NORMAL, Half.MIN_VALUE), Half.MIN_NORMAL);
        Assert.assertEquals(Half.max(Half.MIN_VALUE, Half.POSITIVE_ZERO), Half.MIN_VALUE);
        Assert.assertEquals(Half.max(Half.MAX_VALUE, LOWEST_ABOVE_ONE), Half.MAX_VALUE);
        Assert.assertEquals(Half.max(Half.POSITIVE_ZERO, Half.NEGATIVE_ZERO), Half.POSITIVE_ZERO);

        Assert.assertEquals(Half.max(Half.NaN, LOWEST_ABOVE_ONE), Half.NaN);
    }

    @Test
    public void minTest() {
        Assert.assertEquals(Half.min(Half.POSITIVE_INFINITY, Half.MAX_VALUE), Half.MAX_VALUE);
        Assert.assertEquals(Half.min(Half.POSITIVE_INFINITY, Half.NEGATIVE_INFINITY), Half.NEGATIVE_INFINITY);
        Assert.assertEquals(Half.min(Half.NaN, Half.NaN), Half.NaN);
        Assert.assertEquals(Half.min(Half.NaN, Half.MAX_VALUE), Half.NaN);
        Assert.assertEquals(Half.min(Half.MIN_NORMAL, Half.MIN_VALUE), Half.MIN_VALUE);
        Assert.assertEquals(Half.min(Half.MIN_VALUE, Half.POSITIVE_ZERO), Half.POSITIVE_ZERO);
        Assert.assertEquals(Half.min(Half.MAX_VALUE, LOWEST_ABOVE_ONE), LOWEST_ABOVE_ONE);
        Assert.assertEquals(Half.min(Half.POSITIVE_ZERO, Half.NEGATIVE_ZERO), Half.NEGATIVE_ZERO);

        Assert.assertEquals(Half.min(Half.NaN, LOWEST_ABOVE_ONE), Half.NaN);
    }

}
