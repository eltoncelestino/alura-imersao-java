import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
  
  public void create(InputStream inputStream, String fileName) throws Exception {

    // InputStream inputStream = new FileInputStream(new File("assets/naruto.jpg"));
    // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BY2Q2NDI1MjUtM2Q5ZS00MTFlLWJiYWEtNTZmNjQ3OGJkZDgxXkEyXkFqcGdeQXVyNTI4MjkwNjA@.jpg").openStream();
    BufferedImage original = ImageIO.read(inputStream);
    
    int width = original.getWidth();
    int height = original.getHeight();
    int newHeight = height + 200;

    BufferedImage newImage = new BufferedImage(height, newHeight, BufferedImage.TRANSLUCENT);
    
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();

    graphics.drawImage(original, 0, 0, null);

    var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.LIGHT_GRAY);
    graphics.setFont(font);

    graphics.drawString("TopZera", 200, newHeight - 100);

    File file = new File(fileName);
    file.mkdirs();

    ImageIO.write(newImage, "png", file);

  }

}
