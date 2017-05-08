package types;

/*
 * TODO:
 * SCRAP THIS, MAKE THIS CODE INTO NEW CODE FOR THE DISPLAY SYSTEM
 */
public class OLD_SHITTY_CODE_Display{
	private int xpos;	//Position of the tile at which the camera is centered in the x axis of the tile array of the map.
	private int ypos;	//Take a wild guess, cowboy.
	private byte zoom;
	private byte type;	//Type of display.
	
	private int windowsizex;
	private int windowsizey;
	private byte[][] display;	//What the screen is currently showing.
	
	public OLD_SHITTY_CODE_Display(int x, int y, int windowsizex, int windowsizey){
		xpos = x;
		ypos = y;
		zoom = 16;
		type = 0;
		
		this.windowsizex = windowsizex;
		this.windowsizey = windowsizey;
		display = null;
	}
	
	public int getXPos(){
		return xpos;
	}
	public int getYPos(){
		return ypos;
	}
	public void setXPos(int x){
		xpos = x;
	}
	public void setYPos(int y){
		ypos = y;
	}
	
	public void resize(int windowsizex, int windowsizey){
		this.windowsizex = windowsizex;
		this.windowsizey = windowsizey;
	}
	
	//Method to get the current display
	public byte[][] getDisplay(){
		return display;
	}
	
	//Methods to move the camera around the map
	public void moveDown(int MapSizeX, int MapSizeY){
		if(xpos < MapSizeX){
			xpos++;
		}
		if(ypos < MapSizeY){
			ypos++;
		}
		//TODO: Render the new pixels;
	}
	public void moveDownLeft(int MapSizeX){
		if(xpos < MapSizeX){
			xpos++;
		}
		//TODO: Render the new pixels;
	}
	public void moveLeft(int MapSizeX){
		if(xpos < MapSizeX){
			xpos++;
		}
		if(ypos > 0){
			ypos--;
		}
		//TODO: Render the new pixels;
	}
	public void moveUpLeft(){
		if(ypos > 0){
			ypos--;
		}
		//TODO: Render the new pixels;
	}
	public void moveUp(){
		if(xpos > 0){
			xpos--;
		}
		if(ypos > 0){
			ypos--;
		}
		//TODO: Render the new pixels;
	}
	public void moveUpRight(){
		if(xpos > 0){
			xpos--;
		}
		//TODO: Render the new pixels;
	}
	public void moveRight(int MapSizeY){
		if(xpos > 0){
			xpos--;
		}
		if(ypos < MapSizeY){
			ypos++;
		}
		//TODO: Render the new pixels;
	}
	public void moveDownRight(int MapSizeY){
		if(ypos < MapSizeY){
			ypos++;
		}
		//TODO: Render the new pixels;
	}
	public void moveDownUnconditionally(){
		xpos++;
		ypos++;
		//TODO: Render the new pixels;
	}
	public void moveDownLeftUnconditionally(){
		xpos++;
		//TODO: Render the new pixels;
	}
	public void moveLeftUnconditionally(){
		xpos++;
		ypos--;
		//TODO: Render the new pixels;
	}
	public void moveUpLeftUnconditionally(){
		ypos--;
		//TODO: Render the new pixels;
	}
	public void moveUpUnconditionally(){
		xpos--;
		ypos--;
		//TODO: Render the new pixels;
	}
	public void moveUpRightUnconditionally(){
		xpos--;
		//TODO: Render the new pixels;
	}
	public void moveRightUnconditionally(){
		xpos--;
		ypos++;
		//TODO: Render the new pixels;
	}
	public void moveDownRightUnconditionally(){
		ypos++;
		//TODO: Render the new pixels;
	}
	
	public void zoomIn(){
		if(zoom > 8){
			zoom = (byte)((int)zoom << 1);
		}
		//TODO: Render the display again
	}
	public void zoomOut(){
		if(zoom < 64){
			zoom = (byte)((int)zoom >> 1);
		}
		//TODO: Render the display again
	}
	
	
	public void blit(){
		//TODO: Blitting method.
	}
	
	public void render(int x, int y){
		//TODO: Renders a single pixel
	}
	
	public void render(){
		/*
		int xpos;	//to iterate over the position the pixels in the x axis on the screen
		int ypos;	//to iterate over the position the pixels in the y axis on the screen
		
		while(xpos < windowsizex){
			while(ypos < windowsizey){
				
				for(tiles at that xpos, from the lowest to the that contains the ypos (highest tile that can contain such pixel)){
				
				//Note: if tile is a pointer to another (anchor) tile, do it from the texture of that tile
				
					if(get RGB value of the equivalent pixel of the texture of such tile(xpos, ypos)){	//Equivalent to false if it's white (000000), else equivalent to true.
						continue
					}else{
						color of the pixel at (xpos, ypos) = get such RGB value
						leave the loop
					}
				}
				
				++ypos;
			}
			++xpos;
		}
		*/
	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the lowest to the highest.
	 * @return Position of a Tile[] in the Tile[][] arrays of the map in the current display, supposing all tiles are at altitude 0.
	 */
	public int unrenderAtX(int x, int y){
		x = x - windowsizex/2;
		y = y + 1 - windowsizey/2;
		int res = x-y-y;
		if(res > 0){res = res - 1 + zoom/2;}
		if(res < 0){res = res - zoom/2;}
		res = res / zoom;
		res = res + ypos;
		return res;
	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the lowest to the highest.
	 * @return Position of a Tile in the Tile[] arrays of the map in the current display, supposing all tiles are at altitude 0.
	 */
	public int unrenderAtY(int x, int y){
		x = x - windowsizex/2;
		y = y + 1 - windowsizey/2;
		int res = -x-y-y;
		if(res > 0){res = res - 1 + zoom/2;}
		if(res < 0){res = res - zoom/2;}
		res = res / zoom;
		res = res + xpos;
		return res;
	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the highest to the lowest.
	 * @return Position of a Tile[] in the Tile[][] arrays of the map in the current display, supposing all tiles are at altitude 0.
	 */
	public int unrenderAtX_HighToLow(int x, int y){
		x = x - windowsizex/2;
		y = windowsizey/2 - y - 1;
		int res = x-y-y;
		if(res > 0){res = res - 1 + zoom/2;}
		if(res < 0){res = res - zoom/2;}
		res = res / zoom;
		res = res + ypos;
		return res;
	}
	
	/**
	 * @param x Coordinate x of a pixel in the screen.
	 * @param y Coordinate y of a pixel in the screen, counting from the highest to the lowest.
	 * @return Position of a Tile in the Tile[] arrays of the map in the current display, supposing all tiles are at altitude 0.
	 */
	public int unrenderAtY_HighToLow(int x, int y){
		x = x - windowsizex/2;
		y = windowsizey/2 - y - 1;
		int res = -x-y-y;
		if(res > 0){res = res - 1 + zoom/2;}
		if(res < 0){res = res - zoom/2;}
		res = res / zoom;
		res = res + xpos;
		return res;
	}
}