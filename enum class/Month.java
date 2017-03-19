package µÚÊ®Ìâ;

import java.io.Serializable;

public enum Month {
	Jan("January"),Feb(" February"),Mar(" March"),Apr("April"),May(" May"),
	Jun("June"),Jul("July"),Aug("August "),Sep("September"),Oct("October"),
	Nov("November"),Dec("December");
	private String text;
	private Month(String index)
	{
		this.text=index;
	}
	public String gettest(){
		return this.text;
	}
	
}
