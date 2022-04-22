package advjava_2022.finalproject;

import com.diozero.ws281xj.LedDriverInterface;
import com.diozero.ws281xj.PixelAnimations;
import com.diozero.ws281xj.rpiws281x.WS281x;

public class TurnSignalBlinker {
	
	int brightness = 64;
	int numPixels = 8;
	int gpio = 18;
	LedDriverInterface led = new WS281x(gpio, brightness, numPixels);

	public void blinkLeft() {
		System.out.println("Signaling left turn.");
		
		//Blink LEDs 3 times with an orange color, delay of 750 milliseconds.
		for(int rep=0; rep<=1; rep++) {
			led.setPixelColourRGB(5, 255, 35, 0);
			led.setPixelColourRGB(6, 255, 35, 0);
			led.render();
			System.out.println("LEDs on");
			PixelAnimations.delay(500);
			led.allOff();
			System.out.println("LEDs off");
		}
	}
	
	public void blinkRight() {
		System.out.println("Signaling right turn.");
		
		//Blink LEDs 3 times with an orange color, delay of 750 milliseconds.
		for(int rep=0; rep<=1; rep++) {
			led.setPixelColourRGB(0, 255, 35, 0);
			led.setPixelColourRGB(3, 255, 35, 0);
			led.render();
			System.out.println("LEDs on");
			PixelAnimations.delay(500);
			led.allOff();
			System.out.println("LEDs off");
		}
	}
	
	public void off() {
		//Turn off LEDs
		led.allOff();
	}
}
