/**
 * 
 */
package com.alset333.Java.ShowNetworkInfo;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.alset333.Java.ShowNetworkInfo.view.Window;

/**
 * @author Peter Maar
 *
 */
public class ShowNetworkInfo {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Window win = new Window();
	}

}
