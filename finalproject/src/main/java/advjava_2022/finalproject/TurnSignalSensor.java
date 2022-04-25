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
			blink.off();
			int c0 = sensor.getDutyUs(0);
			int c1 = sensor.getDutyUs(1);
			int c2 = sensor.getDutyUs(2);
			int c3 = sensor.getDutyUs(3);
			int c4 = sensor.getDutyUs(4);
			int c5 = sensor.getDutyUs(5);
			int c6 = sensor.getDutyUs(6);
			int c7 = sensor.getDutyUs(7);
			System.out.println("Channel 0: " + c0);
			System.out.println("Channel 1: " + c1);
			System.out.println("Channel 2: " + c2);
			System.out.println("Channel 3: " + c3);
			System.out.println("Channel 4: " + c4);
			System.out.println("Channel 5: " + c5);
			System.out.println("Channel 6: " + c6);
			System.out.println("Channel 7: " + c7);
			
				if (c0>19000) {
					System.out.println("Direction: Idle");
				}
					else if ((c0>7000)&&(c1==0)&&(c2==0)&&(c3>7000)&&(c4>7000)&&(c5==0)&&(c6>7000)&&(c7==0)) {
						System.out.println("Direction: Forward");
					}
					else if ((c0>c4)&&(c1==0)&&(c2==0)&&(c3>c6)&&(c4<7000)&&(c5==0)&&(c6<7000)&&(c7==0)) {
						System.out.println("Direction: Right-forward (O1)");
						blink.blinkRight();
					}
					else if ((c0>c5)&&(c1==0)&&(c2==0)&&(c3>c7)&&(c4==0)&&(c6==0)) {
						System.out.println("Direction: Right (O2)");
						blink.blinkRight();
					}
					else if ((c0==0)&&(c1>c4)&&(c2>c6)&&(c3==0)&&(c5==0)&&(c7==0)) {
						System.out.println("Direction: Right (O3)");
						blink.blinkRight();
					}
					else if ((c0==0)&&(c1>c5)&&(c2>c7)&&(c3==0)&&(c4==0)&&(c5<7000)&&(c6==0)&&(c7<7000)) {
						System.out.println("Direction: Reverse-right (O4)");
						blink.blinkRight();
					}
					else if ((c0==0)&&(c1>7000)&&(c2>7000)&&(c3==0)&&(c4==0)&&(c5>7000)&&(c6==0)&&(c7>7000)) {
						System.out.println("Direction: Reverse");
						blink.blinkReverse();
					}
					else if ((c0==0)&&(c1<7000)&&(c1<c5)&&(c2<7000)&&(c2<c7)&&(c3==0)&&(c4==0)&&(c6==0)) {
						System.out.println("Direction: Reverse-left (O5)");
						blink.blinkLeft();
					}
					else if ((c0<c5)&&(c1==0)&&(c2==0)&&(c3<c7)&&(c4==0)&&(c6==0)) {
						System.out.println("Direction: Left (O6)");
						blink.blinkLeft();
					}
					else if ((c0==0)&&(c1<c4)&&(c2<c6)&&(c3==0)&&(c5==0)&&(c7==0)) {
						System.out.println("Direction: Left (O7)");
						blink.blinkLeft();
					}
					else if ((c0<7000)&&(c0<c4)&&(c3<7000)&&(c3<c6)&&(c4>10000)&&(c5==0)&&(c7==0)) {
						System.out.println("Direction: Left-forward (O8)");
						blink.blinkLeft();
					}
				Thread.sleep(500);
				System.out.print("\033\143");
				blink.off();
		}
	}
}
