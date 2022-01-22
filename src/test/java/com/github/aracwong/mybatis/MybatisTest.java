package com.github.aracwong.mybatis;
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
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

/**
 * @author MetaYoo
 */
public class MybatisTest {

  @Test
  public void test_mybatis() {
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test", "root", "123456");
    Environment env = new Environment("dev", transactionFactory, dataSource);
    Configuration config = new Configuration(env);
    config.addMapper(MyTestMapper.class);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    MyTestMapper mapper = sqlSession.getMapper(MyTestMapper.class);
    String name = mapper.getName(1L);
    System.out.println(name);
    sqlSession.close();
  }
}
