package advjava_2022.finalproject;

import com.diozero.ws281xj.LedDriverInterface;
import com.diozero.ws281xj.rpiws281x.WS281x;

public class TurnSignalBlinker {
	
	int brightness = 64;
	int numPixels = 8;
	int gpio = 18;
	LedDriverInterface led = new WS281x(gpio, brightness, numPixels);

	public void blinkLeft() {
		//Turn on LEDs 5 and 6 with an orange color.
		led.setPixelColourRGB(5, 255, 35, 0);
		led.setPixelColourRGB(6, 255, 35, 0);
		led.render();
		System.out.println("LEDs on");
	}
	
	public void blinkRight() {
		//Turn on LEDs 0 and 3 with an orange color.
		led.setPixelColourRGB(0, 255, 35, 0);
		led.setPixelColourRGB(3, 255, 35, 0);
		led.render();
		System.out.println("LEDs on");
	}
	
	public void off() {
		//Turn off LEDs
		led.allOff();
		System.out.println("LEDs off");
	}
}
