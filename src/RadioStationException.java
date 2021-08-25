
public class RadioStationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6453584799026632738L;
	private double carrierFrequency;
	private String callSign;


	// Overloaded exception for invalid callSign length
	public RadioStationException(String callSign) {
		System.out.println("ERROR!");
		int c = callSign.length();
		System.out.printf("\nThe call sign should contain four letters, you entered: %d\n", c);
	}

	// Overloaded exception for invalid carrierFrequency
	public RadioStationException(double carrierFrequency) {
		System.out.println("ERROR!");
		System.out.printf("\nThe frequency should be from 88 to 108 (inclusive). You entered: %.1f\n",
				carrierFrequency);
	}

	// Exception for invalid carrierFrequency AND callSign length
	public RadioStationException(double carrierFrequency, String callSign) {
		int c = callSign.length();
		System.out.println("ERROR!");
		System.out.printf("\nThe frequency should be from 88 to 108 (inclusive). You entered: %.1f\n",
				carrierFrequency);
		System.out.printf("\nThe call sign should contain four letters, you entered: %d\n", c);
	}

	// Create getters and setters
	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	public double getCarrierFrequency() {
		return carrierFrequency;
	}

	public void setCarrierFrequency(double carrierFrequency) {
		this.carrierFrequency = carrierFrequency;
	}

	public void run() {

	}

}