package com.remainsoftware.featureexplorer;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

import com.remainsoftware.featureexplorer.internal.DescriptionColumnLabelProvider;
import com.remainsoftware.featureexplorer.internal.FeatureExplorerContentProvider;
import com.remainsoftware.featureexplorer.internal.FeatureFilter;
import com.remainsoftware.featureexplorer.internal.NameColumnLabelProvider;
import com.remainsoftware.featureexplorer.internal.ProviderColumnLabelProvider;
import com.remainsoftware.featureexplorer.internal.StateColumnLabelProvider;
import com.remainsoftware.featureexplorer.internal.VersionColumnLabelProvider;
import com.remainsoftware.featureexplorer.internal.ViewerComparatorExtension;

public class FeatureExplorer extends ViewPart {
	private Text text;
	private TreeViewer treeViewer;

	public FeatureExplorer() {
		// TODO Auto-generated constructor stub
	}

	private void createContextMenu() {
		// Create menu manager.
		MenuManager menuMgr = new MenuManager();
		// menuMgr.setRemoveAllWhenShown(true);
		// menuMgr.addMenuListener(new IMenuListener() {
		// public void menuAboutToShow(IMenuManager mgr) {
		// fillContextMenu(mgr);
		// }
		// });

		// Create menu.
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);

		// Register menu for extension.
		getSite().registerContextMenu(menuMgr, treeViewer);
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout gl_parent = new GridLayout(1, false);
		gl_parent.verticalSpacing = 0;
		gl_parent.marginWidth = 0;
		gl_parent.marginHeight = 0;
		parent.setLayout(gl_parent);

		text = new Text(parent, SWT.BORDER | SWT.SEARCH);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (text.getText().length() > 0) {
					treeViewer.setFilters(new ViewerFilter[] { new FeatureFilter(text.getText()) });
				} else {
					treeViewer.setFilters(new ViewerFilter[0]);
				}
			}
		});
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TreeColumnLayout tcl_composite = new TreeColumnLayout();
		composite.setLayout(tcl_composite);

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		treeViewer.setAutoExpandLevel(2);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		treeViewerColumn.setLabelProvider(new NameColumnLabelProvider());
		TreeColumn trclmnFeature = treeViewerColumn.getColumn();
		tcl_composite.setColumnData(trclmnFeature, new ColumnWeightData(2, 100, true));
		trclmnFeature.setText("Name");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewer, SWT.NONE);
		treeViewerColumn_1.setLabelProvider(new VersionColumnLabelProvider());
		TreeColumn trclmnVersion = treeViewerColumn_1.getColumn();
		tcl_composite.setColumnData(trclmnVersion, new ColumnWeightData(1, ColumnWeightData.MINIMUM_WIDTH, true));
		trclmnVersion.setText("Version");

		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(treeViewer, SWT.NONE);
		treeViewerColumn_2.setLabelProvider(new StateColumnLabelProvider());
		TreeColumn trclmnState = treeViewerColumn_2.getColumn();
		tcl_composite.setColumnData(trclmnState, new ColumnWeightData(1, ColumnWeightData.MINIMUM_WIDTH, true));
		trclmnState.setText("State");

		TreeViewerColumn treeViewerColumn_3 = new TreeViewerColumn(treeViewer, SWT.NONE);
		treeViewerColumn_3.setLabelProvider(new ProviderColumnLabelProvider());
		TreeColumn trclmnProvider = treeViewerColumn_3.getColumn();
		tcl_composite.setColumnData(trclmnProvider, new ColumnWeightData(1, ColumnWeightData.MINIMUM_WIDTH, true));
		trclmnProvider.setText("Provider");

		TreeViewerColumn treeViewerColumn_4 = new TreeViewerColumn(treeViewer, SWT.NONE);
		treeViewerColumn_4.setLabelProvider(new DescriptionColumnLabelProvider());
		TreeColumn trclmnDescription = treeViewerColumn_4.getColumn();
		tcl_composite.setColumnData(trclmnDescription, new ColumnWeightData(3, ColumnWeightData.MINIMUM_WIDTH, true));
		trclmnDescription.setText("Description");
		treeViewer.setContentProvider(new FeatureExplorerContentProvider());

		treeViewer.setComparator(new ViewerComparatorExtension());

		treeViewer.setInput("go");

		getSite().setSelectionProvider(treeViewer);

		createContextMenu();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
