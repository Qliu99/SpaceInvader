package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MainGame;
import com.mygdx.game.TextureManager;

public class GameOverScreen extends Screen {

	private Texture texture;
	
	public GameOverScreen(boolean won){
		if(won)
			texture=TextureManager.GAME_WON;
		else
			texture=TextureManager.GAME_OVER;
			
		
	}
	@Override
	public void create() {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(texture, MainGame.WIDTH/2-texture.getWidth()/2,MainGame.HEIGHT/2-texture.getHeight()/2);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
