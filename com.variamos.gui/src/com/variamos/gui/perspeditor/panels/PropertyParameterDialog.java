package com.variamos.gui.perspeditor.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;

import com.variamos.dynsup.instance.InstElement;
import com.variamos.dynsup.interfaces.IntInstAttribute;
import com.variamos.dynsup.model.OpersExpr;
import com.variamos.gui.maineditor.VariamosGraphEditor;
import com.variamos.gui.perspeditor.SpringUtilities;
import com.variamos.gui.perspeditor.panels.SemanticExpressionDialog.SemanticExpressionButtonAction;
import com.variamos.gui.perspeditor.widgets.RefasWidgetFactory;
import com.variamos.gui.perspeditor.widgets.WidgetR;

/**
 * @author unknown
 *
 */
@SuppressWarnings("serial")
public class PropertyParameterDialog extends JDialog {
	private HashMap<String, WidgetR> widgets;
	private List<OpersExpr> expressions;
	private DialogButtonAction onAccept, onDelete, onCancel;

	static interface DialogButtonAction {
		public boolean onAction();
	}

	public PropertyParameterDialog(int height, int width, String dialogTitle,
			final VariamosGraphEditor editor, final InstElement instElement,
			IntInstAttribute... arguments) {
		super(editor.getFrame(), dialogTitle);

		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());

		setPreferredSize(new Dimension(width, height));

		RefasWidgetFactory factory = new RefasWidgetFactory(editor);

		widgets = new HashMap<String, WidgetR>();

		for (final IntInstAttribute elementAttribute : arguments) {
			panel.add(new JLabel(elementAttribute.getDisplayName() + ": "));

			// FIXME v1.1 workaround for null types
			if (elementAttribute.getType() != null
					&& elementAttribute.getType().equals(
							OpersExpr.class.getCanonicalName())) {
				JButton jb = new JButton(elementAttribute.getDisplayName());
				panel.add(jb);
				jb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						if (elementAttribute.getValue() != null) {
							expressions = (List<OpersExpr>) elementAttribute
									.getValue();
							if (expressions == null)
								expressions = new ArrayList<OpersExpr>();
						}
						final SemanticExpressionDialog dialog = new SemanticExpressionDialog(
								editor, instElement, expressions);
						dialog.center();
						dialog.setOnAccept(new SemanticExpressionButtonAction() {
							@Override
							public boolean onAction() {
								// This calls Pull on each
								// parameter
								// attributeEdition.getParameters();
								elementAttribute.setValue(dialog
										.getExpressions());
								// attributes.put(name.getName(),
								// v);
								try {
									// ((SemanticExpression) elementAttribute
									// .getValue())
									// .createSGSExpression((SemanticExpression)
									// elementAttribute
									// .getValue());

								} catch (Exception e) {
									JOptionPane
											.showMessageDialog(
													editor,
													"Complete/Correct the expression before closing the editor",
													"Expression Error",
													JOptionPane.INFORMATION_MESSAGE,
													null);
									e.printStackTrace();
									return false;
								}

								// afterAction();
								return true;
							}
						});
						/*
						 * dialog.setOnDelete(new
						 * InstanceExpressionButtonAction() {
						 * 
						 * @Override public boolean onAction() {
						 * elementAttribute .setValue(null); return true; } });
						 */
					}
				});
			} else {
				WidgetR w = factory.getWidgetFor(elementAttribute);
				w.editVariable(elementAttribute);

				w.addPropertyChangeListener("value",
						new PropertyChangeListener() {
							@Override
							public void propertyChange(PropertyChangeEvent evt) {
								revalidate();
								doLayout();
								pack();
							}
						});

				widgets.put(elementAttribute.getIdentifier(), w);

				panel.add(w);
			}
		}

		SpringUtilities.makeCompactGrid(panel, arguments.length, 2, 4, 4, 4, 4);

		add(panel, BorderLayout.CENTER);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new SpringLayout());

		final JButton btnAccept = new JButton();
		btnAccept.setText("Accept");
		btnAccept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (onAccept != null)
					if (onAccept.onAction())
						dispose();
			}
		});

		buttonsPanel.add(btnAccept);

		final JButton btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (onCancel == null) {
					dispose();
					return;
				}
				if (onCancel.onAction())
					dispose();
			}
		});

		buttonsPanel.add(btnCancel);

		final JButton btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (onDelete != null) {
					if (onDelete.onAction())
						dispose();
					return;
				}

			}
		});

		buttonsPanel.add(btnDelete);

		SpringUtilities.makeCompactGrid(buttonsPanel, 1, 3, 4, 4, 4, 4);

		add(buttonsPanel, BorderLayout.SOUTH);

		getRootPane().setDefaultButton(btnAccept);
		getRootPane().registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancel.doClick();
			}

		}, KeyStroke.getKeyStroke("ESCAPE"), JComponent.WHEN_IN_FOCUSED_WINDOW);
		pack();
	}

	/**
	 * @return
	 */
	public Map<String, IntInstAttribute> getParameters() {
		Map<String, IntInstAttribute> map = new HashMap<>();

		for (String s : widgets.keySet()) {
			IntInstAttribute v = widgets.get(s).getInstAttribute();
			map.put(v.getIdentifier(), v);
		}

		return map;
	}

	public void center() {
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setOnAccept(DialogButtonAction onAccept) {
		this.onAccept = onAccept;
	}

	public void setOnDelete(DialogButtonAction onDelete) {
		this.onDelete = onDelete;
	}

	public void setOnCancel(DialogButtonAction onCancel) {
		this.onCancel = onCancel;
	}
}
