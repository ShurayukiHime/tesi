package model.consents;

import java.util.HashMap;
import java.util.Map;

public class DataSet implements IDataSet {

	private Map<String, Object> dataSet;

	public DataSet() {
		dataSet = new HashMap<String, Object>();
	}
	
	@Override
	public void put (String typeConst, Object obj) {
		if (typeConst != null && obj != null)
			this.dataSet.put(typeConst, obj);
	}
	
	@Override
	public Object get (String typeConst) {
		if (typeConst != null && this.dataSet.containsKey(typeConst))
			return this.dataSet.get(typeConst);
		throw new IllegalArgumentException("The string " + typeConst + " does not match with any of the declared type constants.");
	}
}
