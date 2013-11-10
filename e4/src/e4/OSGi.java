package e4;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import api.ContentService;

public class OSGi {
	
	private Label label;
	
	@Inject
	private UISynchronize sync;

	@PostConstruct
	public void postConstruct(Composite parent) {
		label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		label.setText("No content set");
	}
	
	@Inject
	@Optional
	private void setContent(@Optional final ContentService cs) {
		sync.asyncExec(new Runnable() {
			@Override
			public void run() {
				if (label.isDisposed()) {
					return;
				}
				if (cs == null) {
					label.setText("Content gone");
				} else {
					label.setText(cs.getSlideContent());
				}
			}
		});
	}
}