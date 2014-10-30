package zx.soft.storm.web.application;

import java.util.List;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import zx.soft.storm.web.resource.StreamAnalysisResource;

public class StreamAnslysisApplication extends Application {
	public StreamAnslysisApplication() {
	}

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/wordcount", StreamAnalysisResource.class);
		return router;
	}

	public void insertStreamData(final List<String> data) {
		for (String d : data) {
			System.out.println(d);
		}
	}

	public void close() {
	}
}
