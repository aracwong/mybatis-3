package com.github.aracwong.property;
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

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author MetaYoo
 */
public class PropertyTokenizerTest {
  @Test
  public void test_propertyTokenizer() {
    PropertyTokenizer propertyTokenizer = new PropertyTokenizer("user[uid].name");
    System.out.println(propertyTokenizer.getName());
    System.out.println(propertyTokenizer.getIndex());
    System.out.println(propertyTokenizer.getIndexedName());
    System.out.println(propertyTokenizer.hasNext());
    System.out.println(propertyTokenizer.getChildren());
  }

  @Test
  public void test_metaObject() {
    User user = new User();
    user.setName("test");
    Address address = new Address();
    address.setCity("sh");
    address.setStreet("dongming");
    user.setAddressList(Arrays.asList(address));
    MetaObject test = MetaObject.forObject(user, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
    System.out.println(test.getValue("addressList[0].city"));
    System.out.println(test.getValue("addressList[0].street"));

  }

  static class User {
    private String name;
    private List<Address> addressList;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public List<Address> getAddressList() {
      return addressList;
    }

    public void setAddressList(List<Address> addressList) {
      this.addressList = addressList;
    }

    @Override
    public String toString() {
      return "User{" +
        "name='" + name + '\'' +
        ", addressList=" + addressList +
        '}';
    }
  }

  static class Address {
     private String city;
     private String street;

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    @Override
    public String toString() {
      return "Address{" +
        "city='" + city + '\'' +
        ", street='" + street + '\'' +
        '}';
    }
  }
}
