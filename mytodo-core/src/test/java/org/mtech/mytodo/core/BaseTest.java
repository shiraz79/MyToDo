package org.mtech.mytodo.core;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb3.EJBContainer;
import org.junit.BeforeClass;

public class BaseTest {

	static Context ctx = null;
	@BeforeClass
	public static void setUp() throws NamingException {
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs",
				"org.jboss.naming.client");
		properties.put("java.naming.provider.url", "jnp://localhost:1099");
		ctx = new InitialContext(properties);
	}

}
