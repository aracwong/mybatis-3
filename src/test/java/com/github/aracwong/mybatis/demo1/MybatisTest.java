package com.github.aracwong.mybatis.demo1;
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

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author MetaYoo
 */
public class MybatisTest {

  private SqlSessionFactory sqlSessionFactory;

  @BeforeEach
  public void startUp() {
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test", "root", "123456");
    Environment env = new Environment("dev", transactionFactory, dataSource);
    Configuration config = new Configuration(env);
    config.addInterceptor(new ExamplePlugin());
    config.addMapper(MyTestMapper.class);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
  }

  @AfterEach
  public void afterAll() {

  }

  @Test
  public void test_query() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    MyTestMapper mapper = sqlSession.getMapper(MyTestMapper.class);
    String name = mapper.getByName(1L);
    System.out.println(name);
    sqlSession.close();
  }

  @Test
  public void test_query2() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    MyTestMapper mapper = sqlSession.getMapper(MyTestMapper.class);
    List<String> names = mapper.getByNameByPage(1L, new RowBounds(2,5));
    System.out.println(names);
    sqlSession.close();
  }

  @Test
  public void test_query3() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    MyTestMapper mapper = sqlSession.getMapper(MyTestMapper.class);
    List<AdvtAd> names = mapper.queryListByPage(1L, new RowBounds(2,5));
    System.out.println(names);
    sqlSession.close();
  }

  @Test
  public void test_save() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    MyTestMapper mapper = sqlSession.getMapper(MyTestMapper.class);
    for (int i = 10000; i < 20000; i++) {
      mapper.save("ad_" + i, "计划" + i);
    }
    sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void test_update() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    MyTestMapper mapper = sqlSession.getMapper(MyTestMapper.class);
    mapper.update(1L, "第一个广告");
    sqlSession.commit();
    sqlSession.close();
  }


}
