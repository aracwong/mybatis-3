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

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author MetaYoo
 */
public class ObjectFactoryTest {

  @Test
  public void test_demo1() {
    ObjectFactory objectFactory = new DefaultObjectFactory();
    List list = objectFactory.create(List.class);
    list.add("123");
    System.out.println(list);

    Map map = objectFactory.create(Map.class);
    map.put("key1", "v1");
    System.out.println(map);
  }
}
