package org.springframework.ai.mcp.sample.client;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ListToolsResult;

import java.util.Map;

public class SampleClient {

	private final McpClientTransport transport;

	public SampleClient(McpClientTransport transport) {
		this.transport = transport;
	}

	public void run() {

		var client = McpClient.sync(this.transport)
				.loggingConsumer(message -> {
					System.out.println(">> Client Logging: " + message);
				})
				.build();

		client.initialize();

		client.ping();

		// List and demonstrate tools
		ListToolsResult toolsList = client.listTools();
		System.out.println("Available Tools = " + toolsList);
		toolsList.tools().stream().forEach(tool -> {
			System.out.println("Tool: " + tool.name() + ", description: " + tool.description() + ", schema: "
					+ tool.inputSchema());
		});

		CallToolResult weatherForcastResult = client.callTool(new CallToolRequest("getWeatherForecastByLocation",
				Map.of("latitude", "47.6062", "longitude", "-122.3321")));
		System.out.println("Weather Forcast: " + weatherForcastResult);

		client.closeGracefully();

	}

}
