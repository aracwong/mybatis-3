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

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author MetaYoo
 */
public interface MyTestMapper {

  @Select("select ad_name from advt_ad where id=#{id} ")
  String getByName(Long id);

  @Select("select ad_name from advt_ad")
  List<String> getByNameByPage(Long id, RowBounds rowBounds);

  @Select("select id, ad_no, ad_name from advt_ad")
//  @ResultType(AdvtAd.class)
  @Results(id = "advtAdResutMap", value = {
    @Result(property = "id", column = "id", id = true),
    @Result(property = "adNo", column = "ad_no"),
    @Result(property = "adName", column = "ad_name"),
  })
  List<AdvtAd> queryListByPage(Long id, RowBounds rowBounds);

  @Insert("insert into advt_ad(`ad_no`, `ad_name`) values(#{adNo}, #{adName})")
  Integer save(@Param("adNo") String adNo, @Param("adName") String adName);

  @Update("update advt_ad set ad_name = #{adName} where id=#{id}")
  Integer update(@Param("id") Long id, @Param("adName") String adName);

}
