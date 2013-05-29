package game.entity;

import game.screen.ScreenGame;
import game.tile.Tile;
import game.tile.TileWall;
import game.tile.TileWater;

import java.awt.Rectangle;

public class EntityBullet extends Entity{

	
	
	
	private ScreenGame game;
	private int type = 0, rotation = 0, speed = 6;
	public EntityBullet(ScreenGame game, int type, int rotation, int x, int y) {
		super(game);
		this.game = game;
		this.type = type;
		this.rotation = rotation;
		this.x = x;
		this.y = y;
		
		sprite = 4 + rotation;
		
	}
	
	public EntityBullet()
	{
		sprite = 4;
	}
	
	@Override
	public void tick()
	{
		if(rotation == Player.NORTH)
			this.y -=speed;
		
		if(rotation == Player.SOUTH)
			this.y +=speed;
		
		if(rotation == Player.EAST)
			this.x +=speed;
		if(rotation == Player.WEST)
			this.x -=speed;
		
		
		if(game.getTileAt(x, y) == null)
		{
			this.forRemoval = true;
		return;
		}
		Tile t = game.getTileAt(x, y);
		if(!t.isPassable() && t instanceof TileWater == false)
		{
			if(t instanceof TileWall)
			{
				switch(t.sprite)
				{
				case TileWall.TOP_CORNER_LEFT:
					game.setTileAt(x, y, 19);
					break;
				case TileWall.TOP_CORNER_RIGHT:
					game.setTileAt(x, y, 20);
					break;
				case TileWall.WALL_VERTICAL:
					game.setTileAt(x, y, 3);
					break;
				case TileWall.WALL_VERTICAL_TOP:
					game.setTileAt(x, y, 17);
					break;
				case TileWall.WALL_VERTICAL_BOTTOM:
					game.setTileAt(x, y, 18);
					break;
				case TileWall.BOTTOM_CORNER_LEFT:
					game.setTileAt(x, y, 21);
					break;
				case TileWall.BOTTOM_CORNER_RIGHT:
					game.setTileAt(x, y, 22);
					break;
				default:
					game.setTileAt(x, y, 3);
					break;
				}
				
			}
			game.spawnEntity(new EntityExplosion(game, x-4, y-2, 2));
			this.forRemoval = true;
		}
		Entity e = game.getEntityInBox(new Rectangle( x, y, 32, 32));
		if(e instanceof EntityBox)
		{
			this.forRemoval = true;
			e.forRemoval = true;
			game.spawnEntity(new EntityExplosion(game, x-4, y-2, 2));
		}
	}

}
