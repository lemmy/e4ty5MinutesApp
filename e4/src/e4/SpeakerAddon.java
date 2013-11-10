 
package e4;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

public class SpeakerAddon {
	@Inject
	void unhookListeners(IEclipseContext ctx) {
		ctx.set(Speaker.class, new Speaker("Markus A. Kuppe"));
	}
}