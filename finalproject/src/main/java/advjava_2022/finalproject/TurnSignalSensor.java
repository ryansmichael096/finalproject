package advjava_2022.finalproject;

import com.diozero.devices.PCA9685;

public class TurnSignalSensor {
		//Create object using PCA9685 class.
	PCA9685 sensor = new PCA9685(50);
	
		//Create variables to be used to store PWM output values
	int c0, c1, c2, c3, c4, c5, c6, c7;
	
	public String sensor() {
			//Create string variable to be used as return
		String direction;
		
				//Assign PWM outputs to integer variables
		c0 = sensor.getDutyUs(0);
		c1 = sensor.getDutyUs(1);
		c2 = sensor.getDutyUs(2);
		c3 = sensor.getDutyUs(3);
		c4 = sensor.getDutyUs(4);
		c5 = sensor.getDutyUs(5);
		c6 = sensor.getDutyUs(6);
		c7 = sensor.getDutyUs(7);
			
			//Diagnostic code for reading raw PWM outputs from the PCA9685 chip
		/*System.out.println("Channel 0: " + c0);
		System.out.println("Channel 1: " + c1);
		System.out.println("Channel 2: " + c2);
		System.out.println("Channel 3: " + c3);
		System.out.println("Channel 4: " + c4);
		System.out.println("Channel 5: " + c5);
		System.out.println("Channel 6: " + c6);
		System.out.println("Channel 7: " + c7);*/
			
			if (c0>19000) {	//Checks all 8 motor control signals to determine which direction robot is moving
				direction = "idle";
			}
				else if ((c0>7000)&&(c1==0)&&(c2==0)&&(c3>7000)&&(c4>7000)&&(c5==0)&&(c6>7000)&&(c7==0)) {					
					direction = "forward";
				}
				else if ((c0>c4)&&(c1==0)&&(c2==0)&&(c3>c6)&&(c4<7000)&&(c5==0)&&(c6<7000)&&(c7==0)) {
					direction = "right";
				}
				else if ((c0>c5)&&(c1==0)&&(c2==0)&&(c3>c7)&&(c4==0)&&(c6==0)) {
					direction = "right";
				}
				else if ((c0==0)&&(c1>c4)&&(c2>c6)&&(c3==0)&&(c5==0)&&(c7==0)) {
					direction = "right";
				}
				else if ((c0==0)&&(c1>c5)&&(c2>c7)&&(c3==0)&&(c4==0)&&(c5<7000)&&(c6==0)&&(c7<7000)) {
					direction = "right";
				}
				else if ((c0==0)&&(c1>7000)&&(c2>7000)&&(c3==0)&&(c4==0)&&(c5>7000)&&(c6==0)&&(c7>7000)) {
					direction = "reverse";
				}
				else if ((c0==0)&&(c1<7000)&&(c1<c5)&&(c2<7000)&&(c2<c7)&&(c3==0)&&(c4==0)&&(c6==0)) {
					direction = "left";
				}
				else if ((c0<c5)&&(c1==0)&&(c2==0)&&(c3<c7)&&(c4==0)&&(c6==0)) {
					direction = "left";
				}
				else if ((c0==0)&&(c1<c4)&&(c2<c6)&&(c3==0)&&(c5==0)&&(c7==0)) {
					direction = "left";
				}
				else if ((c0<7000)&&(c0<c4)&&(c3<7000)&&(c3<c6)&&(c4>10000)&&(c5==0)&&(c7==0)) {
					direction = "left";
				}
				else {
					direction = "unknown";
				}
				
			//Diagnostic code for checking direction variable within the class
		//System.out.println("Direction@sensor?: " + direction);
				
		return direction;
	}
	
}
