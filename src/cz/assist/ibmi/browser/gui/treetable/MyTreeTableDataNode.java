package cz.assist.ibmi.browser.gui.treetable;

import org.apache.log4j.Logger;

import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * @author milos.tygl
 *
 */
public class MyTreeTableDataNode {

	private static final Logger LOGGER = Logger.getLogger(MyTreeTableDataNode.class);

	private SimpleStringProperty xNameProperty;
	private SimpleStringProperty xTypeProperty;
	private SimpleStringProperty xAttrProperty;
	private SimpleStringProperty xTextProperty;
	private SimpleStringProperty xPathProperty;

	/**
	 * 
	 * @return
	 */
	public SimpleStringProperty xNameProperty() {
		if (xNameProperty == null) {
			xNameProperty = new SimpleStringProperty(this, "xNameProperty");
		}
		return xNameProperty;
	}

	/**
	 * 
	 * @return
	 */
	public SimpleStringProperty xTypeProperty() {
		if (xTypeProperty == null) {
			xTypeProperty = new SimpleStringProperty(this, "xTypeProperty");
		}
		return xTypeProperty;
	}

	/**
	 * 
	 * @return
	 */
	public SimpleStringProperty xAttrProperty() {
		if (xAttrProperty == null) {
			xAttrProperty = new SimpleStringProperty(this, "xAttrProperty");
		}
		return xAttrProperty;
	}

	/**
	 * 
	 * @return
	 */
	public SimpleStringProperty xTextProperty() {
		if (xTextProperty == null) {
			xTextProperty = new SimpleStringProperty(this, "xTextProperty");
		}
		return xTextProperty;
	}

	/**
	 * 
	 * @return
	 */
	public SimpleStringProperty xPathProperty() {
		if (xPathProperty == null) {
			xPathProperty = new SimpleStringProperty(this, "xPathProperty");
		}
		return xPathProperty;
	}

	/**
	 * 
	 * @param xName
	 * @param xType
	 * @param xAttr
	 * @param xText
	 * @param xPath
	 */
	public MyTreeTableDataNode(String xName, String xType, String xAttr, String xText, String xPath) {
		super();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("xName: ");
		stringBuilder.append(xName);
		stringBuilder.append(", xType: ");
		stringBuilder.append(xType);
		stringBuilder.append(", xAttr: ");
		stringBuilder.append(xAttr);
		stringBuilder.append(", xText: ");
		stringBuilder.append(xText);
		stringBuilder.append(", xPath: ");
		stringBuilder.append(xPath);

		LOGGER.debug(stringBuilder.toString());

		this.xNameProperty = new SimpleStringProperty(xName);
		this.xTypeProperty = new SimpleStringProperty(xType);
		this.xAttrProperty = new SimpleStringProperty(xAttr);
		this.xTextProperty = new SimpleStringProperty(xText);
		this.xPathProperty = new SimpleStringProperty(xPath);
	}

	public String getxName() {
		return xNameProperty.get();
	}

	public void setxName(String xName) {
		this.xNameProperty.set(xName);
	}

	public String getxType() {
		return xTypeProperty.get();
	}

	public void setxType(String xType) {
		this.xTypeProperty.set(xType);
	}

	public String getxAttr() {
		return xAttrProperty.get();
	}

	public void setxAttr(String xAttr) {
		this.xAttrProperty.set(xAttr);
	}

	public String getxText() {
		return xTextProperty.get();
	}

	public void setxText(String xText) {
		this.xTextProperty.set(xText);
	}

	public String getxPath() {
		return xPathProperty.get();
	}

	public void setxPath(String xPath) {
		this.xPathProperty.set(xPath);
	}

}
