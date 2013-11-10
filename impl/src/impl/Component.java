package impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import api.ContentService;

public class Component implements ContentService {

	@Override
	public String getSlideContent() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		
		String version = bundle.getHeaders()
				.get(Constants.BUNDLE_VERSION);
		String msg = "Content coming from bundle with version: " + version;
		
		ServiceReference<?>[] registeredServices = bundle.getRegisteredServices();
		if(registeredServices != null) {
			for (int i = 0; i < registeredServices.length; i++) {
				Bundle[] usingBundles = registeredServices[i].getUsingBundles();
				if (usingBundles != null) {
					msg += registeredServices[i].toString() + " used by: ";
					for (int j = 0; j < usingBundles.length; j++) {
						Bundle b = usingBundles[j];
						msg += "\n" + b.getSymbolicName();
					}
				}
			}
		}
		
		return msg;
	}

}
