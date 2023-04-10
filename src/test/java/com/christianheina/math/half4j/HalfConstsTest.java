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
 * Unit test for {@link HalfConsts}.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class HalfConstsTest {

    @Test
    public void constsTest() {
        Assert.assertEquals(HalfConsts.SIGNIFICAND_WIDTH, 11);
        Assert.assertEquals(HalfConsts.MIN_SUB_EXPONENT, -24);
        Assert.assertEquals(HalfConsts.EXP_BIAS, 15);

        Assert.assertEquals(HalfConsts.SIGN_BIT_MASK, 0x8000);
        Assert.assertEquals(HalfConsts.EXP_BIT_MASK, 0x7C00);
        Assert.assertEquals(HalfConsts.SIGNIF_BIT_MASK, 0x03FF);

        // Check all bits filled and no overlap
        Assert.assertEquals((HalfConsts.SIGN_BIT_MASK | HalfConsts.EXP_BIT_MASK | HalfConsts.SIGNIF_BIT_MASK), 65535);
        Assert.assertEquals((HalfConsts.SIGN_BIT_MASK & HalfConsts.EXP_BIT_MASK), 0);
        Assert.assertEquals((HalfConsts.SIGN_BIT_MASK & HalfConsts.SIGNIF_BIT_MASK), 0);
        Assert.assertEquals((HalfConsts.EXP_BIT_MASK & HalfConsts.SIGNIF_BIT_MASK), 0);
    }

}
