package com.expiredcode.ld.planetyarrr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

public class PoliceShip extends Ship
{
	MyUtils m = new MyUtils();
	
	boolean firing;
	float range = 200;
	float dist;
	float fireDelay;
	boolean cruise;
	Collider c;

	PoliceShip(Sprite s, float angle, float speed) 
	{
		super(s, angle, speed);
		// TODO Auto-generated constructor stub		
		healt = 50;
		
	}
	PoliceShip(Sprite s,float angle, float speed,boolean cr)
	{
		super(s, angle, speed);
		cruise = cr;
		healt = 50;
	}
	
	@Override
	public void update(float deltaTime)
	{
		if(cruise) moveForward();
		ship.setPosition(ship.getX()+(float)((currentSpeed*deltaTime)*Math.cos(angle*MathUtils.degreesToRadians)),
				ship.getY()+(float)((currentSpeed*deltaTime)*Math.sin(angle*MathUtils.degreesToRadians)));
				
		if(currentSpeed>0) currentSpeed -= 250*deltaTime;
		if(currentSpeed<20) currentSpeed = 0;	
		
		if(firing) fire(deltaTime);
		
		fireDelay+=deltaTime;
		//Gdx.app.log("police", "x:"+ship.getX()+"  y:"+ship.getY());
		if(cruise)
		if(ship.getX()<-5000||ship.getX()>5000||ship.getY()<-5000||ship.getY()>5000)
			angle+=180;
	}
	
	public void checkpersue(float x, float y)
	{
		dist = ((ship.getX()-x)*(ship.getX()-x))+((ship.getY()-y)*(ship.getY()-y)); //la distanza è al quadrato per evitare di fare la radice
		if((dist<range*range) && (dist>50*50)) 										//la moltiplicazione è molto più veloce, quindi faccio il quadrato
		{																			//degli altri fattori
			//persue = true; Gdx.app.log("police", "ON PERSUE");
			v.x=x;
			v.y=y;
			this.angle = v.sub(ship.getX(), ship.getY()).angle();
			moveForward();			
			firing = true;
			cruise = false;
		}else
			if((dist<range*range))
				firing = true;
			else
				{
					firing = false;
					cruise = true;
				}
	}
	
	public void fire(float deltaTime)
	{
		if(fireDelay>0.6)
		{
			c = new Collider("laser",ship.getX(),ship.getY(),1,7);
			c.angle = angle;
			m.enfire.add(c);
			fireDelay = 0;
		//	Gdx.app.log("p", "fire");
		}
		
	}
}
