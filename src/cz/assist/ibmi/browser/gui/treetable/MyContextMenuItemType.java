package cz.assist.ibmi.browser.gui.treetable;

import org.apache.log4j.Logger;

/**
 * 
 * @author milos.tygl
 *
 */
public class MyContextMenuItemType {

	private static final Logger LOGGER = Logger.getLogger(MyContextMenuItemType.class);

	private final String name;

	public static final MyContextMenuItemType Expand = new MyContextMenuItemType("Expand");
	public static final MyContextMenuItemType Refresh = new MyContextMenuItemType("Refresh");
	public static final MyContextMenuItemType DisplayDescription = new MyContextMenuItemType("Display Description");
	public static final MyContextMenuItemType View = new MyContextMenuItemType("View");
	public static final MyContextMenuItemType Edit = new MyContextMenuItemType("Edit");
	public static final MyContextMenuItemType Run = new MyContextMenuItemType("Run");
	public static final MyContextMenuItemType Delete = new MyContextMenuItemType("Delete");
	public static final MyContextMenuItemType ClearLibrary = new MyContextMenuItemType("Clear Library");

	/**
	 *
	 * @param name
	 */
	public MyContextMenuItemType(String name) {

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
		final MyContextMenuItemType other = (MyContextMenuItemType) obj;
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
