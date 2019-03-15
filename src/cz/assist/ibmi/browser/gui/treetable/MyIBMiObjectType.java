package cz.assist.ibmi.browser.gui.treetable;

import org.apache.log4j.Logger;

/**
 * 
 * @author milos.tygl
 *
 */
public class MyIBMiObjectType {

	private static final Logger LOGGER = Logger.getLogger(MyIBMiObjectType.class);

	private final String name;

	public static final MyIBMiObjectType Type = new MyIBMiObjectType("*TYPE");
	public static final MyIBMiObjectType Library = new MyIBMiObjectType("*LIB");
	public static final MyIBMiObjectType File = new MyIBMiObjectType("*FILE");
	public static final MyIBMiObjectType Member = new MyIBMiObjectType("*MBR");
	public static final MyIBMiObjectType Program = new MyIBMiObjectType("*PGM");
	public static final MyIBMiObjectType Directory = new MyIBMiObjectType("*DIR");
	public static final MyIBMiObjectType StreamFile = new MyIBMiObjectType("*STMF");

	/**
	 *
	 * @param name
	 */
	public MyIBMiObjectType(String name) {
		
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
		final MyIBMiObjectType other = (MyIBMiObjectType) obj;
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
