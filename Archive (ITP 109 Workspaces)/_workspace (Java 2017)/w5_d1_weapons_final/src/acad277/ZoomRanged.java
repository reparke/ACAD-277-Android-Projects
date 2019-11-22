package acad277;

/**
 * NOTE: ZoomRanged constructor doesn't take capacity
 *      Instead it uses constant
 */
public class ZoomRanged extends Ranged{
    public static final int MAX_CAPACITY = 6;
    public static final int DEFAULT_ZOOM = 4;

    private int zoomLevel;

    public ZoomRanged(String inputName, int inputDamage, int zoomLevel) {
        super(inputName, inputDamage, MAX_CAPACITY);
        if (zoomLevel > 0 && zoomLevel < 10) {
            this.zoomLevel = zoomLevel;
        }
        else {
            this.zoomLevel = DEFAULT_ZOOM;
        }
    }

    public int getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(int zoomLevel) {
        if (zoomLevel > 0 && zoomLevel < 10) {
            this.zoomLevel = zoomLevel;
        }
        else {
            this.zoomLevel = DEFAULT_ZOOM;
        }
    }

    @Override
    public String toString() {
        String msg = super.toString();
        msg += "\nZoom level: " + zoomLevel;
        return msg;
    }

    @Override
    public void use() {
        boolean result = reduceCapacity(1);
        if (result == true) {
            System.out.println("\tFiring {"+getName()+"} (capacity: {"+ getCapacity() +"})");
        }
        else{
            System.out.println("Out of capacity!");
        }
    }
}
