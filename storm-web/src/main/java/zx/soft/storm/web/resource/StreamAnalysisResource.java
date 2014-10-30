package zx.soft.storm.web.resource;

import java.util.List;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.storm.web.application.StreamAnslysisApplication;
import zx.soft.storm.web.domain.ErrorResponse;
import zx.soft.storm.web.utils.URLCodecUtils;

public class StreamAnalysisResource extends ServerResource {
	private static Logger logger = LoggerFactory.getLogger(StreamAnalysisResource.class);
	private StreamAnslysisApplication application;

	@Override
	public void doInit() {
		application = (StreamAnslysisApplication) getApplication();
	}

	@Post("json")
	public Object streamData(final List<String> data) {
		logger.info("Request Url: " + URLCodecUtils.decoder(getReference().toString(), "utf-8") + ".");
		application.insertStreamData(data);
		return new ErrorResponse.Builder(0, "ok").build();
	}
}
