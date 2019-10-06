/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.symfony2.annotations.validators.parser;

import java.util.Map;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.spi.annotation.AnnotationLineParser;
import org.netbeans.modules.php.spi.annotation.AnnotationParsedLine;

/**
 *
 * @author Ondrej Brejla <obrejla@netbeans.org>
 */
public class MinLengthLineParserTest extends NbTestCase {
    private AnnotationLineParser parser;

    public MinLengthLineParserTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        parser = SymfonyValidatorsAnnotationLineParser.getDefault();
    }

    public void testIsAnnotationParser() throws Exception {
        assertTrue(parser instanceof AnnotationLineParser);
    }

    public void testReturnValueIsMinLengthParsedLine_01() throws Exception {
        assertTrue(parser.parse("MinLength") instanceof AnnotationParsedLine.ParsedLine);
    }

    public void testReturnValueIsMinLengthParsedLine_02() throws Exception {
        assertTrue(parser.parse("Annotations\\MinLength") instanceof AnnotationParsedLine.ParsedLine);
    }

    public void testReturnValueIsMinLengthParsedLine_03() throws Exception {
        assertTrue(parser.parse("\\Foo\\Bar\\MinLength") instanceof AnnotationParsedLine.ParsedLine);
    }

    public void testReturnValueIsMinLengthParsedLine_04() throws Exception {
        assertTrue(parser.parse("Annotations\\MinLength(message=\"msg\", limit = 3)") instanceof AnnotationParsedLine.ParsedLine);
    }

    public void testReturnValueIsNull() throws Exception {
        assertNull(parser.parse("MinLengths"));
    }

    public void testValidUseCase_01() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("MinLength");
        assertEquals("MinLength", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(9, offsetRange.getEnd());
            assertEquals("MinLength", value);
        }
    }

    public void testValidUseCase_02() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("MinLength   ");
        assertEquals("MinLength", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(9, offsetRange.getEnd());
            assertEquals("MinLength", value);
        }
    }

    public void testValidUseCase_03() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("MinLength\t\t  ");
        assertEquals("MinLength", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(9, offsetRange.getEnd());
            assertEquals("MinLength", value);
        }
    }

    public void testValidUseCase_04() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("MinLength(message=\"msg\", limit = 3)");
        assertEquals("MinLength", parsedLine.getName());
        assertEquals("(message=\"msg\", limit = 3)", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(9, offsetRange.getEnd());
            assertEquals("MinLength", value);
        }
    }

    public void testValidUseCase_05() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("Annotations\\MinLength(message=\"msg\", limit = 3)  \t");
        assertEquals("MinLength", parsedLine.getName());
        assertEquals("(message=\"msg\", limit = 3)", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(21, offsetRange.getEnd());
            assertEquals("Annotations\\MinLength", value);
        }
    }

    public void testValidUseCase_06() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("\\Foo\\Bar\\MinLength(message=\"msg\", limit = 3)  \t");
        assertEquals("MinLength", parsedLine.getName());
        assertEquals("(message=\"msg\", limit = 3)", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(18, offsetRange.getEnd());
            assertEquals("\\Foo\\Bar\\MinLength", value);
        }
    }

}
