package e4;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.renderers.swt.SWTPartRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class BrowserRenderer extends SWTPartRenderer {
	@Override
	public Object createWidget(MUIElement element, Object parent) {
		Composite mapComposite = new Composite((Composite) parent, SWT.NONE);
		String tag = element.getTags().get(0);
		try {
			URL url = new URL(tag);
			mapComposite.setLayout(new GridLayout(1, false));
			Browser browser = new Browser(mapComposite, SWT.NONE);
			browser.setUrl(url.toExternalForm());
			browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			return mapComposite;
		} catch (MalformedURLException doesNotHappen) {
			doesNotHappen.printStackTrace();
		}
		return mapComposite;
	}
} 