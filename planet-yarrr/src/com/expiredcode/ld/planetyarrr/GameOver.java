package com.expiredcode.ld.planetyarrr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
//import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class GameOver extends GameScreen{
	
	int WORLD_WIDTH = 800, WORLD_HEIGHT = 480;

	SpriteBatch batcher;
	float x,y;
	boolean done=false,end=false;
	Texture menu;
	float enddelta=0;
	
	MyUtils myu=new MyUtils();
	
	OrthographicCamera camera;

	
	GameOver()
	{
		menu = new Texture(Gdx.files.internal("data/go.png"));
		batcher = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
	}
	

	@Override
	public void render(float deltatime)
	{
		update();
		// tell the camera to update its matrices.
		camera.update();  
	
		// tell the SpriteBatch to render in the coordinate system specified by the camera.
		batcher.setProjectionMatrix(camera.combined);
		
		if(end&&enddelta>1)
			done=true;
		else
			enddelta+=deltatime;
		
		//setting up draw queue
		batcher.begin();
		batcher.draw(menu, 0, 0);
		batcher.end();
	}
	
	void update(){
		if(Gdx.input.isTouched())
		{
		/*	x=Gdx.input.getX();
			y=WORLD_HEIGHT-Gdx.input.getY();*/
			
	/*		if(y>359 && y<423)
			{
				if(x>71 && x<135)//level1			
				{
					myu.screen=2;
					end=true;
				}else
					if(x>201&&x<265) //level2
					{
						myu.screen=3;
						end=true;
					}
			}else*/
			/*	if((x>235 && x<542))
					if((y>39&&y<94)) //back home
				{*/
					myu.screen=0;
					end=true;
			//	}
		//	Gdx.app.log("scr", ""+myu.screen);
		}
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return done;
	}

}
