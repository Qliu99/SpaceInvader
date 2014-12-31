package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MainGame;
import com.mygdx.game.TextureManager;
import com.mygdx.game.screen.GameOverScreen;
import com.mygdx.game.screen.ScreenManager;


public class EntityManager {

	private final Array<Entity> entities=new Array<Entity>();
	private final Player player;
	
	public EntityManager(int amount){
		
		player=new Player(new Vector2(230,0), new Vector2(0,0),this);
		
		for(int i=0;i<amount;i++){
			float x=MathUtils.random(0,MainGame.WIDTH-TextureManager.ENEMY.getWidth());
			float y=MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT*2);
			float speed=MathUtils.random(2,5);
			addEntity(new Enemy(new Vector2(x,y), new Vector2(0, -speed)));
		
		}
	}
	
	public void update(){
		for(Entity e: entities)
			e.update();
		for(Missle m: getMissles())
			if(m.checkEnd())
				entities.removeValue(m, false);
		
		player.update();
		checkCollisions();
	}
	
	public void render(SpriteBatch sb){
		for(Entity e: entities)
			e.render(sb);
			
		player.render(sb);
	}
	
	
	private void checkCollisions(){
		for(Enemy e: getEnemies()){
			for (Missle m: getMissles()){
				if(e.getBounds().overlaps(m.getBounds())){
					entities.removeValue(e, false);
					entities.removeValue(m, false);
					if(gameOver()){
						//end won
						ScreenManager.setScreen(new GameOverScreen(true));
					}
				}
			}
		if(e.getBounds().overlaps(player.getBounds())){
			ScreenManager.setScreen(new GameOverScreen(false));
		}
			
		}
		
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	
	private Array<Enemy> getEnemies(){
		Array<Enemy> ret=new Array<Enemy>();
		for (Entity e: entities)
			if(e instanceof Enemy)
			ret.add((Enemy)e);
		return ret;
	}
	
	private Array<Missle> getMissles(){
		Array<Missle> ret=new Array<Missle>();
		for (Entity e: entities)
			if(e instanceof Missle)
			ret.add((Missle)e);
		return ret;
	}
	
	public boolean gameOver(){
		return getEnemies().size<=0;
	}
}
