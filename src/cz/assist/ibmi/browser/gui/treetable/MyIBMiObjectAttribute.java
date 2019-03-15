package cz.assist.ibmi.browser.gui.treetable;

import org.apache.log4j.Logger;

/**
 * 
 * @author milos.tygl
 *
 */
public class MyIBMiObjectAttribute {

	private static final Logger LOGGER = Logger.getLogger(MyIBMiObjectAttribute.class);

	private final String name;

	public static final MyIBMiObjectAttribute Attribute = new MyIBMiObjectAttribute("ATTR");
	public static final MyIBMiObjectAttribute PF = new MyIBMiObjectAttribute("PF");
	public static final MyIBMiObjectAttribute LF = new MyIBMiObjectAttribute("LF");
	public static final MyIBMiObjectAttribute PF_DTA = new MyIBMiObjectAttribute("PF-DTA");

	/**
	 *
	 * @param name
	 */
	public MyIBMiObjectAttribute(String name) {
		
		LOGGER.debug("name: " + name);
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this.name == null) {
			return false;
		}
		final MyIBMiObjectAttribute other = (MyIBMiObjectAttribute) obj;
		if (other.name == null) {
			return false;
		}
		if (this.name.compareTo(other.name) == 0) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
		return hash;
	}
}
