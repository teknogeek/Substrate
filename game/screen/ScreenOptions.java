package game.screen;

import game.Game;
import game.SpriteSheet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class ScreenOptions extends Screen {


	private String sound = "OFF", music = "ON", debug = "OFF";
	private int volume = 10;
	public ScreenOptions(int width, int height, SpriteSheet sheet, HashMap<String, String> options) {
		super(width, height, sheet);

		addButton("toggleSound", new Rectangle(550, 194, 90, 30));
		addButton("toggleDebug", new Rectangle(550, 110, 90, 30));
		addButton("toggleMusic", new Rectangle(550, 152, 90, 30));
		
		addButton("increaseSound", new Rectangle(702, 238, 25, 30));
		addButton("decreaseSound", new Rectangle(473, 238, 25, 30));

	}

	@Override
	public void tick() {

	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		

	}

	@Override()
	public void init(Game game) {
		super.init(game);
		
	}
	
	@Override
	public void postAction(String action)
	{
		if(action == "decreaseSound" && volume > 0)
		{	
			volume-=10;
			return;
		}
		if(action == "increaseSound" && volume < 100)
		{
			volume+=10;
			return;
		}
		if(action == "toggleSound")
		{	
			sound = sound == "ON" ? "OFF" : "ON";
			return;
		}
		if(action == "toggleMusic")
		{	
			music = music == "ON" ? "OFF" : "ON";
			return;
		}
		if(action == "toggleDebug")
		{	
			debug = debug == "ON" ? "OFF" : "ON";
			return;
		}
	}

	@Override
	public void render(Graphics g) {
		drawBackgroundScreen();
	
		game.getFontRenderer().drawString("Options", 320, 30, 2);
		
		game.getFontRenderer().drawString("Sound", 100, 200, 2);
		ScreenTools.drawOnOffButton(550, 194, 90, 30, sound, g, game);	

		game.getFontRenderer().drawString("Debug", 100, 116, 2);
		ScreenTools.drawOnOffButton(550, 110, 90, 30, debug, g, game);
		
		game.getFontRenderer().drawString("Music", 100, 159, 2);
		ScreenTools.drawOnOffButton(550, 152, 90, 30, music, g, game);
		
		game.getFontRenderer().drawString("Volume", 100, 241, 2);
		ScreenTools.drawProgressBar(500, 238, 200, 32, volume, g, game, new Color(0,0,0,155), sound == "ON" || music == "ON" ? Color.green : Color.gray);
		ScreenTools.drawButton(473, 238, 25, 30, "< ", g, game);	
		ScreenTools.drawButton(702, 238, 25, 30, "> ", g, game);
		
		game.getFontRenderer().drawString("Gather stats", 100, 287, 2);
		game.getFontRenderer().drawString("Should the game gather", 300, 287, 1);
		game.getFontRenderer().drawString("anonymous statistics?", 300, 297, 1);
		
		game.getFontRenderer().drawString("Map previews", 100, 327, 2);
		game.getFontRenderer().drawString("Show map previews in the", 300, 327, 1);
		game.getFontRenderer().drawString("multiplayer menu?", 300, 337, 1);
		
		game.getFontRenderer().drawString("Show tutorial", 100, 367, 2);
		game.getFontRenderer().drawString("Watch the tutorial again", 310, 367, 1);
		game.getFontRenderer().drawString("turns off after 1 use.", 310, 377, 1);
		
		game.getFontRenderer().drawString("Show console", 100, 407, 2);
		game.getFontRenderer().drawString("Display developer console", 310, 407, 1);
		game.getFontRenderer().drawString("for commands and things.", 310, 417, 1);
		
		
		
	}

		

}
