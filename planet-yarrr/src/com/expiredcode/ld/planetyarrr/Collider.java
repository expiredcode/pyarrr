package com.expiredcode.ld.planetyarrr;


public class Collider 
{
	public String name;
	public float x,y,width,height;	
	float angle;
	float time;

	
	public Collider(String n,float xx,float yy,float w,float h)
	{
		this.name=n;
		this.x=xx;
		this.y=yy;
		this.width=w;
		this.height=h;
	}
	
}
