package e4;

import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.e4.ui.internal.workbench.swt.AbstractPartRenderer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory;

@SuppressWarnings("restriction")
public class MyRendererFactory extends WorkbenchRendererFactory {
	@Override
	public AbstractPartRenderer getRenderer(MUIElement uiElement, Object parent) {
		if (uiElement instanceof MPart) {
			MPart part = (MPart) uiElement;
			for (String tag : part.getTags()) { // could use persistent state
												// instead of tag to identify
												// part
				if (tag.startsWith("http")) {
					try {
						new URL(tag);
						BrowserRenderer br = new BrowserRenderer();
						initRenderer(br);
						return br;
					} catch (MalformedURLException doesNotHappen) {
						doesNotHappen.printStackTrace();
					}
				}
			}
		}
		return super.getRenderer(uiElement, parent);
	}
}