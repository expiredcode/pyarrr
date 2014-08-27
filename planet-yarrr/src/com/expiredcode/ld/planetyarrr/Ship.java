package com.expiredcode.ld.planetyarrr;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship 
{
	float angle;
	float speed,currentSpeed;
	float healt;
	
	Collider c;
	
	Sprite ship;
	
	Vector2 goal;
	Vector2 v; // la uso per calcolare la direzione da far prendere alle navi della polizia
	
	Ship(Sprite s,float angle,float speed)
	{
		ship = s;
		this.angle = angle;
		this.speed = speed;
		
		v = new Vector2();
	}
	
	public void update(float deltaTime)
	{
		
	}
	
	public void moveForward()
	{
		currentSpeed = speed;
	}
	
	public void setAngle(float angle)
	{
		this.angle = angle;
	}	
	
	public void draw(SpriteBatch b)
	{
		ship.rotate(angle-90);
		ship.draw(b);
		ship.rotate(-(angle-90));
	}
	
	public void collisions()
	{
		
	}

}
