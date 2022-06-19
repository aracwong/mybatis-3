package com.github.aracwong.mybatis.demo2;
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

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MetaYoo
 */
public class MybatisTest {

  SqlSession sqlSession;

  @Before
  public void startUp() {
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder
      .build(MybatisTest.class.getClassLoader().getResourceAsStream("com/github/aracwong/mybatis/demo2/mybatis-config.xml"));
    sqlSession = sessionFactory.openSession();
  }

  @After
  public void shutDown() {
    sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void test_parse() {
    TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
    Map<String, Object> parameterMap = new HashMap<>();
    parameterMap.put("name", "test");
    testMapper.testInsert(parameterMap);
  }

  @Test
  public void test_select() {
    TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
    List<Map<String, Object>> result = testMapper.testSelect();
    System.out.println(result);
  }
  @Test
  public void test_selectById() {
    TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
    Map<String, Object> result = testMapper.testSelectById(1L);
    System.out.println(result);
  }
}
