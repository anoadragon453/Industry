package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import integerMath.*;

public class TestDriver_2 {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
		try {
			
			File in = new File("C:\\Users\\Javier\\Desktop\\colortestin.png");
			BufferedImage im_in = ImageIO.read(in);
			
			BufferedImage im_out = new BufferedImage(
					im_in.getWidth(),
					im_in.getHeight(),
					BufferedImage.TYPE_INT_ARGB);
			
			for(int y = 0; y < im_in.getHeight(); ++y) {
				for(int x = 0; x < im_in.getWidth(); ++x) {
					im_out.setRGB(
							x,
							y,
							BitConversion.expand(BitConversion.compress(im_in.getRGB(x, y)))
							);
				}
				System.out.println("Iteration: " + y + " of " + im_in.getHeight());
			}
			
			File out = new File("C:\\Users\\Javier\\Desktop\\colortestout.png");
			ImageIO.write(im_out, "PNG", out);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
