package classes;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, MouseListener, MouseWheelListener, MouseMotionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1844148332990960097L;
	
	private boolean running;
	private double tickFrequency;
	public Properties config;
	public Properties language;
	private Thread thread;
	public World world;
	
	/**
	 * Coordinates of the tile at which the display is centered.
	 */
	private int center_coordinate_x, center_coordinate_y;
	private byte orientation;
	private byte zoom;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		running = false;
		JFrame frame = new JFrame("Industry (beta)");
		try {
			frame.setIconImage(ImageIO.read(new File("docs/industry.bmp")));
			config = new Properties();
			config.load(new FileInputStream("config.properties"));
			language = new Properties();
			language.load(new FileInputStream(config.getProperty("language") + ".properties"));
		} catch(Throwable e) {
			e.printStackTrace();
		}
		int defaultWidth = Integer.parseInt(config.getProperty("width"));
		int defaultHeight = Integer.parseInt(config.getProperty("height"));
		tickFrequency = Double.parseDouble(config.getProperty("tickfrequency"));
		frame.setPreferredSize(new Dimension(defaultWidth, defaultHeight));
		frame.setMaximumSize(new Dimension(defaultWidth, defaultHeight));//TODO: different maximum and minimum sizes
		frame.setMinimumSize(new Dimension(defaultWidth, defaultHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);//Makes window start on the middle of the screen since its not relative to anything.
		frame.add(this);
		frame.setVisible(true);
		this.start();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		this.requestFocus();

		long lastIterationTime = System.nanoTime();
		long currentIterationTime;
		
		double tickPeriod = 1000000000.0 / this.tickFrequency;
		double ticksToCatchUp = 0;
		
		while(running) {
			currentIterationTime = System.nanoTime();
			ticksToCatchUp += (currentIterationTime - lastIterationTime) / tickPeriod;
			lastIterationTime = currentIterationTime;
			while(ticksToCatchUp >= 1) {
				tick();
				ticksToCatchUp--;
			}
			if(running) {
				render();
			}
		}
		
		stop();
		
	}
	
	private void render() {

		//TODO

	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the lowest to the highest.
	 * @return Position of a tile in the tile array of a world from the position it would have on the screen if it had altitude 0.
	 */
	public int unrenderAtX(int x, int y, int displaysize_x, int displaysize_y) {
		x = x - displaysize_x/2;
		y = y + 1 - displaysize_y/2;
		int res = x-y-y;
		if(res > 0) {
			res = res - 1 + zoom/2;
		}
		if(res < 0) {
			res = res - zoom/2;
		}
		res = res / zoom;
		res = res + center_coordinate_y;
		return res;
	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the lowest to the highest.
	 * @return Position of a tile in the tile array of a world from the position it would have on the screen if it had altitude 0.
	 */
	public int unrenderAtY(int x, int y, int displaysize_x, int displaysize_y) {
		x = x - displaysize_x/2;
		y = y + 1 - displaysize_y/2;
		int res = -x-y-y;
		if(res > 0) {
			res = res - 1 + zoom/2;
		}
		if(res < 0) {
			res = res - zoom/2;
		}
		res = res / zoom;
		res = res + center_coordinate_x;
		return res;
	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the highest to the lowest.
	 * @return Position of a Tile[] in the Tile[][] arrays of the map in the current display, supposing all tiles are at altitude 0.
	 */
	public int unrenderAtX_HighToLow(int x, int y, int displaysize_x, int displaysize_y) {
		x = x - displaysize_x/2;
		y = displaysize_y/2 - y - 1;
		int res = x-y-y;
		if(res > 0) {
			res = res - 1 + zoom/2;
		}
		if(res < 0) {
			res = res - zoom/2;
		}
		res = res / zoom;
		res = res + center_coordinate_y;
		return res;
	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the highest to the lowest.
	 * @return Position of a Tile in the Tile[] arrays of the map in the current display, supposing all tiles are at altitude 0.
	 */
	public int unrenderAtY_HighToLow(int x, int y, int displaysize_x, int displaysize_y) {
		x = x - displaysize_x/2;
		y = displaysize_y/2 - y - 1;
		int res = -x-y-y;
		if(res > 0) {
			res = res - 1 + zoom/2;
		}
		if(res < 0) {
			res = res - zoom/2;
		}
		res = res / zoom;
		res = res + center_coordinate_x;
		return res;
	}
	
	public void moveCenter(int x, int y) {
		center_coordinate_x += x;
		center_coordinate_y += y;
		/* TODO:
		 * if x is less than the lowest x coordinate in the tectonicplates array, set it to the lowest
		 * if x is more than the highest x coordinate in the tectonicplates array, set it to the highest
		 * if y is less than the lowest y coordinate in the tectonicplates array, set it to the lowest
		 * if y is more than the highest y coordinate in the tectonicplates array, set it to the highest
		 */
	}
	
	private void tick() {
		/* TODO
		 * if any menu is opened -> menu.tick()
		 * else (at world) -> world.tick()
		 */
	}

	@Override public void mouseDragged(MouseEvent mouseEvent) {
		
	}

	@Override public void mouseMoved(MouseEvent mouseEvent) {
		/* If(placing_element):
		 *     check the tiles, render again, color tiles depending on whether they're fit or not to place the element
		 */
	}

	@Override public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		zoom = (byte) (zoom >>> mouseWheelEvent.getWheelRotation());
		if(zoom <= 0) {
			zoom = (byte) (0 < mouseWheelEvent.getWheelRotation() ? 0b00000001 : 0b01000000);
		}
		
		//TODO: Render the display again
	}

	@Override public void mouseClicked(MouseEvent mouseEvent) {
		/* if coordinate clicked contains a button
		 *     do whatever the button says
		 * if it contains information
		 *     show further information
		 * if it's a tile which contains an element
		 *     display its information
		 */
	}

	@Override public void mouseEntered(MouseEvent mouseEvent) {
		//unpause?
	}

	@Override public void mouseExited(MouseEvent mouseEvent) {
		//pause?
	}

	@Override public void mousePressed(MouseEvent mouseEvent) {
		
	}

	@Override public void mouseReleased(MouseEvent mouseEvent) {
		
	}
	
}
