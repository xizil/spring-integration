/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.StringReader;

import org.junit.Test;

import org.springframework.integration.core.Message;

/**
 * @author Mark Fisher
 */
public class CharacterStreamSourceTests {

	@Test
	public void testEndOfStream() {
		StringReader reader = new StringReader("test");
		CharacterStreamReadingMessageSource source = new CharacterStreamReadingMessageSource(reader);
		Message<?> message1 = source.receive();
		assertEquals("test", message1.getPayload());
		Message<?> message2 = source.receive();
		assertNull(message2);
	}

}
