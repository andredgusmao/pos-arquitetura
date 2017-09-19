package br.com.pucminas.arquitetura.camel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;

public class ServicosPedidos extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("servlet:cursos?matchOnUriPrefix=true").
			log("${id}\n${body}").
			streamCaching().
//			setProperty("pedidoId", xpath("/pedido/id/text()")).
//			setProperty("clienteId", xpath("/pedido/pagamento/email-titular/text()")).
//			split().
//				xpath("/pedido/itens/item").
//			filter().
//				xpath("/item/formato[text()='EBOOK']").
//			setProperty("ebookId", xpath("/item/livro/codigo/text()")).
//			marshal().
//			xmljson().
//			string("UTF-8").
//			to("http4://localhost:8080/webservices/ebook/item?bridgeEndpoint=true");
			to("http4://localhost:8881/cursos?bridgeEndpoint=true");
		
		from("file:pedidos?delay=5s&noop=true").
			routeId("rota-pedidos").
			multicast().
				to("direct:soap").
				to("direct:http");
		
		from("direct:http").
			routeId("rota-http").
			setProperty("pedidoId", xpath("/pedido/id/text()")).
			setProperty("clienteId", xpath("/pedido/pagamento/email-titular/text()")).
			split().
				xpath("/pedido/itens/item").
			filter().
				xpath("/item/formato[text()='EBOOK']").
			setProperty("ebookId", xpath("/item/livro/codigo/text()")).
			marshal().xmljson().
			//log("${id} - ${body}").
//			setHeader(Exchange.HTTP_METHOD, HttpMethods.GET).
//			setHeader(Exchange.HTTP_QUERY,simple("ebookId=${property.ebookId}&pedidoId=${property.pedidoId}&clienteId=${property.clienteId}")).
		to("http4://localhost:8080/webservices/ebook/item");
		
		from("direct:soap").
			routeId("rota-soap").
			to("xslt:pedido-para-soap.xslt").
			log("${body}").
			setHeader(Exchange.CONTENT_TYPE,constant("text/xml")).
			setHeader(Exchange.HTTP_METHOD, HttpMethods.POST).
		to("http4://localhost:8080/webservices/financeiro");
	}

}
