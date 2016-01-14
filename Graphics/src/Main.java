//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//public class Main extends JFrame implements ActionListener{
//
//    public int x = 0;
//    public Timer timer = new Timer(1000/60,this);
//
//    public Main(){
//        Scene scene = new Scene();
//        Vector A = new Vector(-5,0,10);
//        Vector B = new Vector(0,5,10);
//        Vector C = new Vector(5,0,10);
//        Triangle triangle = new Triangle(A,B,C);
//        triangle.centroid = new Vector(0,0,10);
//        triangle.color = new GColor(255,0,0);
//        scene.objects.add(triangle);
//
//        Vector A2 = new Vector(-5,0,8);
//        Vector B2 = new Vector(0,5,8);
//        Vector C2 = new Vector(5,0,8);
//        Triangle triangle2 = new Triangle(A2,B2,C2);
//        triangle2.centroid = new Vector(0,0,8);
//        scene.objects.add(triangle2);
//        Camera camera = new Camera();
//
//        this.setSize(500,500);
//        this.setVisible(true);
//        timer.start();
//    }
//
//    public static void main(String[] args) {
//        Main main = new Main();
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.WHITE);
//        g.fillRect(0,0,500,500);
//        g.setColor(Color.BLACK);
//        g.fillRect (x+20,33,10,10);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        repaint();
//        x++;
//    }
//}

import processing.core.PApplet;

public class Main extends PApplet{

    static public void main(String args[]) {
        PApplet.main(new String[] { "Main" });
    }

    public void setup(){

    }

    public void draw(){
        rect(mouseX,mouseY,10,10);
    }
}