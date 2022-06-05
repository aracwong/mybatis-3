package com.github.aracwong.mybatis.cache;
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

import org.apache.ibatis.cache.decorators.BlockingCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.junit.Test;

/**
 * @author MetaYoo
 */
public class BlockingCacheTest {

  @Test
  public void test_blockingCache() {
    BlockingCache blockingCache = new BlockingCache(new PerpetualCache("user"));

    //System.out.println(blockingCache.getObject("1"));
    blockingCache.putObject("1", "user1");

    System.out.println(blockingCache.getObject("1"));

  }
}
