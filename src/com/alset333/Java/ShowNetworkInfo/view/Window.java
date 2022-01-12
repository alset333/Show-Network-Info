package com.alset333.Java.ShowNetworkInfo.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultEditorKit;

public class Window extends JFrame {
	JPanel mainPanel;
	JPanel itemPanel;
	private JPopupMenu popupMenu;

	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.popupMenu = new JPopupMenu();
		Action copy = new DefaultEditorKit.CopyAction();
		copy.putValue(Action.NAME, "Copy Selection");
		copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
		this.popupMenu.add(copy);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JLabel jl = new JLabel("Network Info");
		jl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
		jl.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(jl);

		itemPanel = new JPanel(new GridLayout(0, 2, 10, 10));
		itemPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		addItem("Hostname", "LOCALHOST");
		addItem("IPv4 Address via OS", "127.0.0.1");
		addItem("five", "six");

		
		mainPanel.add(itemPanel);
		addCentered(new JButton("Refresh"));

		add(mainPanel);

		pack();
		setResizable(false);
		setVisible(true);
	}

	private void addItem(String name, String value) {
		JLabel n = new JLabel(name);
		itemPanel.add(n);

		JTextField v = new JTextField(value);
		v.setEditable(false);
		v.setComponentPopupMenu(popupMenu);
		itemPanel.add(v);

	}

	private void addCentered(JComponent c) {
		c.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.add(c);
	}

}
