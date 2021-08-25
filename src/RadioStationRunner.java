import java.util.Scanner;

public class RadioStationRunner {

	public static void main(String[] args) throws InterruptedException {
				// Initialize scanner
				Scanner scanner = new Scanner(System.in);

				// Create array to store station info
				// RadioStation[6] throws OutOfBoundsException
				RadioStation[] stationList = new RadioStation[7];

				// Welcome User
				System.out.println("Welcome to the i<3 Radio App!");
				System.out.println("\nTo better curate your music selection, ");
				System.out.print("please list your six favorite radio stations");
				System.out.println("\nand enter each response individually.\n");
				// Initial request for favorite station information
				requestStationInfo();


				// Loop 6 times to build favorite station list
				for (int i = 1; i <= 6; i++) {
					int pickNumber = i;

					// Collect station information
					requestCarrierFrequency();
					double carrierFrequency = scanner.nextDouble();

					requestCallSign();
					String callSign = scanner.next();
					
					try {
						stationList[i] = new FavoriteRadioStation(pickNumber, carrierFrequency, callSign);
					} catch (RadioStationException e) {
						e.printStackTrace();
						// System.exit(0); Uncomment to terminate program after invalid entry
					}
					// Allow stack trace print before requestCarrierFrequency is called again
					Thread.sleep(100);
					
				}

				System.out.println("\nYour favorite radio stations:");
					for (int j = 1; j <= 6; j++) {
					System.out.println(stationList[j]);
				}
				System.out.println("\nWe will use this list to customize your experience.");
				System.out.println("\nThanks for choosing the i<3 Radio App! Goodbye.");
				scanner.close();

			}

			// Extracted methods clean up main()
			private static void requestStationInfo() {
				System.out.println(
						"\nCarrier Frequencies are 88-108 (MHz) and Call Signs are exactly four characters.\n");
			}

			private static void requestCarrierFrequency() {
				System.out.println("\nCarrier frequency: ");
			}

			private static void requestCallSign() {
				System.out.println("\nStation call sign: ");
			}

		}
