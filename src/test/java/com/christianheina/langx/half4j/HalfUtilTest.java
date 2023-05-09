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

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for {@link HalfUtil}.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
@SuppressWarnings("javadoc")
public class HalfUtilTest {

    private static final byte[] BYTE_ARRAY = new byte[] { 0, 1, 1, 1 };

    @Test
    public void bytesToHalfListTest() {
        List<Half> halfList = HalfUtil.bytesToHalfList(BYTE_ARRAY);
        Assert.assertEquals(halfList.size(), 2);
        Assert.assertEquals(Half.halfToShortBits(halfList.get(0)), 0x1);
        Assert.assertEquals(Half.halfToShortBits(halfList.get(1)), 0x101);
    }

    @Test
    public void bytesToHalfTooFewBytesTest() {
        List<Half> halfList = HalfUtil.bytesToHalfList(new byte[] { 1 });
        Assert.assertEquals(halfList.size(), 0);

        halfList = HalfUtil.bytesToHalfList(new byte[] { 0, 0, 1 });
        Assert.assertEquals(halfList.size(), 1);
        Assert.assertEquals(Half.halfToShortBits(halfList.get(0)), 0x0);
    }

    @Test
    public void bytesToHalfArrayTest() {
        Half[] halfArray = HalfUtil.bytesToHalfArray(BYTE_ARRAY);
        Assert.assertEquals(halfArray.length, 2);
        Assert.assertEquals(Half.halfToShortBits(halfArray[0]), 0x1);
        Assert.assertEquals(Half.halfToShortBits(halfArray[1]), 0x101);
    }

}
