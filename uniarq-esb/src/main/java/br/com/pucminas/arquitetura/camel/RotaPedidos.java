package br.com.pucminas.arquitetura.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new UniArqRoutes());		

		context.start();
//		Thread.sleep(20000);
//		context.stop();
	}	
}
