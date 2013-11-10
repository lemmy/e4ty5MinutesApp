package impl;

import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;

import api.ContentService;

public class Component implements ContentService {

	@Override
	public String getSlideContent() {
		String version = FrameworkUtil.getBundle(getClass()).getHeaders()
				.get(Constants.BUNDLE_VERSION);
		return "Content coming from bundle with version: " + version;
	}

}
