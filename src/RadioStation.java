
public abstract class RadioStation implements RadioStationConstants, Runnable {

	private int pickNumber;
	private double carrierFrequency;
	private String callSign;


	public RadioStation(int pickNumber, double carrierFrequency, String callSign) throws RadioStationException {
		super();
		this.pickNumber = pickNumber;

		// If both are valid, create RadioStation and alert success
		if (validFrequency(carrierFrequency) & validCallSign(callSign)) {
			this.carrierFrequency = carrierFrequency;
			this.callSign = callSign;
			System.out.println("Great! Station added successfully!\n");

			// If only carrierFrequency is valid, throw overloaded exception for callSign
		} else if (validFrequency(carrierFrequency) & !validCallSign(callSign)) {
			System.out.println();
			this.carrierFrequency = carrierFrequency;
			this.callSign = null;
			throw new RadioStationException(callSign);

			// If only callSign valid, throw overloaded exception for carrierFrequency
		} else if (!validFrequency(carrierFrequency) & validCallSign(callSign)) {
			System.out.println();
			this.carrierFrequency = 0;
			this.callSign = callSign;
			throw new RadioStationException(carrierFrequency);

			// If both are invalid, throw exception that includes both
		} else {
			throw new RadioStationException(carrierFrequency, callSign);
		}

	}


	private boolean validCallSign(String callSign) {
		return callSign.length() == CALL_SIGN_LENGTH;
	}

	private boolean validFrequency(double carrierFrequency) {
		return carrierFrequency >= MIN && carrierFrequency <= MAX;
	}

	public int getPickNumber() {
		return pickNumber;
	}

	public void setPickNumber(int pickNumber) {
		this.pickNumber = pickNumber;
	}

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

	@Override
	public String toString() {
		String result = printStation();

		return result;
	}

	private String printStation() {
		return pickNumber + ") " + callSign + ": "
				+ carrierFrequency + " MHz";
	}

	@Override
	public void run() {

	}
	

}

//stationValidity(choice, carrierFrequency, callSign);   //method call
//
//
//Method below
//
//
//public static void stationValidity(int choice, double carrierFrequency, String callSign)
//		throws RadioStationException {
//
//	switch (choice) {
//	case 0:
//		System.out.println("Invalid choices!");
//		throw new RadioStationException(carrierFrequency, callSign);
//	// break;
//	
//	case 2:
//		System.out.printf("\nError!The frequency should be from 88 to 108 (inclusive). You entered: %.2f",
//				carrierFrequency);
//		throw new RadioStationException(carrierFrequency, callSign);
//	// break;
//		
//	case 4:
//		System.out.printf("\nError! The call sign should contain four letters, you entered: %s", callSign.length());
//		throw new RadioStationException(carrierFrequency, callSign);
//	// break;
//	case 6:
//		System.out.println("Great! Station added successfully!\n");
//		break;
//
//	}
//}
