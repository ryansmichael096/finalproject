package advjava_2022.finalproject;

import com.diozero.devices.PCA9685;

public class TurnSignalSensor {
	
	public static void main(String[] args) throws InterruptedException {
		//Create object using PCA9685 class.
		@SuppressWarnings("resource")
		PCA9685 sensor = new PCA9685(50);
		TurnSignalBlinker blink = new TurnSignalBlinker();
	
		//Call TurnSignalBlinker class if motors indicate a right or left turn.
		while(true) {
			int c0 = sensor.getDutyUs(0);
			int c1 = sensor.getDutyUs(1);
			System.out.println("Channel 0: " + c0);
			System.out.println("Channel 1: " + c1);
			if (c1==7324) {
				blink.blinkLeft();
				System.out.println("Signaling left turn.");
			}
			else if(c0==9765) {
				blink.blinkRight();
				System.out.println("Signaling right turn.");
			}
			Thread.sleep(500);
			blink.off();
		}
	}
}
