package _08_California_Weather;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * See instructions in the CaliforniaWeather.java class
 */
public class CaliforniaWeatherRunner {
    
    public static void main(String[] args) {
        new CaliforniaWeather().start();
        JFrame frame = new JFrame();
        JPanel panel=new JPanel();
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        frame.setVisible(true);
        frame.add(panel);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
    }
}
