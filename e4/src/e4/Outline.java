package e4;

import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class Outline {
	
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
				new Label(grpOutline, SWT.SEPARATOR | SWT.HORIZONTAL);
			}
		}
	}
}