package com.github.aracwong.mybatis.demo3;
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

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MetaYoo
 */
public class UserResultHandler implements ResultHandler<User> {

  private final List<User> list;

  public UserResultHandler() {
    list = new ArrayList<>();
  }

  @Override
  public void handleResult(ResultContext<? extends User> resultContext) {
    list.add(resultContext.getResultObject());
  }

  public List<User> getResultList() {
    return list;
  }
}
