/*
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * @author MetaYoo
 */
public class JdbcTest {

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private Connection connection;

  @Before
  public void startUp() {
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @After
  public void shutDown() throws Exception {
    connection.close();
  }

  @Test
  public void test_query() throws Exception {
    PreparedStatement preparedStatement = connection.prepareStatement("select * from advt_ad");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      System.out.print(resultSet.getString(1) + " ");
      System.out.print(resultSet.getString(2) + " ");
      System.out.print(resultSet.getString(3) + " ");
      System.out.println();
    }
    preparedStatement.close();
  }

  @Test
  public void test_execute() throws Exception {
    long start = System.currentTimeMillis();
    PreparedStatement preparedStatement = connection.prepareStatement("select * from advt_ad");
    preparedStatement.setFetchSize(20009);
    System.out.println("preparedStatement.getQueryTimeout():" + preparedStatement.getQueryTimeout());
    System.out.println("preparedStatement.getFetchSize():" + preparedStatement.getFetchSize());
    System.out.println("preparedStatement.getFetchDirection():" + preparedStatement.getFetchDirection());
    System.out.println("preparedStatement.getMaxFieldSize():" + preparedStatement.getMaxFieldSize());
    preparedStatement.execute();
    ResultSet resultSet = preparedStatement.getResultSet();
    int col = resultSet.getMetaData().getColumnCount();
    int total = 0;
    while (resultSet.next()) {
//      for (int i = 1; i <= col; i++) {
//        System.out.print(resultSet.getObject(i) + " ");
//      }
//      System.out.println("");
      total++;
    }
    long endTime = System.currentTimeMillis();
    System.out.println(total + " " + (endTime - start));
    preparedStatement.close();
  }


}
