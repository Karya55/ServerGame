package ball;

import java.io.Serial;
import java.io.Serializable;

import java.awt.Color;

public class BallDTO implements Serializable {
	public float x, y;
	public float speedX, speedY;
	public float radius;
	public Color color;
	@Serial
	private static final long serialVersionUID = 1000;

	public BallDTO(float x, float y, float speedX, float speedY, float radius, Color color) {

		this.x = x;
		this.y = y;

		this.speedX = speedX;
		this.speedY = speedY;
		this.radius = radius;
		this.color = color;

	}
}