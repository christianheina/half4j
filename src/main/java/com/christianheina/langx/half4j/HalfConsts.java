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

package com.christianheina.langx.half4j;

/**
 * This class contains additional constants documenting limits of {@code Half}.
 * 
 * <p>
 * {@code HalfConsts} is implemented to provide, as much as possible, the same interface as
 * {@code jdk.internal.math.FloatConsts}.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
public class HalfConsts {

    private HalfConsts() {
        /* Hidden Constructor */ }

    /**
     * The number of logical bits in the significand of a {@code half} number, including the implicit bit.
     */
    public static final int SIGNIFICAND_WIDTH = 11;

    /**
     * The exponent the smallest positive {@code half} subnormal value would have if it could be normalized.
     */
    public static final int MIN_SUB_EXPONENT = Half.MIN_EXPONENT - (SIGNIFICAND_WIDTH - 1);

    /**
     * Bias used in representing a {@code half} exponent.
     */
    public static final int EXP_BIAS = 15;

    /**
     * Bit mask to isolate the sign bit of a {@code half}.
     */
    public static final int SIGN_BIT_MASK = 0x8000;

    /**
     * Bit mask to isolate the exponent field of a {@code half}.
     */
    public static final int EXP_BIT_MASK = 0x7C00;

    /**
     * Bit mask to isolate the significand field of a {@code half}.
     */
    public static final int SIGNIF_BIT_MASK = 0x03FF;

}
