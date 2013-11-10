 
package e4;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DependencyInjection {
	
	@PostConstruct
	public void postConstruct(Composite parent, @Named("DI_ROXXS") Image image) {
		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		label.setImage(image);
		
	}
}