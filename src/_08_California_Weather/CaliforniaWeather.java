package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 =new JButton();
    HashMap<String, WeatherData> weatherData;
    void start() {
     weatherData = Utilities.getWeatherData();
        frame.setVisible(true);
        frame.add(panel);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        b1.setText("Check a city's weather conditions");
        b2.setText("Check which cities have a certain kind of weather");
        b3.setText("Check which cities are within a certain temperature range");   
        frame.pack();
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        // All city keys have the first letter capitalized of each word
       /* String cityName = Utilities.capitalizeWords( "National City" );
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
            }
        */
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			String cityName= JOptionPane.showInputDialog( "Input the part of San Diego you want to know the weather of.");
			//cityName = Utilities.capitalizeWords( cityName);
	        WeatherData datum = weatherData.get(cityName);
	        
	        if( datum == null ) {
	        JOptionPane.showMessageDialog(null, "Unable to find weather data for: " + cityName);
	        } else {
	            JOptionPane.showMessageDialog(null, cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
	            }
		}
		if(e.getSource()==b2) {
			String weather= JOptionPane.showInputDialog( "Want to stay in the sun? Just, enter 'clear' and you'll see where in San Diego its sunny.");
			ArrayList<String> al = new ArrayList<String>();
			for (String key : weatherData.keySet()) {
			     if(weatherData.get(key).weatherSummary.equals(weather)) {
			    	al.add(key);
			    
			     }
			    System.out.println(key);
			    System.out.println(weatherData.get(key).weatherSummary);
			} 
			 if(al.size()>0) {
		    	 JOptionPane.showMessageDialog(null, al);
		     }
			 else{
				   JOptionPane.showMessageDialog(null, "Unable to find weather data for: " + weather);
			 }
		}
		
	}
}
