package control;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GetImage {
	public ImageIcon getImage(String fileName) {
		ImageIcon icon = new ImageIcon(fileName);
		return icon;
	}
}
