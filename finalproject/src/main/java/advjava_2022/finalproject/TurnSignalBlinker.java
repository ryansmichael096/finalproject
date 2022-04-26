package advjava_2022.finalproject;

import com.diozero.ws281xj.LedDriverInterface;
import com.diozero.ws281xj.rpiws281x.WS281x;
import com.diozero.ws281xj.PixelAnimations;

public class TurnSignalBlinker {
		//Create variables to define LED driver parameters, then create LED driver object.
	int brightness = 64;
	int numPixels = 8;
	int gpio = 18;
	LedDriverInterface led = new WS281x(gpio, brightness, numPixels);
	
	public void blinkRight() {
			//Set LEDs 0 and 6 to orange, then render
		led.setPixelColourRGB(0, 255, 35, 0);
		led.setPixelColourRGB(6, 255, 35, 0);
		led.render();
		System.out.println("Right LEDs on");
		
			//Wait 500 milliseconds
		PixelAnimations.delay(500);
		
			//Turn off LEDs
		led.allOff();
		System.out.println("Right LEDs off");
		led.close();
	}
	
	public void blinkLeft() {
			//Set LEDs 5 and 3 to orange, then render
		led.setPixelColourRGB(5, 255, 35, 0);
		led.setPixelColourRGB(3, 255, 35, 0);
		led.render();
		System.out.println("Left LEDs on");
		
			//Wait 500 milliseconds
		PixelAnimations.delay(500);
		
			//Turn off LEDs
		led.allOff();
		System.out.println("Left LEDs off");
		led.close();
	}
	
	public void off() {
			//Turn off LEDs
		led.allOff();
		led.close();
	}
	
}
