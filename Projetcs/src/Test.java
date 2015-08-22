import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Random;

/**
 * Created by woute on 16-8-2015.
 */
public class Test {
    private JPanel panel1;
    private JLabel lbl1;

    public static void main(String[] args, ImageIcon image) {
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new Test(image).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 490);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(new Random().nextInt((int)d.getWidth()), new Random().nextInt((int)d.getHeight()));
    }

    public Test(ImageIcon image) {

//        String Url = "http://files.sharenator.com/67300.jpg";
//        ImageIcon img = getPic(Url);
        lbl1.setIcon(image);

        //lbl1.setSize(img.getIconWidth(),img.getIconHeight());

    }
    public static ImageIcon getPic(String url)
    {
        Image image = null;
        try
        {
            URL Url = new URL(url);
            image = ImageIO.read(Url);
        }
        catch (IOException e)
        {
        }
        return new ImageIcon(image);
    }

}
