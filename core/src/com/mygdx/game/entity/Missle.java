package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MainGame;
import com.mygdx.game.TextureManager;

public class Missle extends Entity{

	public Missle( Vector2 pos) {
		super(TextureManager.MISSLE, pos, new Vector2(0,5));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		pos.add(direction);
		
		
		
	}
	
	public boolean checkEnd(){
		return pos.y>=MainGame.HEIGHT;
	}

}
