package br.com.pucminas.arquitetura.camel;

import org.apache.camel.builder.RouteBuilder;

public class UniArqRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("servlet:grade?matchOnUriPrefix=true").
		log("${id}\n${body}").
		streamCaching().
		to("http4://localhost:8884/grade?bridgeEndpoint=true");
	}

}
