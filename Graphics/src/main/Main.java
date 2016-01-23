package main;

import processing.core.PApplet;

public class Main extends PApplet{

    static public void main(String args[]) {
        PApplet.main(new String[] { "main.Main" });
    }

    Scene scene = new Scene();
    Vector A = new Vector(-5,0,10);
    Vector B = new Vector(0,5,10);
    Vector C = new Vector(5,0,10);
    Triangle triangle = new Triangle(A,B,C);

    Vector A2 = new Vector(-5,0,7.5);
    Vector B2 = new Vector(0,5,7.5);
    Vector C2 = new Vector(5,0,7.5);
    Triangle triangle2 = new Triangle(A2,B2,C2);

    Camera camera = new Camera();

    public void settings(){
        size(400,400);
    }

    public void setup(){
//        triangle.centroid = new Vector(0,0,10);
//        triangle.color = new GColor(255,0,0);
//        scene.objects.add(triangle);

//        triangle2.centroid = new Vector(0,0,7.5);
        scene.objects.add(triangle2);

        Sphere sphere = new Sphere(new Vector(0,0,10),3);
        sphere.color = new GColor(255,0,0);
        scene.objects.add(sphere);

        camera.z = 0;
        camera.y = 0;
    }

    public void draw(){
//        rect(0,0,width,height);
//        triangle.rotate(0,-0.01,0.03);
//        triangle2.rotate(0.03,0,0.01);
        drawImage(camera.generateImage(scene));

    }

    public void drawImage(GColor[][] image){
        for(int x = 0; x < image.length; x ++) {
            for (int y = 0; y < image[0].length; y++) {
                fill(image[y][x].R,image[y][x].G,image[y][x].B);
                rect(x * 10, y * 10,40,40);
            }
        }
        fill(0);
    }

    public void keyPressed(){
        switch (key){
            case 'w': camera.y++;
                break;
            case 's': camera.y--;
                break;
            case 'a': camera.x--;
                break;
            case 'd': camera.x++;
                break;
            case 'r': camera.z++;
                break;
            case 'f': camera.z--;
                break;
        }
    }
}