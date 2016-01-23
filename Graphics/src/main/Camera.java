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
//                Intersectable hitObject = castRay(generateCameraRay(x, y),scene);
                Intersectable hitObject = castRay(new Vector(x-20 + this.x, y-20 + this.y , z + 20),scene);
                if(hitObject == null){
                    image[y][x] = new GColor(255,255,255);
                }else{
                    image[y][x] = hitObject.color;
                    castRay(new Vector(x-20 + this.x, y-20 + this.y , z + 20),scene);//for testing purposes
                    //looks like the casted ray may always be pointed from origin
                    //but why does it work with triangles?
                }
            }
        }
        return image;
    }

    private Vector generateCameraRay(int x, int y){
        double rasterX = x * 2 / resolutionWidth - 1;
        double rasterY = y * 2 / resolutionWidth - 1;
        Vector direction = new Vector(this.x + rasterX, this.y + rasterY, this.z + 1);
        return direction;
    }
}
