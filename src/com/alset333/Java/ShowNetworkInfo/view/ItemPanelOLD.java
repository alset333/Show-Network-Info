package com.alset333.Java.ShowNetworkInfo.view;

import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class ItemPanelOLD extends JPanel {

	private JPopupMenu popupMenu; // Based on https://stackoverflow.com/a/30684790
	private JLabel nameComponent;
	private JTextField valueComponent;

	public ItemPanelOLD(String name, String value) {

		this.popupMenu = new JPopupMenu();
		Action copy = new DefaultEditorKit.CopyAction();
		copy.putValue(Action.NAME, "Copy Selection");
		copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
		this.popupMenu.add(copy);

		this.nameComponent = new JLabel(name);
		this.add(this.nameComponent);

		this.valueComponent = new JTextField(value);
		this.valueComponent.setEditable(false);
		this.add(this.valueComponent);
		this.valueComponent.setComponentPopupMenu(popupMenu);

	}

}
