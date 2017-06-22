package edu;

public class EnhancedEvent {
	/**
	 * Chapter 5...(1a) bullet point 2
	 */
	public static final double MIN_PRICE_PER_GUEST = 32.00;
	public static final double MAX_PRICE_PER_GUEST = 35.00;
	public final static int CUT_OFF_FOR_LARGE_EVENT = 50;
	private final static String DEFAULT_EVENT_NUMBER = "A000";
	private final static String DEFAULT_PHONE_NUMBER = "0000000000";
	private final static int MIN_PHONE_LENGTH = 9;
	private final static int MAX_PHONE_LENGTH = 10;
	/**
	 * Chapter 5...(b) bullet point 1 
	 * eventNumber is set as a string because Carlys plans to assign seat "M312"
	 */
	// added variable to generate unique customerName
	private String customerName;
	private String contactNumber;
	private String eventNumber;
	private int guestCount;
	// created in Chapter 5...
	private double pricePerGuest;
	private double totalPrice;
	// added in chapter7..
	
	
	//Chapter 8 (1)...bullet point 1
	private int eventType;
	// NOTE: This is an example of a static array initialization...size of the array is 5 and
	// max index is 4 (ie. array size -1)
	private final  String[]  nameOfEvents = {"Wedding", 
			                                 "Baptism", 
			                                 "Birthday", 
			                                 "Corporate", 
			                                 "Other"};// added in chapter 8...
	private String eventOption;

	/**
	 * Chapter 5...(b) bullet point 2
	 * @param eventNumber
	 */
	// ***********************SETTER AND GETTERS***********************
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public static double getMinPricePerGuest() {
		return MIN_PRICE_PER_GUEST;
	}
	
	public static double getMaxPricePerGuest() {
		return MAX_PRICE_PER_GUEST;
	}

	public static int getCutOffForLargeEvent() {
		return CUT_OFF_FOR_LARGE_EVENT;
	}	
	
	// chapter 7..(1)..bullet 3
	public void setContactNumber(final String contactNumber) {
		StringBuilder digitizedUserContact = new StringBuilder("");
		boolean done = false;
		while(!done){
			for(int i=0; i < contactNumber.length(); i++){
				boolean isDigit = Character.isDigit(contactNumber.charAt(i));
				if(isDigit){
					digitizedUserContact.append(contactNumber.charAt(i));
				}
			}			
			done = true;
		}	
		
		if(digitizedUserContact.toString().length() < MIN_PHONE_LENGTH || 
		   digitizedUserContact.toString().length() > MAX_PHONE_LENGTH)	{
			
			this.contactNumber = DEFAULT_PHONE_NUMBER;
		}
		this.contactNumber = digitizedUserContact.toString();
	}

	public StringBuilder  getContactNumber() {
		StringBuilder formattedContactNumber = new StringBuilder(this.contactNumber);
		formattedContactNumber.insert(0, "(");
		formattedContactNumber.insert(4, ")");
		formattedContactNumber.insert(8, "-");
		
		return formattedContactNumber;
	}
	
	// Chapter 7..(1)..bullet point 1
	public void setEventNumber() {
		StringBuilder createEventNumber = new StringBuilder();
		createEventNumber.insert(0, this.customerName.charAt(0));
		createEventNumber.insert(1, this.contactNumber.subSequence(6, 10));
		
		System.out.println(createEventNumber.toString());
		
	 this.eventNumber = createEventNumber.toString().toUpperCase();
		
		
//		if(eventNumber.length() == 4 && Character.isAlphabetic(eventNumber.charAt(0))){
//			// NOTE: make sure that you convert to  upper case...
//			this.eventNumber = eventNumber.toUpperCase();	
//		}else{
//			this.eventNumber = DEFAULT_EVENT_NUMBER;
//			// System.out.println("You Entered a incorrect Event Number format, a default number has been given to you: A000");
//		}
	}
	
	public String getEventNumber() {
		return this.eventNumber;
	}

	public void setGuest(int numberOfGuest) {
		this.guestCount = numberOfGuest;
		// Chapter 5...(1a) bullet 4...
		if(this.isLargeEvent(guestCount)){
			this.setPricePerGuest(MIN_PRICE_PER_GUEST);
		}else {
			this.setPricePerGuest(MAX_PRICE_PER_GUEST);
		}
		// NOTE: this was asked in Chapter 4 ...(a) bullet 2
		this.setTotalPrice(guestCount);
	}
	
	public int getNumberOfGuest() {
		return guestCount;
	}
	
	
	// Chapter 4..asked to use the setGuest to calculate the event Price, so we passed the guestCount from setGuest to this method to do that
	private void setTotalPrice(int guestCount) {
		this.totalPrice = guestCount * this.getPricePerGuest();
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	// created in Chapter 5...
	public void setPricePerGuest(double pricePerGuest) {
		this.pricePerGuest = pricePerGuest;
	}
	
	public double getPricePerGuest() {
		return pricePerGuest;
	}
	
	public int getEventType() {
		return eventType;
	}
	
	//Chapter 8.1...first bullet.
	public String getEventTypeAsString() {
		return this.nameOfEvents[eventType];
	}

	//Chapter 8 (1)...bullet point 1
	public void setEventType(final int eventType) {
		if(this.eventType < nameOfEvents.length ){
			this.eventType = eventType;
		}else{
			// NOTE: storing the index of the array location with value = Other
			this.eventType = nameOfEvents.length -1;
		}
	}
	
	public String getEventOption() {
		return eventOption;
	}

	public void setEventOption(String eventOption) {
			int i = (Integer.parseInt(eventOption)-1);	
			this.eventOption = nameOfEvents[i];
		}	
		
	// ***********************setter and getters***********************

	
	
	


	//****************************************************************
	///*******************    OVERLOADED CONSTRUCTORS  *******************************
	//****************************************************************
	/**
	 * Chapter 4 ...(1a) bullet one and two...
	 */
	public EnhancedEvent(){
//		this.setEventNumber("A000");
		this.setGuest(0);
	}
	// custom constructor..Chapter 7..adds contact number
	public EnhancedEvent(final String customerName, 
						 final int numberOfGuest, 
						 final String contactNumber,
						 final String eventNumber,
						 final String eventOption){
		setCustomerName(customerName);
		setGuest(numberOfGuest);
		setContactNumber(contactNumber);
		setEventNumber();
		setEventOption(eventOption);
	}
	
	//Chapter 10..request
	public EnhancedEvent(final String eventNumber, 
						 final int numberOfGuest,
						 final String eventOption){
		setEventNumber();
		setGuest(numberOfGuest);
		setEventOption(eventOption);
	}
	
	public boolean isLargeEvent(){
		return (this.getNumberOfGuest() > CUT_OFF_FOR_LARGE_EVENT);
	}
	
	/**
	 * Chapter 5 ...(1a) bullet three....
	 */	
	public boolean isLargeEvent(int guestCount) {
			return (guestCount > CUT_OFF_FOR_LARGE_EVENT);
	}
	
}// END OF CLASS
