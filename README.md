# Spring AI MCP Server Sample

#### STDIO Transport

1. Create a `mcp-servers-config.json` configuration file:

```json
{
  "mcpServers": {
    "mcp-server": {
      "command": "java",
      "args": [
        "-Dspring.ai.mcp.server.stdio=true",
        "-Dspring.main.web-application-type=none",
        "-Dlogging.pattern.console=",
        "-jar",
        "/Users/pjaiswal/CardConnect/Repository/Others/mcp-server/target/mcp-server-0.0.1-SNAPSHOT.jar"
      ]
    }
  }
}
```

2. Run the client using the configuration file:

```bash
java -Dspring.ai.mcp.client.stdio.servers-configuration=file:mcp-servers-config.json \
 -Dai.user.input='What is the weather in NY?' \
 -Dlogging.pattern.console= \
 -jar mcp-starter-default-client-0.0.1-SNAPSHOT.jar
```

#### SSE (WebMVC) Transport

1. Start the MCP annotations server:

```bash
java -jar mcp-annotations-server-0.0.1-SNAPSHOT.jar
```

2. In another console, start the client configured with SSE transport:

```bash
java -Dspring.ai.mcp.client.sse.connections.annotations-server.url=http://localhost:8080 \
 -Dlogging.pattern.console= \
 -Dai.user.input='What is the weather in NY?' \
 -jar mcp-starter-default-client-0.0.1-SNAPSHOT.jar
```
