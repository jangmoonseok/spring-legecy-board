package com.basic.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.springframework.stereotype.Component;

public class MybatisSqlSessionFactory implements SqlSessionFactory{
	private SqlSessionFactory sessionFactory;
	
	{
		String config = "com/basic/board/config/sqlSessionConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(config);
			
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
			System.out.println("Factory积己 己傍");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Factory积己 角菩");
			e.printStackTrace();
		}
	}
	
	@Override
	public SqlSession openSession() {
		return sessionFactory.openSession(true);
	}

	@Override
	public SqlSession openSession(boolean autoCommit) {
		return sessionFactory.openSession(autoCommit);
	}

	@Override
	public SqlSession openSession(Connection connection) {
		return sessionFactory.openSession(connection);
	}

	@Override
	public SqlSession openSession(TransactionIsolationLevel level) {
		return sessionFactory.openSession(level);
	}

	@Override
	public SqlSession openSession(ExecutorType execType) {
		return sessionFactory.openSession(execType);
	}

	@Override
	public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
		return sessionFactory.openSession(execType, autoCommit);
	}

	@Override
	public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
		return sessionFactory.openSession(execType, level);
	}

	@Override
	public SqlSession openSession(ExecutorType execType, Connection connection) {
		return sessionFactory.openSession(execType, connection);
	}

	@Override
	public Configuration getConfiguration() {
		return sessionFactory.getConfiguration();
	}

}
