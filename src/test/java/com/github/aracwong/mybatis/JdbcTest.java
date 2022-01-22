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

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author MetaYoo
 */
public class JdbcTest {

  @Test
  public void test_jdbc() throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
    PreparedStatement preparedStatement = connection.prepareStatement("select * from advt_ad");

    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      System.out.print(resultSet.getString(1) + " " );
      System.out.print(resultSet.getString(2) + " " );
      System.out.print(resultSet.getString(3) + " " );
      System.out.println();
    }
    preparedStatement.close();
    connection.close();
  }

}
