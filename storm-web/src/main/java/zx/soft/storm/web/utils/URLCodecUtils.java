package zx.soft.storm.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLCodecUtils {

	public static String decoder(final String url, final String codec) {
		try {
			String result = URLDecoder.decode(url, codec);
			return result;
		} catch (UnsupportedEncodingException e) {
			return url;
		}
	}

}
