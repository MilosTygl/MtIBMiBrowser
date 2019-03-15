package cz.assist.ibmi.browser.gui.treetable;

/**
 * @see http://stackoverflow.com/questions/42960107/nested-paths-to-javafx-treeview
 */

import org.apache.log4j.Logger;

import cz.assist.ibmi.browser.config.AppConfig;
import cz.assist.ibmi.browser.config.BrowserConfig;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 
 * @author milos.tygl
 *
 */
public class TreeTableViewTest extends Application {

	private static final Logger LOGGER = Logger.getLogger(TreeTableViewTest.class);

	/**
	 * 
	 * @return
	 */
	private TreeTableView<MyTreeTableDataNode> createTreeTableViewFromFakeData() {

		LOGGER.debug("begin");

		final TreeTableFakeDataStructure treeTableFakeDataStructure;
		treeTableFakeDataStructure = new TreeTableFakeDataStructure();

		final TreeItem<MyTreeTableDataNode> root;
		root = treeTableFakeDataStructure.generateFullDataStructure();

		final TreeTableView<MyTreeTableDataNode> tree;
		tree = new TreeTableView<MyTreeTableDataNode>(root);
		tree.setShowRoot(true);

		LOGGER.debug("end");

		return tree;
	}

	/**
	 * 
	 * @return
	 */
	private TreeTableView<MyTreeTableDataNode> createTreeTableViewFromRealData() {

		LOGGER.debug("begin");

		final TreeTableRealDataStructure treeTableRealDataStructure;
		treeTableRealDataStructure = new TreeTableRealDataStructure();

		final TreeItem<MyTreeTableDataNode> root;
		root = treeTableRealDataStructure.generateFullDataStructure();

		final TreeTableView<MyTreeTableDataNode> tree;
		tree = new TreeTableView<MyTreeTableDataNode>(root);
		tree.setShowRoot(true);

		LOGGER.debug("end");

		return tree;
	}

	/**
	 * 
	 * @return
	 */
	private TreeTableColumn<MyTreeTableDataNode, String> declareNameColumn() {

		LOGGER.debug("begin");

		final String columnName = "Name";

		final TreeTableColumn<MyTreeTableDataNode, String> nameColumn;
		nameColumn = new TreeTableColumn<>(columnName);
		nameColumn.setPrefWidth(300);
		nameColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<MyTreeTableDataNode, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getxName()));

		LOGGER.debug("end");

		return nameColumn;
	}

	/**
	 * 
	 * @return
	 */
	private TreeTableColumn<MyTreeTableDataNode, String> declareTypeColumn() {

		LOGGER.debug("begin");

		final String columnName = "Type";

		final TreeTableColumn<MyTreeTableDataNode, String> typeColumn;
		typeColumn = new TreeTableColumn<>(columnName);
		typeColumn.setPrefWidth(100);
		typeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<MyTreeTableDataNode, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getxType()));

		LOGGER.debug("end");

		return typeColumn;
	}

	/**
	 * 
	 * @return
	 */
	private TreeTableColumn<MyTreeTableDataNode, String> declareAttrColumn() {

		LOGGER.debug("begin");

		final String columnName = "Attr";

		final TreeTableColumn<MyTreeTableDataNode, String> attrColumn;
		attrColumn = new TreeTableColumn<>(columnName);
		attrColumn.setPrefWidth(100);
		attrColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<MyTreeTableDataNode, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getxAttr()));

		LOGGER.debug("end");

		return attrColumn;
	}

	/**
	 * 
	 * @return
	 */
	private TreeTableColumn<MyTreeTableDataNode, String> declareTextColumn() {

		LOGGER.debug("begin");

		final String columnName = "Text";

		final TreeTableColumn<MyTreeTableDataNode, String> textColumn;
		textColumn = new TreeTableColumn<>(columnName);
		textColumn.setPrefWidth(300);
		textColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<MyTreeTableDataNode, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getxText()));

		LOGGER.debug("end");

		return textColumn;
	}

	/**
	 * 
	 * @return
	 */
	private TreeTableColumn<MyTreeTableDataNode, String> declarePathColumn() {

		LOGGER.debug("begin");

		final String columnName = "Path";

		final TreeTableColumn<MyTreeTableDataNode, String> pathColumn;
		pathColumn = new TreeTableColumn<>(columnName);
		pathColumn.setPrefWidth(400);
		pathColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<MyTreeTableDataNode, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getxPath()));

		LOGGER.debug("end");

		return pathColumn;
	}

	/**
	 * @param treeTableView
	 */
	private void declareMyColumns(TreeTableView<MyTreeTableDataNode> treeTableView) {

		LOGGER.debug("begin");

		treeTableView.getColumns().add(declareNameColumn());
		treeTableView.getColumns().add(declareTypeColumn());
		treeTableView.getColumns().add(declareAttrColumn());
		treeTableView.getColumns().add(declareTextColumn());
		treeTableView.getColumns().add(declarePathColumn());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemExpand(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | Expand | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemRefresh(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | Refresh | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemViewDescription(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | View Description | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemView(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | View | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemEdit(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | Edit | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemDelete(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | Delete | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemRun(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | Run | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 */
	private void handleContextMenuItemClearLibrary(MyTreeTableDataNode item) {

		LOGGER.debug("begin");

		System.out.println("Context Menu | Clear Library | " + item.getxPath());

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param item
	 * @param cm
	 * @param miExpand
	 * @param miRefresh
	 * @param miViewDescription
	 * @param miView
	 * @param miEdit
	 * @param miDelete
	 * @param miRun
	 * @param miClearLibrary
	 */
	private void setMyContextMenuDependingOnType(MyTreeTableDataNode item, ContextMenu cm, MenuItem miExpand, MenuItem miRefresh, MenuItem miViewDescription, MenuItem miView, MenuItem miEdit, MenuItem miDelete, MenuItem miRun, MenuItem miClearLibrary) {

		LOGGER.debug("begin");

		if (!cm.getItems().isEmpty()) {
			cm.getItems().remove(0, cm.getItems().size());
		}

		if (item.getxType() == null) {
			cm.getItems().add(miExpand);
		} else {
			cm.getItems().add(miRefresh);

			MyIBMiObjectType myIBMiObjectType = new MyIBMiObjectType(item.getxType());
			if (myIBMiObjectType.equals(MyIBMiObjectType.Program)) {
				cm.getItems().add(miRun);
			} else if (myIBMiObjectType.equals(MyIBMiObjectType.Member)) {
				cm.getItems().add(miView);
				cm.getItems().add(miEdit);
			} else if (myIBMiObjectType.equals(MyIBMiObjectType.Library)) {
				cm.getItems().add(miClearLibrary);
			}
			cm.getItems().add(miViewDescription);
			cm.getItems().add(miDelete);
		}

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param row
	 * @param menuItemViewDescription
	 */
	private void setMyContextMenuHandler(TreeTableRow<MyTreeTableDataNode> row, MenuItem mi) {

		LOGGER.debug("begin");

		LOGGER.debug(mi.getText());

		if (mi.getText() != null) {

			if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.Expand.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemExpand(row.getItem());
				});
			} else if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.Refresh.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemRefresh(row.getItem());
				});
			} else if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.DisplayDescription.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemViewDescription(row.getItem());
				});
			} else if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.View.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemView(row.getItem());
				});
			} else if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.Edit.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemEdit(row.getItem());
				});
			} else if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.Delete.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemDelete(row.getItem());
				});
			} else if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.Run.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemRun(row.getItem());
				});
			} else if (mi.getText().equalsIgnoreCase(MyContextMenuItemType.ClearLibrary.getName())) {
				mi.setOnAction(evt -> {
					handleContextMenuItemClearLibrary(row.getItem());
				});
			} else {
				LOGGER.debug("!!! unknown !!!");
			}
		}

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param treeTableView
	 */
	private void setMyContextMenu(TreeTableView<MyTreeTableDataNode> treeTableView) {

		LOGGER.debug("begin");

		treeTableView.setRowFactory(ttv -> {

			MenuItem cmiExpand = new MenuItem(MyContextMenuItemType.Expand.getName());
			MenuItem cmiRefresh = new MenuItem(MyContextMenuItemType.Refresh.getName());
			MenuItem cmiViewDescription = new MenuItem(MyContextMenuItemType.DisplayDescription.getName());
			MenuItem cmiView = new MenuItem(MyContextMenuItemType.View.getName());
			MenuItem cmiEdit = new MenuItem(MyContextMenuItemType.Edit.getName());
			MenuItem cmiDelete = new MenuItem(MyContextMenuItemType.Delete.getName());
			MenuItem cmiRun = new MenuItem(MyContextMenuItemType.Run.getName());
			MenuItem cmiClearLibrary = new MenuItem(MyContextMenuItemType.ClearLibrary.getName());

			TreeTableRow<MyTreeTableDataNode> row = new TreeTableRow<MyTreeTableDataNode>() {

				@Override
				public void updateItem(MyTreeTableDataNode item, boolean empty) {
					super.updateItem(item, empty);
					if (empty) {
						setContextMenu(null);
					} else {
						ContextMenu contextMenu = new ContextMenu();
						setMyContextMenuDependingOnType(item, contextMenu, cmiExpand, cmiRefresh, cmiViewDescription, cmiView, cmiEdit, cmiDelete, cmiRun, cmiClearLibrary);
						setContextMenu(contextMenu);
					}
				}
			};

			setMyContextMenuHandler(row, cmiExpand);
			setMyContextMenuHandler(row, cmiRefresh);
			setMyContextMenuHandler(row, cmiViewDescription);
			setMyContextMenuHandler(row, cmiView);
			setMyContextMenuHandler(row, cmiEdit);
			setMyContextMenuHandler(row, cmiDelete);
			setMyContextMenuHandler(row, cmiRun);
			setMyContextMenuHandler(row, cmiClearLibrary);

			return row;
		});

		LOGGER.debug("end");
	}

	@Override
	public void start(Stage primaryStage) {

		LOGGER.debug("begin");

		TreeTableView<MyTreeTableDataNode> treeTableView;
		if (BrowserConfig.getRealData()) {
			treeTableView = createTreeTableViewFromRealData();
		} else {
			treeTableView = createTreeTableViewFromFakeData();
		}

		declareMyColumns(treeTableView);
		setMyContextMenu(treeTableView);

		treeTableView.setTableMenuButtonVisible(true);

		StackPane statckPane;
		statckPane = new StackPane();
		statckPane.getChildren().add(treeTableView);

		Scene scene;
		scene = new Scene(statckPane, 1400, 400);

		primaryStage.setScene(scene);
		primaryStage.setTitle(AppConfig.getAppFullName());
		primaryStage.show();

		LOGGER.debug("end");
	}

	/**
	 * 
	 */
	public static void showTree() {

		LOGGER.debug("begin");

		launch();

		LOGGER.debug("end");
	}

}