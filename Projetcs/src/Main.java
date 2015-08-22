import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        ImageIcon image = getPic("http://files.sharenator.com/67300.jpg");
        for(int i=0; i<1000;i++)
        {
            Test.main(args, image);
        }
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
