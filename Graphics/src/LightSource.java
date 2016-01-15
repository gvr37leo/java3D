public class LightSource {
    public double brightness;
    public GColor color;

    public LightSource(double brightness, GColor color) {
        this.brightness = brightness;
        this.color = color;
    }

    public LightSource(){
        this(1,new GColor());
    }
}
