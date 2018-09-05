package tripleprice.aggregator.thrift.handler;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tripleprice.aggregator.thrift.CrossPlatformService;

/**
 * https://www.baeldung.com/apache-thrift
 * @author root
 * 
 * How to run
 * 1. Go to directory tripleprice-aggregator-thrift
 * 2. mvn clean install spring-boot:run -DskipTests
 * 3. check the port 9009, netstat -tulpn | grep LISTEN
 * 4. This module be able running standalone
 */
@Configuration
public class CrossPlatformServiceServer {
	TSimpleServer server;

	@Bean
	public boolean start() throws TTransportException {
		TServerTransport serverTransport = new TServerSocket(9090);
		server = new TSimpleServer(new TServer.Args(serverTransport)
				.processor(new CrossPlatformService.Processor<>(new CrossPlatformServiceImpl())));

		System.out.print("Starting the server... ");
		server.serve();
		System.out.println("done.");
		return true;
	}

	@Bean
	public boolean stop() {
		if (server != null && server.isServing()) {
			System.out.print("Stopping the server... ");
			server.stop();
			System.out.println("done.");
		}
		return true;
	}
}
