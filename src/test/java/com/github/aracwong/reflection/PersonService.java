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

/**
 * @author MetaYoo
 */
public class PersonService extends HumanService {

  private String name;

  @Override
  public String eat(String food) {
    return null;
  }

  @Override
  public String say(String word) {
    return null;
  }

  public String getName() {
    return name;
  }

  @Override
  public String isName() {
    return null;
  }
}
