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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author MetaYoo
 */
public class MapTest {

  @org.junit.Test
  public void test_map() {
    Map<String, Test> map = new HashMap<>();
//    map.put("test", "test_Val");
    // k -> String.toLowerCase
//    map.computeIfAbsent("wzp", String::toUpperCase);
//    System.out.println(map);
//    String wzp = new MyFunction().apply("wzp");
//    map.computeIfAbsent("wzp", test);
    System.out.println(map);
  }

  interface Test extends Function {
    String apply(String s);
  }

  class MyFunction implements Function<String, String> {

    @Override
    public String apply(String s) {
      return s.toUpperCase();
    }
  }
}
