package com.alset333.Java.ShowNetworkInfo.view;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindowOLD extends JFrame {

	private JPanel mainPane;

	public MainWindowOLD() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));

		JLabel jl = new JLabel("Network Info");
		jl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));

		mainPane.add(jl);

		mainPane.add(new ItemPanelOLD("name", "value"));

		addItem("Hostname", "foobar");

		JButton jb = new JButton("Refresh");
		mainPane.add(jb);

		add(mainPane);

		pack();
		setResizable(false);
		setVisible(true);
	}

	private void addItem(String name, String value) {
		this.mainPane.add(new ItemPanelOLD(name, value));
	}
}
