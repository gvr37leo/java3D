package main;

public class Camera extends Vector{

    public double yaw;
    public double pitch;
    public double roll;
    public int resolutionWidth = 40;
    public int resolutionHeight = 40;

    public Camera() {
        super(0, 0, 0);
        this.yaw = 0;
        this.pitch = 0;
        this.roll = 0;
    }

    public GColor[][] generateImage(Scene scene){
        GColor[][] image = new GColor[resolutionHeight][resolutionWidth];
        for(int x = 0; x < resolutionWidth; x ++){
            for(int y = 0; y < resolutionHeight; y++){
                Intersectable hitObject = castRay(generateCameraRay(x, y).add(this),scene);
                if(hitObject == null){
                    image[y][x] = new GColor(255,255,255);
                }else{
                    image[y][x] = hitObject.color;
//                    castRay(new Vector(x-20 + this.x, y-20 + this.y , z + 20),scene);//for testing purposes
                }
            }
        }
        return image;
    }

    /** x and y are pixel coordinates (doesnt return a normal vector but adds the position of the camera)**/
    public Vector generateCameraRay(int x, int y){
        double rasterX = x * 2 / (double)resolutionWidth - 1;
        double rasterY = 1 - y * 2 / (double)resolutionWidth;
        return new Vector(rasterX,rasterY,1).normalize().rotate(pitch,yaw,roll,new Vector(0,0,0));
    }
}
