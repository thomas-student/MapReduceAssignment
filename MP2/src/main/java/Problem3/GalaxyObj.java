package Problem3;

public class GalaxyObj {

	private float mass;
	private float distance;
	private float diameter;
	private float rotation;
	private long massCount;
	private long distanceCount;
	private long diameterCount;
	private long rotationCount;
	
	/**
	 * @param name
	 * @param mass
	 * @param distance
	 * @param diameter
	 * @param rotation
	 * @param count
	 */
	public GalaxyObj(){
		super();
		this.mass = 0;
		this.distance = 0;
		this.diameter = 0;
		this.rotation = 0;
		
	}
	


	@Override
	public String toString() {
		return "massavg: " + mass + " distanceavg: "+ distance + 
				"diameteravg: " + diameter + "rotationavg: " + rotation;
	}



	/**
	 * @return the mass
	 */
	public float getMass() {
		return mass;
	}



	/**
	 * @param mass the mass to set
	 */
	public void setMass(float mass) {
		this.mass = mass;
	}



	/**
	 * @return the distance
	 */
	public float getDistance() {
		return distance;
	}



	/**
	 * @param distance the distance to set
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}



	/**
	 * @return the diameter
	 */
	public float getDiameter() {
		return diameter;
	}



	/**
	 * @param diameter the diameter to set
	 */
	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}



	/**
	 * @return the rotation
	 */
	public float getRotation() {
		return rotation;
	}



	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}



	/**
	 * @return the massCount
	 */
	public long getMassCount() {
		return massCount;
	}



	/**
	 * @param massCount the massCount to set
	 */
	public void setMassCount(long massCount) {
		this.massCount = massCount;
	}



	/**
	 * @return the distanceCount
	 */
	public long getDistanceCount() {
		return distanceCount;
	}



	/**
	 * @param distanceCount the distanceCount to set
	 */
	public void setDistanceCount(long distanceCount) {
		this.distanceCount = distanceCount;
	}



	/**
	 * @return the diameterCount
	 */
	public long getDiameterCount() {
		return diameterCount;
	}



	/**
	 * @param diameterCount the diameterCount to set
	 */
	public void setDiameterCount(long diameterCount) {
		this.diameterCount = diameterCount;
	}



	/**
	 * @return the rotationCount
	 */
	public long getRotationCount() {
		return rotationCount;
	}



	/**
	 * @param rotationCount the rotationCount to set
	 */
	public void setRotationCount(long rotationCount) {
		this.rotationCount = rotationCount;
	}
	
	
		
	
}
