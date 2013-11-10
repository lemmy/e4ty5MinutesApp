package e4;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.mihalis.opal.imageSelector.ISItem;
import org.mihalis.opal.imageSelector.ImageSelector;

public class Styling {
	@PostConstruct 	
	public void postConstruct(Composite parent) {
		parent.setLayout(new FillLayout());

        final List<ISItem> items = new LinkedList<ISItem>();
        items.add(new ISItem("Grey", "images/css1.png"));
        items.add(new ISItem("Black", "images/css2.png"));
        items.add(new ISItem("Gradient", "images/css3.png"));
        items.add(new ISItem("Blue", "images/css4.png"));

        final ImageSelector imageSelector = new ImageSelector(parent, SWT.NONE);
        imageSelector.setItems(items);
	}
}