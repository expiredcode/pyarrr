package com.expiredcode.ld.planetyarrr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

public class PlayerShip extends Ship 
{
	MyUtils m = new MyUtils();
	
	float angleSpeed; 
	float fireDelay;
	float money;

	PlayerShip(Sprite s, float angle, float speed,float angleSpeed) 
	{
		super(s, angle, speed);
		this.angleSpeed = angleSpeed;
		this.healt = 100;
	}
	
	@Override
	public void update(float deltaTime)  
	{
		if(currentSpeed>0)
		{						//Trovo la direzione della navicella usando l'angolo 
			ship.setPosition(ship.getX()+(float)((currentSpeed*deltaTime)*Math.cos(angle*MathUtils.degreesToRadians)),
					ship.getY()+(float)((currentSpeed*deltaTime)*Math.sin(angle*MathUtils.degreesToRadians)));
			
			currentSpeed -= 150*deltaTime;			//diminuisco la velocità per uno stop elastico
		}
		if(currentSpeed<20) currentSpeed = 0;		//fermo la navicella se già abbastanza lenta
	}	
	
	public void rotateLeft(float deltaTime)
	{
		this.angle+=angleSpeed*deltaTime;
		if(this.angle>360) this.angle -= 360;
	}
	public void rotateRight(float deltaTime)
	{
		this.angle-=angleSpeed*deltaTime;
		if(this.angle<0) this.angle += 360;
	}
	
	public boolean fire(float deltaTime)
	{
		if(fireDelay>0.3)
		{
			c = new Collider("laser",ship.getX(),ship.getY(),1,7);
			c.angle = angle;
			m.pfire.add(c);
			fireDelay = 0;
		//	Gdx.app.log("p", "fire");
			return true;
		}
		fireDelay+=deltaTime;
		return false;
	}

}
