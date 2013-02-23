package Problem3;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class GalaxyObj extends MapWritable {
	
	public GalaxyObj(){
		super();
		setMass(0);
		setDiameter(0);
		setDistance(0);
		setRotation(0);
		setDistanceCount(0);
		setDiameterCount(0);
		setMassCount(0);
		setRotationCount(0);
	}
	


	@Override
	public String toString() {
		return "massavg: " + getMass() + " distanceavg: "+ getDistance() + 
				"diameteravg: " + getDiameter()+ "rotationavg: " + getRotation();
	}



	/**
	 * @return the mass
	 */
	public float getMass() {
		Writable d = get("mass");
		if(d != null)
			return Long.parseLong(d.toString());
		else
			return 0;	}



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
		Writable d = get("distance");
		if(d != null)
			return Long.parseLong(d.toString());
		else
			return 0;	}



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
		Writable d = get("diameter");
		if(d != null)
			return Long.parseLong(d.toString());
		else
			return 0;	
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
		Writable d = get("rotation");
		if(d != null)
			return Float.parseFloat(d.toString());
		else
			return 0;	
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
		Writable d = get("massCount");
		if(d != null)
			return Long.parseLong(d.toString());
		else
			return 0;	}



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
		Writable d = get("distanceCount");
		if(d != null)
			return Long.parseLong(d.toString());
		else
			return 0;	}



	/**
	 * @param distanceCount the distanceCount to set
	 */
	public void setDistanceCount(long distanceCount) {
		put(new Text("distanceCount"), new FloatWritable(distanceCount));
	}



	/**
	 * @return the diameterCount
	 */
	public long getDiameterCount() {
		Writable d = get("diameterCount");
		if(d != null)
			return Long.parseLong(d.toString());
		else
			return 0;
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
		Writable d = get("rorationCount");
		if(d != null)
			return Long.parseLong(d.toString());
		else
			return 0;
	}



	/**
	 * @param rotationCount the rotationCount to set
	 */
	public void setRotationCount(long rotationCount) {
		put(new Text("rotationCount"), new FloatWritable(rotationCount));
	}

}
