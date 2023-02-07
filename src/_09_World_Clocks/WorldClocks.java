package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	 HashMap<String, TimeZone> hm;
    ClockUtilities clockUtil;
    Timer city1Timer;
    TimeZone timeZone;

    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    
    String city;
    String dateStr;
    String timeStr;
    
    ClockUtilities cu;
    Timer city2Timer;
    TimeZone tz;

    JTextArea ta;
    
    String city2;
    String ds;
    String ts;
    
    public WorldClocks() {
        clockUtil = new ClockUtilities();

        // The format for the city must be: city, country (all caps)
        city = "Atlanta, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        
        Calendar calendar = Calendar.getInstance(timeZone);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        
        System.out.println(dateStr);

        // Sample starter program
        frame = new JFrame();
        panel = new JPanel();
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.add(panel);
        
        textArea = new JTextArea();
        panel.add(textArea);
        textArea.setText(city + "\n" + dateStr);
        city1Timer = new Timer(1000, this);
        city1Timer.start();
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      
        cu = new ClockUtilities();
       
        String cityName = JOptionPane.showInputDialog("enter a city name");
        TimeZone zone = cu.getTimeZoneFromCityName(cityName);
        hm.put(cityName, zone);
        
        city2 = "cityName";
        tz = cu.getTimeZoneFromCityName(city2);
        
        Calendar c2 = Calendar.getInstance(tz);
        String month2 = c2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek2 = c2.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        ds = dayOfWeek2 + " " + month2 + " " + c2.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        
        ta = new JTextArea();
        panel.add(ta);
        ta.setText(city2 + "\n" + ds);
        city2Timer = new Timer(1000, this);
        city2Timer.start();
    }
   
    	
    
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
        textArea.setText(city + "\n" + dateStr + "\n" + timeStr);
        frame.pack();
        
        
        Calendar c2 = Calendar.getInstance(tz);
        String militaryTime2 = c2.get(Calendar.HOUR_OF_DAY) + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND);
        String twelveHourTime2 = " [" + c2.get(Calendar.HOUR) + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND) + "]";
        ts = militaryTime2 + twelveHourTime2;
        
        ta.setText(city2 + "\n" + ds + "\n" + ts);
        frame.pack();
    }
}





