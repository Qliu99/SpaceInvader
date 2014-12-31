package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TextureManager;

public class Player extends Entity {

	private final EntityManager entityManager;
	private long lastFire;
	
	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager) {
		super(TextureManager.PLAYER, pos, direction);
		
		this.entityManager=entityManager;
		
	}

	public void update(){

		pos.add(direction);
		
		if(Gdx.input.isKeyPressed(Keys.A))
			setDirection(-300,0);
		else if(Gdx.input.isKeyPressed(Keys.D))
			setDirection(300,0);
		else 
			setDirection(0,0);
		
		if(System.currentTimeMillis()-lastFire>=100){
	
			if(Gdx.input.isKeyPressed(Keys.SPACE))
				entityManager.addEntity(new Missle(pos.cpy().add(TextureManager.PLAYER.getWidth()/2-TextureManager.MISSLE.getWidth()/2,TextureManager.PLAYER.getHeight())));
				lastFire=System.currentTimeMillis();
		}

	}
	
	
}
