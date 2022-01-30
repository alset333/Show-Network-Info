package com.alset333.Java.ShowNetworkInfo.model;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetInfo {

	private Enumeration<NetworkInterface> interfaces;

	public NetInfo() {
	}

	public void loadNetworkInterfaces() {
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
		} // TODO better catch message

	}

	public Enumeration<NetworkInterface> getInterfaces() {
		return interfaces;
	}

	public boolean interfaceIsInteresting(NetworkInterface netiface) {

		try {
			if (!netiface.isUp()// If the interface is not up, it is not interesting
					|| netiface.isLoopback() // If the interface is for loopback, it is not interesting
			) {
				return false;
			}

		} catch (SocketException e) {
			e.printStackTrace(); // TODO
		}

		return true;

		// System.out.print(netiface);System.out.print('\t');
		// System.out.print(netiface.getDisplayName());System.out.print('\t');
		// System.out.print(netiface.getName());System.out.print('\t');
		// System.out.print(netiface.isLoopback());System.out.print('\t');
		// System.out.print(netiface.isPointToPoint()); System.out.print('\t');
		// System.out.print(netiface.isUp());System.out.print('\t');
		// System.out.println(netiface.isVirtual());

	}

}
