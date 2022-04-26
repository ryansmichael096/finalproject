package advjava_2022.finalproject;

public class TurnSignalMain {

	public static void main(String[] args) throws InterruptedException {
			//Create object using TurnSignalSensor
		TurnSignalSensor sensor = new TurnSignalSensor();
		
			//Loop this block of code until the program is stopped.
		while (true) {
			
				//Create object using TurnSignalBlinker
			TurnSignalBlinker blink = new TurnSignalBlinker();
			
				//Assign the return from the sense method in the TurnSignalSensor class to a variable
			String direction = sensor.sensor();
			
				//Print the direction the robot is moving to the console.
			System.out.println("Direction?: " + direction);
			
			if (direction=="left") {
					//Call blinkLeft method if sensor reports left movement
				blink.blinkLeft();
			} 
			else if (direction=="right") {
					//Call blinkRight method if sensor reports right movement
				blink.blinkRight();
			} 
			else {
					//If not moving left or right, turn off LEDs.
				blink.off();
			}
			
				//Wait 500 milliseconds before repeating code
			Thread.sleep(500);
			
				//Clear console
			System.out.print("\033\143");
		}

	}

}
