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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new Test().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 490);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(new Random().nextInt((int)d.getWidth()), new Random().nextInt((int)d.getHeight()));
    }

    public Test() {

        String Url = "http://files.sharenator.com/67300.jpg";
        ImageIcon img = getPic(Url);
        lbl1.setIcon(img);

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

//    public void JSONstuff(String code)
//    {
//        JSONParser parser=new JSONParser();
//        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
//        try{
//            Object obj = parser.parse(s);
//            JSONArray array = (JSONArray)obj;
//            System.out.println("The 2nd element of array");
//            System.out.println(array.get(1));
//            System.out.println();
//
//            JSONObject obj2 = (JSONObject)array.get(1);
//            System.out.println("Field \"1\"");
//            System.out.println(obj2.get("1"));
//
//            s = "{}";
//            obj = parser.parse(s);
//            System.out.println(obj);
//
//            s= "[5,]";
//            obj = parser.parse(s);
//            System.out.println(obj);
//
//            s= "[5,,2]";
//            obj = parser.parse(s);
//            System.out.println(obj);
//        }catch(ParseException pe){
//            System.out.println("position: " + pe.getPosition());
//            System.out.println(pe);
//        }
//    }
    public String getJSON(String Url)
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        String output="";

        try {
            url = new URL(Url);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                output+=line;
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return output;
    }
}
