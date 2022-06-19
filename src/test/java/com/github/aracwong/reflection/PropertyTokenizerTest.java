package com.github.aracwong.reflection;
/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.ibatis.reflection.property.PropertyNamer;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author MetaYoo
 */
public class PropertyTokenizerTest {

  @Test
  public void test_propertyTokenizer() {
    PropertyTokenizer tokenizer = new PropertyTokenizer("user[name]");
    Assert.assertEquals("user", tokenizer.getName());
    Assert.assertEquals("name", tokenizer.getIndex());

    tokenizer = new PropertyTokenizer("user.post[title]");
    Assert.assertEquals("user", tokenizer.getName());
    Assert.assertNull(tokenizer.getIndex());
    Assert.assertEquals("user", tokenizer.getIndexedName());
    Assert.assertTrue(tokenizer.hasNext());

    Assert.assertEquals("post[title]", tokenizer.getChildren());

  }

  @Test
  public void test_propertyNamer() {
    String isA = PropertyNamer.methodToProperty("isA");
    Assert.assertEquals("a", isA);

    String isOk = PropertyNamer.methodToProperty("isOk");
    Assert.assertEquals("ok", isOk);

    boolean getBook = PropertyNamer.isProperty("getBook");
    Assert.assertTrue(getBook);
    boolean setBook = PropertyNamer.isProperty("setBook");
    Assert.assertTrue(setBook);

  }
}
