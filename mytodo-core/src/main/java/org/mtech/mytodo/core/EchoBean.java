package org.mtech.mytodo.core;

import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote (value={Echo.class})
public class EchoBean implements Echo{

	
	/* (non-Javadoc)
	 * @see org.mtech.mytodo.core.Echo#sayHi(java.lang.String)
	 */
	@Override
	public String sayHi(String s) {
		return "Hi "+s+"!!!";
		
	}

	/* (non-Javadoc)
	 * @see org.mtech.mytodo.core.Echo#asyncNumberGeneration()
	 */
	@Override
	@Asynchronous
	public void asyncNumberGeneration() {
		System.out.println("generating numbers....");
		for (int i = 0; i < 1000; i++) {
			System.out.println("the number= "+ i+1*Math.random());
		}
		System.out.println("generation completed, hurray!!!");
	}
	
	
	
}
