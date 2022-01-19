import processing.core.*;
public class Button {
	
	// declare private instance of sketch to use processing library
	private PApplet sketch;
	
	// declare private vars
	private int x;
	private int y;
	private String label;

	// constructor function
	public Button(PApplet sketch, int x, int y, String label) {
		this.sketch = sketch;
		this.x = x;
		this.y = y;
		this.label = label;
	}

	// return boolean whether mouse over button
	public boolean mouseOver() {
		if(Math.sqrt(((sketch.mouseX - this.x) * (sketch.mouseX - this.x)) + ((sketch.mouseY - this.y) * (sketch.mouseY - this.y))) < 25) {
			return true;
		} else{
			return false;
		}
	}
	
	// draw button
	public void render() {
		if(this.mouseOver()) {
			sketch.fill(0, 0, 255);
			sketch.ellipse(this.x, this.y, 50, 50);
			sketch.fill(255, 255, 255);
			sketch.text(this.label, this.x, this.y);
		} else{
			sketch.fill(0, 0, 0);
			sketch.ellipse(this.x, this.y, 50, 50);
			sketch.fill(255, 255, 255);
			sketch.text(this.label, this.x, this.y);
		}
	}

	// call button on mouse click
	public float click(float val1, float val2) {
		if(this.mouseOver()) {
			val1 = val2;
			return val1;
		} else{
			return val1;
		}
	}
}
