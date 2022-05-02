package com.basic.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
   public static SqlMapClient getsqlMapClient() {
      SqlMapClient smc = null;
      Reader rd = null;
      try {
         Charset charset = Charset.forName("utf-8");
         
         rd = Resources.getResourceAsReader("com/basic/board/config/sqlMapConfig.xml");
         
         if(smc == null) smc = SqlMapClientBuilder.buildSqlMapClient(rd);
         
      } catch (IOException e) {
         e.printStackTrace();
      }finally {
         if(rd!=null)try {rd.close();}catch(IOException e) {};
      }
      return smc;
   }
}


