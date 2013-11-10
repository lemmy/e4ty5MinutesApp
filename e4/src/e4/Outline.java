package e4;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class Outline {
	
	@PostConstruct
	public void postConstruct(Composite parent, Speaker speaker) {
		
		Group grpOutline = new Group(parent, SWT.NONE);
		grpOutline.setText("Outline for speaker: " + speaker.getName());
		grpOutline.setLayout(new FillLayout(SWT.VERTICAL));
		
		Button btnFirstPart = new Button(grpOutline, SWT.CHECK);
		btnFirstPart.setText("First part");
		
		new Label(grpOutline, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		final Button btnSecondPart = new Button(grpOutline, SWT.CHECK);
		btnSecondPart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(btnSecondPart.getText());
			}
		});
		btnSecondPart.setText("Second part");
	}
}