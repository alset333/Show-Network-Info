/**
 *
 */
package com.alset333.Java.ShowNetworkInfo;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.alset333.Java.ShowNetworkInfo.model.NetInfo;
import com.alset333.Java.ShowNetworkInfo.view.Window;

/**
 * @author Peter Maar
 *
 */
public class ShowNetworkInfo {

	public static void main(String[] args) {
		NetInfo ni = new NetInfo();
		ni.loadNetworkInterfaces();

		Enumeration<NetworkInterface> interfaces = ni.getInterfaces();

		NetworkInterface iface;

		while (interfaces.hasMoreElements()) {
			iface = interfaces.nextElement();

			if (ni.interfaceIsInteresting(iface)) {
				List<InterfaceAddress> addr = iface.getInterfaceAddresses();
				if (!addr.isEmpty())
					System.out.println(iface.getDisplayName());
				System.out.println(addr);
			}
		}

		System.exit(0);

	}

	public static void main_V1(String[] args) { // TODO use this stuff to make the rest of the stuff
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Enumeration<NetworkInterface> interfaces;
			interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = interfaces.nextElement();
				Enumeration<InetAddress> interfaceAddresses = networkInterface.getInetAddresses();
				if (interfaceAddresses.hasMoreElements()) {
					System.out.println();
					System.out.println(networkInterface.getDisplayName());
				}
				while (interfaceAddresses.hasMoreElements()) {
					InetAddress inetAddr = interfaceAddresses.nextElement();
					System.out.println(inetAddr);
				}
			}
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Window win = new Window();
		win.setVisible(true);
	}

}
