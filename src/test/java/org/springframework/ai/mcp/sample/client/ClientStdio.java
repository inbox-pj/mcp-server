package org.springframework.ai.mcp.sample.client;

import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;

import java.io.File;

public class ClientStdio {

	public static void main(String[] args) {

		System.out.println(new File(".").getAbsolutePath());
		
		var stdioParams = ServerParameters.builder("java")
				.args("-Dspring.ai.mcp.server.stdio=true", "-Dspring.main.web-application-type=none",
						"-Dlogging.pattern.console=", "-jar",
						"/Users/pjaiswal/CardConnect/Repository/Others/mcp-server/target/mcp-server-0.0.1-SNAPSHOT.jar")
				.build();

		var transport = new StdioClientTransport(stdioParams);

		new SampleClient(transport).run();
	}

}
