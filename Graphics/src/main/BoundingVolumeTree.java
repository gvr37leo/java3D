package main;

public class BoundingVolumeTree extends AABB {

    public Intersectable left;
    public Intersectable right;

    public BoundingVolumeTree(Vector A, Vector B) {
        super(A, B);
    }

    public Intersectable flowDown(Vector from, Vector to){
        Vector leftI = left.getIntersect(from, to);
        Vector rightI = right.getIntersect(from, to);
        if(leftI.subtract(from).length < rightI.subtract(from).length){
            return left;
        }else{
            return right;
        }
    }

    public void insert(){

    }

    public void remove(){

    }

    public void update(){

    }
}
