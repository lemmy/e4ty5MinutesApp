package e4;

import org.eclipse.e4.core.di.annotations.Creatable;

@Creatable
public class Speaker {

	private final String name;

	public Speaker() {
		this.name = "Dummy Speaker";
	}

	public String getName() {
		return name;
	}
}
