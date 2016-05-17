package file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * <b>screenshot is a Javabean used to take a screenshot.</b>
 *
 * @author Lempereur
 *
 * @see Serializable
 *
 * @version 1.0
 */
@SuppressWarnings("unused")
public class screenshot implements Serializable {
    private String _path;

    public screenshot() { _path = null; }

    public void take() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot;
        try {
            robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            ImageIO.write(image, "png", new File(_path));
        } catch (AWTException | IOException e1) {
            e1.printStackTrace();
        }
    }

    public String get_path() {
        return _path;
    }

    public void set_path(String _path) {
        this._path = _path;
    }
}