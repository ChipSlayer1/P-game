import processing.core.PApplet;
import java.util.ArrayList;

// class that actually runs it all
public class App extends PApplet{
	
	private ArrayList<Button> btns = new ArrayList<>();
	
	// sets the size of the thing
	public void settings() {
		size(1000, 500);
		btns.add(new Button(this, 100, 100, "Label"));
		//cursor("none");
	}
	
	// create vars for needs
	float yPos = 0;
	float ySpeed = 0;
	
	public void fall() {
		fill(255, 255, 255);
		noStroke();
		ellipse(width/2, yPos, 50, 50);
		
		yPos += ySpeed;
		
		ySpeed += 0.25;
		
		if(yPos + 25 >= height) {
			yPos = height - 25;
			ySpeed = -ySpeed + 1;
		}
		
	}
	
	// the draw function
	public void draw() {
		background(255, 0, 0);
		fill(0, 0, 255);
		ellipse(mouseX, mouseY, 10, 10);
		
		fill(255, 255, 255);
		//textAlign(CENTER);
		text(mouseX + ", " + mouseY, width/2, height/2);
		
		// call function for each button
		for(Button b : btns) {
			textAlign(CENTER);
			b.render();
			textAlign(LEFT, TOP);
		}
		
		fall();
	}

	public void mouseClicked() {
		for(Button b : btns) {
			b.click(yPos, 0);
			b.click(ySpeed, 0);
		}
	}
	
	// run applet sketch
	public static void main(String[] args) {
		String[] processingArgs = {"App"};
		App mySketch = new App();
		PApplet.runSketch(processingArgs, mySketch);
	}
}