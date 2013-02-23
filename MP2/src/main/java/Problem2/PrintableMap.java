package Problem2;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Writable;

public class PrintableMap extends MapWritable {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String output = "";
		for(Writable w : keySet())
			output+=" "+w+"-"+get(w);
		return output;
	}

	
}
