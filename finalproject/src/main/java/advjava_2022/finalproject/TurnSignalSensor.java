package advjava_2022.finalproject;

import com.diozero.devices.PCA9685;

public class TurnSignalSensor {
	
	public static void main(String[] args) throws InterruptedException {
		//Create object using PCA9685 class.
		PCA9685 sensor = new PCA9685(50);
		
		//Assign duty cycle values to variables.
		int c0 = sensor.getDutyUs(0);
		int c1 = sensor.getDutyUs(1);
		int c2 = sensor.getDutyUs(2);
		int c3 = sensor.getDutyUs(3);
		int c4 = sensor.getDutyUs(4);
		int c5 = sensor.getDutyUs(5);
		int c6 = sensor.getDutyUs(6);
		int c7 = sensor.getDutyUs(7);
		
		//Display duty cycle values for channels 0 through 7.
		while(true) {
			System.out.println("Channel 0: " + sensor.getDutyUs(0));
			System.out.println("Channel 1: " + sensor.getDutyUs(1));
			System.out.println("Channel 2: " + sensor.getDutyUs(2));
			System.out.println("Channel 3: " + sensor.getDutyUs(3));
			System.out.println("Channel 4: " + sensor.getDutyUs(4));
			System.out.println("Channel 5: " + sensor.getDutyUs(5));
			System.out.println("Channel 6: " + sensor.getDutyUs(6));
			System.out.println("Channel 7: " + sensor.getDutyUs(7));
			System.out.println();
			Thread.sleep(1000);
		}
		
	}

}
