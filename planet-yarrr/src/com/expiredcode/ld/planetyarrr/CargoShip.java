package com.expiredcode.ld.planetyarrr;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CargoShip extends Ship
{
	

	CargoShip(Sprite s, float angle, float speed) {
		super(s, angle, speed);
		// TODO Auto-generated constructor stub
		this.healt=40;
		goal = new Vector2();
	}
	
	@Override
	public void update(float deltaTime)
	{
		ship.setPosition(ship.getX()+(float)((speed*deltaTime)*Math.cos(angle*MathUtils.degreesToRadians)),
				ship.getY()+(float)((speed*deltaTime)*Math.sin(angle*MathUtils.degreesToRadians)));
	}

}
