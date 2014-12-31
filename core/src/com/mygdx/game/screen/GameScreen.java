package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.Player;

public class GameScreen extends Screen {


	private EntityManager entityManager;
	
	@Override
	public void create() {
		//System.out.println("Create");
		entityManager=new EntityManager(25);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		entityManager.update();
	}
	
	@Override
	public void render(SpriteBatch sb) {
	
		//System.out.println("render");
		sb.begin();
		entityManager.render(sb);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
	
		//System.out.println("resize");
	}

	@Override
	public void dispose() {
	
		//System.out.println("dispose");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		//System.out.println("pause");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		//System.out.println("resume");
	}

	

}
