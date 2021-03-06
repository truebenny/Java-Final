import javafx.scene.shape.Rectangle;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle {
    private Pong pong;
    private static final double width = 20, height = 80;
    private double x, y, p2Width, p2Height;
    private double speed = 5;
    private double yChange = 0;

    public Paddle(Pong pong, double x, double y, double p2Width, double p2Height, boolean ai) {
        this.pong = pong;
        this.p2Width = p2Width;
        this.p2Height = p2Height;
        this.x = x;
        this.y = y;
    }
    public void move(double direction, boolean down) {
        if (down == true) {
            yChange = speed * direction;
        }
        else {
            yChange = 0;
        }
    }
    public void update() {
        y += yChange;
        if (y <= 0) {
            y = 0;
        }
        else if (y >= p2Height - height) {
            y = p2Height - height;
        }
    }
    public void paint(GraphicsContext pen) {
        pen.setFill(Color.WHITE);
        pen.fillRect(x, y, width, height);
    }

    public double getMovement() {
        return yChange;
    }
    public double getXPos() {
        return x;
    }
    public double getWidth() {
        return width;
    }

    public Bounds getBounds() {
        Rectangle rect = new Rectangle(x, y, width, height);
        Bounds rectBounds = rect.getBoundsInParent();
        return rectBounds;
    }
}
