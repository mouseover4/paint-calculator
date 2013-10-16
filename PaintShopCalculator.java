import java.text.DecimalFormat; // to format numbers (check the documentation)
import java.text.NumberFormat;

/**
 * Calculates the amount of paint needed to paint a room
 * @author Helen Lawrence
 */

public class PaintShopCalculator {
	// Prices of the paint containers in dollars (constants)
	public final double FIVEGALLONS = 116.00;

	public final double ONEGALLON = 23.20;

	public final double HALFGALLON = 11.60;

	public final double QUART = 5.80; //4 quarts in a gallon

	public final double PINT = 2.90; //8 pints in a gallon

	public final double HALFPINT = 1.45; //16 half-pints in a gallon

	// Area that can be painted with one gallon of paint (in square inches)
	public final double AREA_PER_GALLON = 25000.0;

	/**
	 * Initialize this PaintShopCalculator with the room measurements. For
	 * example, if the height is 10'2'', heightFeet is 10 and heightInches is 2.
	 * 
	 * @param heightFeet
	 *            the number of feet of the height measurement
	 * @param heightInches
	 *            the number of inches of the height measurement
	 * @param widthFeet
	 *            the number of feet of the width measurement
	 * @param widthInches
	 *            the number of inches of the width measurement
	 * @param lengthFeet
	 *            the number of feet of the length measurement
	 * @param lengthInches
	 *            the number of inches of the length measurement
	 */
	
	//Instance fields 
	public int a; //number of 5-gallon cans needed to paint the room
	public int b; //number of 1-gallon cans needed to paint the room
	public int c; //number of half-gallon cans needed to paint the room
	public int d; //number of quarts needed to paint the room
	public int e; //number of pints needed to paint the room
	public int f; //number of half-pints needed to paint the room
	
	double numGallons = 0;
	int room = 0;
	
	double price = 0;
	
	public PaintShopCalculator(int heightFeet, int heightInches,
			int lengthFeet, int lengthInches, int widthFeet, int widthInches) {
		int h = heightFeet*12 + heightInches;
		int l = lengthFeet*12 + lengthInches;
		int w = widthFeet*12 + widthInches;
		
		//opposite walls
		int walls = 2*(l*h) + 2*(w*h);
		
		//ceiling
		int ceiling = l*w;
		
		//total area to paint (in square inches)
		room = walls + ceiling;
		numGallons = (double)(room/AREA_PER_GALLON);	
	}
	
	/**
	 * Calculates how many cans of each size will be needed to paint the room 
	 */
	public void PaintCanCalculator()
	{
		double remainder;
			a = (int)numGallons / 5;	
			remainder = numGallons % 5;
			b = (int)(remainder / 1);
			remainder = remainder % 1;	
			c = (int)(remainder / 0.5);
			remainder = remainder % 0.5;
			d = (int)(remainder / 0.25);
			remainder = remainder % 0.25;
			e = (int)(remainder / 0.125);
			remainder = remainder % 0.125;
			f = (int)(remainder / 0.0625);
			remainder = remainder % 0.0625;
			//if there is any remainder when the number of 1/2 pints are calculated 
			//add an additional can to the total
			if(remainder != 0) 
			{
				f +=1;
			}
	}
	
	/**
	 * Calculates the total price of the paint cans needed to paint the room
	 */	
	public void CalculatePrice(){
		price = FIVEGALLONS*a + ONEGALLON*b + 
				HALFGALLON*c + QUART*d + PINT*e + HALFPINT*f;
	}

	/**
	 * Return as a string the result of the computation. The string lists
	 * the exact amount of paint needed (with 3 digits after the decimal point),
	 * the number and type of cans needed, and the price.
	 * 
	 */
	public String toString() {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(3);
		
		NumberFormat mf = NumberFormat.getNumberInstance();
		mf.setMaximumFractionDigits(2);
		
		PaintCanCalculator();
		CalculatePrice();
		String s = 
					"You need " + nf.format(numGallons) + " gallons of paint " + "\n"
					+"You will need to purchase" + "\n"
					+ showResult() + "\n"
				    +"The total price is $" + mf.format(price) + "\n" + "\n"
					+"Thank you for your business!"
					;
		return s;
	}
	
	/**
	 * Shows the number of each type of paint can that the customer will need to purchase
	 * @return String
	 */
	public String showResult()
	{
		String u = new String();
		if(a !=0)
		{
			u = "\t" + a + " five-gallon can" + ((a != 1)?"s":"") + "\n";
		}
		if(b != 0)
		{
			u +=  "\t" + b + " one-gallon can" + ((b != 1)?"s":"") + "\n";
		}
		if(c != 0)
		{
			u +=  "\t" + c + " half-gallon can" + ((c != 1)?"s":"") + "\n";
		}
		if(d != 0)
		{
			u +=  "\t" + d + " quart" + ((d != 1)?"s":"") + "\n";
		}
		if(e != 0)
		{
			u +=  "\t" + e + " pint" + ((e != 1)?"s":"") + "\n";
		}
		if(f != 0)
		{
			u +=  "\t" + f + " half-pint" + ((f != 1)?"s":"") + "\n";
		}
		
				
		return u;
	}
}














