
public class SniperRifle extends Rifle{
	public static final int MAX_ZOOM = 100;
	public static final int MIN_ZOOM = 1;
	public static final int DEFAULT_ZOOM = 50;
	public static final int MAX_NUM_BULLETS = 6;
	
	private int zoomLevel;
	
	public SniperRifle(String inputName, int inputDamage, int inputZoom) {
		super(inputName, inputDamage, MAX_NUM_BULLETS, true);
		if (inputZoom <= MAX_ZOOM && inputZoom >= MIN_ZOOM) {
			zoomLevel = inputZoom;
		}
		else {
			zoomLevel = DEFAULT_ZOOM;
		}
	}

	public int getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}
	
	public void use() {
		if (getNumBullets() >= 1) {
			System.out.println("Firing sniper rifle");
			offsetNumBullets(-1);
		}
			
			
			
		
	}
	
	public String toString() {
		String msg = super.toString();
		msg += ", zoom level = " + zoomLevel;
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
