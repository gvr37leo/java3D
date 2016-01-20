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
                Intersectable hitObject = castRay(new Vector(x-20, y-20, z + 20),scene);
                if(hitObject == null){
                    image[y][x] = new GColor(255,255,255);
                }else{
                    image[y][x] = hitObject.color;
                }
            }
        }
        return image;
    }

//    public src.GColor castRay(src.Vector P, src.Scene scene){
//        src.Vector closest = new src.Vector(0,0,99999999);
//        src.GColor color = new src.GColor(255,255,255);
//        for(int i = 0;i < scene.objects.size(); i ++){
//            src.Vector intersection = src.Vector.getPlaneIntersect(this,P,scene.objects.get(i));
//            if(intersection.isInTriangle(scene.objects.get(i))){
//                if(intersection.calcLength() < closest.calcLength()){
//                    closest = intersection;
//                    color = scene.objects.get(i).color;
//                }
//            }
//        }
//        return color;
//    }
}
