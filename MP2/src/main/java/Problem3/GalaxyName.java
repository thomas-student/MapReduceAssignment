package Problem3;

public class GalaxyName {

	private String name;
	
	public GalaxyName(String name){
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "galaxy: "+name;
	}

	
}
