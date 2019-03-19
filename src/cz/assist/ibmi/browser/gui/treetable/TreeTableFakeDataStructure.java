package cz.assist.ibmi.browser.gui.treetable;

import org.apache.log4j.Logger;

import javafx.scene.control.TreeItem;

/**
 * 
 * @author milos.tygl
 *
 */
public class TreeTableFakeDataStructure {

	private static final Logger LOGGER = Logger.getLogger(TreeTableFakeDataStructure.class);

	final TreeItem<MyTreeTableDataNode> root;

	/**
	 * 
	 */
	TreeTableFakeDataStructure() {

		LOGGER.debug("begin");

		root = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("[root]", null, null, null, null));

		LOGGER.debug("end");

	}

	/**
	 * 
	 * @return
	 */
	public TreeItem<MyTreeTableDataNode> generateFullDataStructure() {

		LOGGER.debug("begin");

		final TreeItem<MyTreeTableDataNode> item1 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("QSYS.LIB", "*LIB", "PROD", "System Library", "/QSYS.LIB"));
		root.getChildren().add(item1);

		final TreeItem<MyTreeTableDataNode> item1sub1 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("USER1LIB.LIB", "*LIB", "PROD", "USER1 Current Library", "/QSYS.LIB/USER1LIB.LIB"));
		item1.getChildren().add(item1sub1);

		final TreeItem<MyTreeTableDataNode> item1sub1sub1 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("QCLSRC.FILE", "*FILE", "PF", "CL Sources", "/QSYS.LIB/USER1LIB.LIB/QCLSRC.FILE"));
		item1sub1.getChildren().add(item1sub1sub1);

		final TreeItem<MyTreeTableDataNode> item1sub1sub1sub1 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("TEST1.MBR", "*MBR", "CLP", "CL Program Example 1", "/QSYS.LIB/USER1LIB.LIB/QCLSRC.FILE/TEST1.MBR"));
		item1sub1sub1.getChildren().add(item1sub1sub1sub1);

		final TreeItem<MyTreeTableDataNode> item1sub1sub1sub2 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("TEST2.MBR", "*MBR", "CLP", "CL Program Example 2", "/QSYS.LIB/USER1LIB.LIB/QCLSRC.FILE/TEST2.MBR"));
		item1sub1sub1.getChildren().add(item1sub1sub1sub2);

		final TreeItem<MyTreeTableDataNode> item1sub1sub2 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("TEST1.PGM", "*PGM", "CLP", "CL Program Example 1", "/QSYS.LIB/USER1LIB.LIB/TEST1.PGM"));
		item1sub1.getChildren().add(item1sub1sub2);

		final TreeItem<MyTreeTableDataNode> item1sub1sub3 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("TEST2.PGM", "*PGM", "CLP", "CL Program Example 2", "/QSYS.LIB/USER1LIB.LIB/TEST2.PGM"));
		item1sub1.getChildren().add(item1sub1sub3);

		final TreeItem<MyTreeTableDataNode> item1sub2 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("USER2LIB.LIB", "*LIB", "PROD", "USER2 Current Library", "/QSYS.LIB/USER2LIB.LIB"));
		item1.getChildren().add(item1sub2);

		final TreeItem<MyTreeTableDataNode> item1sub3 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("USER3LIB.LIB", "*LIB", "PROD", "USER3 Current Library", "/QSYS.LIB/USER3LIB.LIB"));
		item1.getChildren().add(item1sub3);

		final TreeItem<MyTreeTableDataNode> item1sub4 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("USER4LIB.LIB", "*LIB", "PROD", "USER4 Current Library", "/QSYS.LIB/USER4LIB.LIB"));
		item1.getChildren().add(item1sub4);

		final TreeItem<MyTreeTableDataNode> item1sub5 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("USER5LIB.LIB", "*LIB", "PROD", "USER5 Current Library", "/QSYS.LIB/USER5LIB.LIB"));
		item1.getChildren().add(item1sub5);

		final TreeItem<MyTreeTableDataNode> item2 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("QOpenSys", null, null, null, "/QOpenSys"));
		root.getChildren().add(item2);

		final TreeItem<MyTreeTableDataNode> item2sub1 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("home", null, null, null, "/QOpenSys/home"));
		item2.getChildren().add(item2sub1);

		final TreeItem<MyTreeTableDataNode> item2sub1sub1 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("user1", null, null, null, "/QOpenSys/home/user1"));
		item2sub1.getChildren().add(item2sub1sub1);

		final TreeItem<MyTreeTableDataNode> item2sub1sub2 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("user2", null, null, null, "/QOpenSys/home/user2"));
		item2sub1.getChildren().add(item2sub1sub2);

		final TreeItem<MyTreeTableDataNode> item2sub1sub3 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("user3", null, null, null, "/QOpenSys/home/user3"));
		item2sub1.getChildren().add(item2sub1sub3);

		final TreeItem<MyTreeTableDataNode> item2sub2 = new TreeItem<MyTreeTableDataNode>(new MyTreeTableDataNode("opt", null, null, null, "/QOpenSys/opt"));
		item2.getChildren().add(item2sub2);

		LOGGER.debug("end");

		return root;
	}

}
