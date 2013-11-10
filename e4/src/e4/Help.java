package e4;

import javax.annotation.PostConstruct;

import org.eclipse.nebula.widgets.geomap.GeoMap;
import org.eclipse.nebula.widgets.geomap.PointD;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class Help {
	private static final PointD HAMBURG = new PointD(9.7430, 53.5972);

	@PostConstruct 	
	public void main(Composite parent) {
		parent.setLayout(new FillLayout()); 

		GeoMap geoMap = new GeoMap(parent, SWT.NONE);
        geoMap.setCenterPosition(geoMap.computePosition(HAMBURG));
        geoMap.redraw();
	}
}