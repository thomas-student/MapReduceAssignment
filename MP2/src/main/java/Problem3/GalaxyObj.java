package Problem3;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;

public class GalaxyObj extends MapWritable {

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
		return Float.parseFloat(get("mass").toString());
	}



	/**
	 * @param mass the mass to set
	 */
	public void setMass(float mass) {
		put(new Text("mass"), new FloatWritable(mass));
	}



	/**
	 * @return the distance
	 */
	public float getDistance() {
		return Float.parseFloat(get("distance").toString());
	}



	/**
	 * @param distance the distance to set
	 */
	public void setDistance(float distance) {
		put(new Text("distance"), new FloatWritable(distance));
	}



	/**
	 * @return the diameter
	 */
	public float getDiameter() {
		return Float.parseFloat(get("diameter").toString());
	}



	/**
	 * @param diameter the diameter to set
	 */
	public void setDiameter(float diameter) {
		put(new Text("diameter"), new FloatWritable(diameter));
	}



	/**
	 * @return the rotation
	 */
	public float getRotation() {
		return Float.parseFloat(get("rotation").toString());
	}



	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(float rotation) {
		put(new Text("rotation"), new FloatWritable(rotation));
	}



	/**
	 * @return the massCount
	 */
	public long getMassCount() {
		return Long.parseLong((get("massCount").toString()));
	}



	/**
	 * @param massCount the massCount to set
	 */
	public void setMassCount(long massCount) {
		put(new Text("massCount"), new FloatWritable(massCount));
	}



	/**
	 * @return the distanceCount
	 */
	public long getDistanceCount() {
		return Long.parseLong(get("distanceCount").toString());
	}



	/**
	 * @param distanceCount the distanceCount to set
	 */
	public void setDistanceCount(long distanceCount) {
		put(new Text("distanceCount"), new FloatWritable(rotation));
	}



	/**
	 * @return the diameterCount
	 */
	public long getDiameterCount() {
		return Long.parseLong(get("diameterCount").toString());
	}



	/**
	 * @param diameterCount the diameterCount to set
	 */
	public void setDiameterCount(long diameterCount) {
		put(new Text("diameterCount"), new FloatWritable(diameterCount));
	}



	/**
	 * @return the rotationCount
	 */
	public long getRotationCount() {
		return Long.parseLong(get("rotationCount").toString());
	}



	/**
	 * @param rotationCount the rotationCount to set
	 */
	public void setRotationCount(long rotationCount) {
		put(new Text("rotationCount"), new FloatWritable(rotationCount));
	}

}
