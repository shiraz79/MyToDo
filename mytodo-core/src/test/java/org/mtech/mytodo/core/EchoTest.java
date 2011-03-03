package org.mtech.mytodo.core;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class EchoTest {
	
	static Echo echo = null;
		
	@BeforeClass
	public static void setup() throws NamingException{
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs","org.jboss.naming.client");
		properties.put("java.naming.provider.url","jnp://localhost:1099");
		Context context = new InitialContext(properties);
		
		// lookup the counter bean
		echo = (Echo) context.lookup("EchoBean/remote");
	}

	@Test
	public void sayHello() throws NamingException {
		
		System.out.println(echo);
		System.out.println(echo.sayHi("sss"));		
		
	}
	
//	@Ignore
	@Test
	public void generateAsyncNumbers(){
		echo.asyncNumberGeneration();
	}
	
}
