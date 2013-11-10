package e4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class Outline {
	
	private final Map<MPart, Button> buttons = new HashMap<MPart, Button>();

	@PostConstruct
	public void postConstruct(Composite parent, Speaker speaker, EModelService ems, MApplication mApp) {
		
		Group grpOutline = new Group(parent, SWT.NONE);
		grpOutline.setText("Outline for speaker: " + speaker.getName());
		grpOutline.setLayout(new FillLayout(SWT.VERTICAL));
		
		List<MPart> elements = ems.findElements(mApp, null, MPart.class, null);
		for (MPart mPart : elements) {
			if (mPart.getParent().getParent().isToBeRendered()) {
				Button btnFirstPart = new Button(grpOutline, SWT.CHECK);
				btnFirstPart.setText(mPart.getLabel() == null ? "" : mPart.getLabel());
				buttons .put(mPart, btnFirstPart);
				new Label(grpOutline, SWT.SEPARATOR | SWT.HORIZONTAL);
			}
		}
	}
	
	@Inject
	@Optional
	private void updateButtons(
			@UIEventTopic(UIEvents.UILifeCycle.BRINGTOTOP) org.osgi.service.event.Event e) {
		final Object key = e.getProperty(UIEvents.EventTags.ELEMENT);
		if (buttons.containsKey(key)) {
			buttons.get(key).setSelection(true);
		}
	}
}