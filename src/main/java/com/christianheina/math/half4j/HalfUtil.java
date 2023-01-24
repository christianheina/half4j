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

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

/**
 * Utility for {@link Half}.
 * 
 * @author Christian Heina (developer@christianheina.com)
 */
public class HalfUtil {

    private HalfUtil() {
        /* Hidden Constructor */ }

    /**
     * Convert bytes to List of Half objects.<br>
     * If number of bytes is odd the last byte will be dropped.
     * 
     * @param bytes
     *            the bytes to convert.
     * 
     * @return List of Half objects.
     */
    public static List<Half> bytesToHalfList(byte... bytes) {
        return bytesToHalfList(bytesToByteBuffer(bytes));
    }

    /**
     * Convert ByteBuffer to List of Half objects.
     * 
     * @param buf
     *            the ByteBuffer to convert.
     * 
     * @return List of Half objects.
     */
    public static List<Half> bytesToHalfList(ByteBuffer buf) {
        return Arrays.asList(bytesToHalfArray(buf));
    }

    /**
     * Convert bytes to array of Half objects.<br>
     * If number of bytes is odd the last byte will be dropped.
     * 
     * @param bytes
     *            the bytes to convert.
     * 
     * @return array of Half objects.
     */
    public static Half[] bytesToHalfArray(byte... bytes) {
        return bytesToHalfArray(bytesToByteBuffer(bytes));
    }

    /**
     * Convert ByteBuffer to array of Half objects.
     * 
     * @param buf
     *            the ByteBuffer to convert.
     * 
     * @return array of Half objects.
     */
    public static Half[] bytesToHalfArray(ByteBuffer buf) {
        short[] shortArray = new short[buf.capacity() / 2];
        buf.asShortBuffer().get(shortArray);
        Half[] halfArray = new Half[shortArray.length];
        for (int i = 0; i < shortArray.length; i++) {
            halfArray[i] = Half.shortBitsToHalf(shortArray[i]);
        }
        return halfArray;
    }

    private static ByteBuffer bytesToByteBuffer(byte... bytes) {
        ByteBuffer buf = ByteBuffer.allocate(bytes.length);
        buf.put(bytes);
        buf.rewind();
        return buf;
    }

}
