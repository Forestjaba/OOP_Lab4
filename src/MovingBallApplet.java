import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MovingBallApplet extends JComponent implements ActionListener {
    private int x = 0; // координата x шара
    private int y = 0; // координата y шара
    private int radius = 50; // радиус шара
    private int dx = 5; // скорость движения шара по оси x
    private int dy = 5; // скорость движения шара по оси y

    public MovingBallApplet() {
        Timer timer = new Timer(50, this); // создаем таймер с интервалом 50 мс
        timer.start(); // запускаем таймер
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, radius, radius); // рисуем шар
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 200); // задаем желаемый размер апплета
    }

    public void actionPerformed(ActionEvent e) {
        x += dx; // изменяем координату x шара
        y += dy; // изменяем координату y шара

        // если шар достиг границы апплета, меняем направление движения
        if (x + radius > getWidth() || x < 0) {
            dx = -dx;
        }
        if (y + radius > getHeight() || y < 0) {
            dy = -dy;
        }

        repaint(); // перерисовываем апплет
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Ball Applet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MovingBallApplet());
        frame.pack();
        frame.setVisible(true);
    }
}
