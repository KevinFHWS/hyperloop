package coordinate;

public class Coordinate {
	private long id;
	private String stationName;
	private String district;
	private double x;
	private double y;

	// ## Begin Coordinate
	public Coordinate(long id, String stationName, String district, double x, double y) {
		super();
		this.id = id;
		/* ## Start stationName */ this.stationName = stationName;/* ## End */
		this.district = district;
		this.x = x;
		this.y = y;
	}
	// ## End

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

//	public void setStationName(String stationName) {
//		this.stationName = stationName;
//	}

	public String /* ## StartMD district */ getDistrict() /* ## End */ {
		return district;
	}

//	public void setDistrict(String district) {
//		this.district = district;
//	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @param lon Get lon from CoordinateReader.
	 * @param precision (10^n)
	 * @return X in CoordinateSystem.
	 */
	public int scaleXToCoordinateSystem(double lon, int precision) {
		return (int) ((this.getX()-lon) * precision);
	}
	
	/**
	 * 
	 * @param lat Get lat from CoordinateReader
	 * @param precision (10^n)
	 * @return Y in CoortdinateSystem.
	 */
	public int scaleYToCoordinateSystem(double lat, int precision) {
		return (int) ((this.getY()-lat) * precision);
	}
	
	@Override
	public String toString() {
		return "(" + getId() + ") \"" + getStationName() + "\"" + toStringCoordinatesOnly();
	}
	
	public String toStringCoordinatesOnly() {
		return "[" + getX() + "|" + getY() + "]";
	}
	
	public String toSvgString(double xCoordinate) {
		return "<tspan x=\"" + xCoordinate + "\" dy=\"0em\">(" + getId() + ")</tspan>" //
				+ "<tspan x=\"" + xCoordinate + "\" dy=\"1.2em\">\"" + getStationName() + "\"</tspan>" //
				+ "<tspan x=\"" + xCoordinate + "\" dy=\"1.2em\">\"" + getDistrict() + "\"</tspan>" //
				+ "<tspan x=\"" + xCoordinate + "\" dy=\"1.2em\">\"" + toStringCoordinatesOnly() + "\"</tspan>";
	}
}
