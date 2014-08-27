package com.expiredcode.ld.planetyarrr;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class World 
{
	MyUtils m = new MyUtils();
	int id,next;
	float spawnDelay,angle;
	World w;
	Collider c;
	Vector2 v,a,b;	
	Init i = new Init();
	Texture t;
	
	World(Texture tex,float x,float y,float w,float h,int id)
	{
		this.t = tex;
		c = new Collider("world",x,y,w,h);
		
		v = new Vector2(x,y);
		this.id = id;
		if(id == 5) next = 0;
		spawnDelay = 100;
	}
	
	public void update(float deltaTime)
	{
		if(spawnDelay>10)
		{
			spawnShip();
			next+=1;
			spawnDelay = 0;
		}
		
		if(next > 5) next = 0;
		spawnDelay += deltaTime;
	}
	
	void spawnShip()
	{
				
		a = new Vector2(c.x,c.y);		
		
		
		switch(next)
		{
			case 1:{
					if(id!=1)
					{
						b=m.world.get(0).v;
						angle = a.sub(b.x,b.y).angle();
						switch((int)Math.random()*2)
						{
							case 0: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b); break;
							case 1: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b); ///*break;
							/*case 2:*/ i.initFiveO(c.x+(c.width/2),c.y+(c.height/2),angle+180); break;							
						}
					}
				
				   }break;
			case 2:{
					if(id!=2)
					{	b=m.world.get(1).v;
						angle = a.sub(b.x,b.y).angle();
						switch((int)Math.random()*2)
						{
							case 0: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b); break;
							case 1: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b);/* break;
							case 2:*/ i.initFiveO(c.x+(c.width/2),c.y+(c.height/2),angle+180); break;							
						}
					}
				
					//					
			   }break;
			case 3:{
					if(id!=3)
					{	
						b=m.world.get(2).v;
						angle = a.sub(b.x,b.y).angle();
						switch((int)Math.random()*2)
						{
							case 0: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b); break;
							case 1: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b);/* break;
							case 2:*/ i.initFiveO(c.x+(c.width/2),c.y+(c.height/2),angle+180); break;							
						}
					}
					//i.initFiveO(c.x, c.y,angle);					
		   }break;
			case 4:{
					if(id!=4)
					{	
						b=m.world.get(3).v;
						angle = a.sub(b.x,b.y).angle();
						switch((int)Math.random()*2)
						{
							case 0: //i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b); break;
							case 1: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b);/* break;
							case 2:*/ i.initFiveO(c.x+(c.width/2),c.y+(c.height/2),angle+180); break;							
						}
					}							
		   }break;
			case 5:{
					if(id!=5)
					{	
						b=m.world.get(4).v;
						angle = a.sub(b.x,b.y).angle();
						switch((int)Math.random()*2)
						{
							case 0: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b); break;
							case 1: i.initCargo(c.x+(c.width/2),c.y+(c.height/2),angle+180,b);/* break;
							case 2:*/ i.initFiveO(c.x+(c.width/2),c.y+(c.height/2),angle+180); break;							
						}
					}									
		   }break;
		}
	}
}
