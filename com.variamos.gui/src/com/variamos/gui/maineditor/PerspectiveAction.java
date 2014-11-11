package com.variamos.gui.maineditor;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mxgraph.examples.swing.editor.BasicGraphEditor;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraph;
import com.variamos.gui.pl.editor.PLGraphEditorFunctions;
import com.variamos.gui.pl.editor.PLPalettesLoader;
import com.variamos.gui.pl.editor.ProductLineGraph;
import com.variamos.gui.refas.editor.RQPalettesLoader;
import com.variamos.gui.refas.editor.RefasGraphEditor;
import com.variamos.gui.refas.editor.RefasGraphEditorFunctions;

@SuppressWarnings("serial")
public class PerspectiveAction extends AbstractEditorAction {
	
	private PerspectiveToolBar perspective;

	
	public PerspectiveAction (PerspectiveToolBar perspective)
	{
		this.perspective = perspective;
	}
	/**
		 * 
		 */
	public void actionPerformed(ActionEvent e) {


		VariamosGraphEditor editor = getEditor(e);
		int perspectiveInd = editor.getPerspective();
		if (editor != null) {
			if (!editor.isModified()
					|| JOptionPane.showConfirmDialog(editor,
							mxResources.get("loseChanges")) == JOptionPane.YES_OPTION) {
				mxGraph graph = editor.getGraphComponent().getGraph();
				JButton jb = (JButton) e.getSource();
				if (perspectiveInd != 0
						&& jb.getText().equals(
								mxResources.get("productLineButton"))) {
					editor.setGraphEditorFunctions (new PLGraphEditorFunctions());
					editor.editProductLineReset();
					editor.clearPalettes();
					System.out.println("product");
					editor.loadRegularPalette(editor.insertPalette(mxResources
							.get("productLinePalette")));
				/*	PLPalettesLoader.loadRegularPalette(editor.insertPalette(mxResources
									.get("productLinePalette")),
							(ProductLineGraph) editor.getGraphComponent().getGraph());
					editor.setPerspective(0);
					*/
				}
				if (perspectiveInd != 1
						&& jb.getText().equals(mxResources.get("defectAnalyzerButton"))) {
					editor.editProductLineReset();
					editor.clearPalettes();
					System.out.println("defect");
					editor.setPerspective(1);
				}
				if (perspectiveInd != 2
						&& jb.getText().equals(mxResources.get("requirementsButton"))) {

					editor.setGraphEditorFunctions (new RefasGraphEditorFunctions());
					editor.editProductLineReset();
					editor.clearPalettes();
					System.out.println("requirements");
					editor.setPerspective(2);
					editor.loadRegularPalette(editor.insertPalette(mxResources
							.get("conceptsPalette")));
					editor.loadRegularPalette(editor.insertPalette(mxResources
							.get("relationsPalette")));
					/*
					 	RQPalettesLoader.loadConceptsPalette(editor
					 
							.insertPalette(mxResources.get("conceptsPalette")),
							(ProductLineGraph) editor.getGraphComponent().getGraph());
					RQPalettesLoader.loadRelationsPalette(
							editor.insertPalette(mxResources.get("relationsPalette")),
							(ProductLineGraph) editor.getGraphComponent()
									.getGraph());
									*/
				}
				// Check modified flag and display save dialog
				mxCell root = new mxCell();
				root.insert(new mxCell());
				graph.getModel().setRoot(root);

				editor.setModified(false);
				editor.setCurrentFile(null);
				editor.getGraphComponent().zoomAndCenter();
				
			}
		}
		perspective.updateButtons();
	}
}