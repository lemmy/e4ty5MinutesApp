package e4;

import java.net.URL;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.FrameworkUtil;

public class ImageAddon {
	@Inject
	void unhookListeners(IEclipseContext ctx) {
		URL entry = FrameworkUtil.getBundle(getClass()).getEntry("images/di.png");
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(entry);
		Image image = imageDescriptor.createImage();
		ctx.set("DI_ROXXS", image);
	}
}