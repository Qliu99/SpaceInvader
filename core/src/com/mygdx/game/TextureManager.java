package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	
	public static Texture PLAYER=new Texture(Gdx.files.internal("player.png"));
	public static Texture ENEMY=new Texture(Gdx.files.internal("enemy.png"));
	public static Texture MISSLE=new Texture(Gdx.files.internal("missle.png"));
	public static Texture GAME_OVER=new Texture(Gdx.files.internal("gameover_lose.png"));
	public static Texture GAME_WON=new Texture(Gdx.files.internal("gameover_won.png"));

}
