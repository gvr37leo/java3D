package main;

public class LightSource extends Vector{
    public double brightness;
    public GColor color;

    public LightSource(double brightness, GColor color) {
        super(0,0,0);
        this.brightness = brightness;
        this.color = color;
    }

    public LightSource(){
        this(1,new GColor());
    }
}
