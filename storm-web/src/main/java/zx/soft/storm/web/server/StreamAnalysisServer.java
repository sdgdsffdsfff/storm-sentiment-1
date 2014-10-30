package zx.soft.storm.web.server;

import java.util.Properties;

import org.restlet.Component;
import org.restlet.data.Protocol;

import zx.soft.storm.web.application.StreamAnslysisApplication;
import zx.soft.storm.web.utils.ConfigUtil;

/**
 *流数据分析入口类
 *  示例：
 *     http://localhost:8900/stream/wordcount
 *     POST: [ "测试数据1", "测试数据2" ]
 *     
 * curl --data '[" 我是中国人","我在学中文 "]' -H 'Content-Type:application/json' http://localhost:8900/stream/wordcount
 * @author frank
 *
 */
public class StreamAnalysisServer {
	private final Component component;
	private final StreamAnslysisApplication siteApplication;
	private final int PORT;

	public StreamAnalysisServer() {
		Properties props = ConfigUtil.getProps("web-server.properties");
		PORT = Integer.parseInt(props.getProperty("api.port"));
		component = new Component();
		siteApplication = new StreamAnslysisApplication();
	}

	public static void main(final String[] args) {
		StreamAnalysisServer server = new StreamAnalysisServer();
		server.start();
	}

	public void start() {
		component.getServers().add(Protocol.HTTP, PORT);
		try {
			component.getDefaultHost().attach("/stream", siteApplication);
			component.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
