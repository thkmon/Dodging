package com.bb.dodging.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DrawUtil {

	public static BufferedImage loadImage(String filePath) throws Exception {

		BufferedImage image = null;

		File imgFile = new File(filePath);
		if (!imgFile.exists()) {
			return null;
		}

		image = ImageIO.read(imgFile);
		return image;
	}

}
