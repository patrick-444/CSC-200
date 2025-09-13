/*
 * Name: Patrick Rooney
 * Date: September 13, 2025
 * Description: Implementation of Stapler class. Contains constructors, getters and setters for class attributes (staples, capacity, closed), as well
 * as methods for refilling the stapler, using the staple to dispense one staple, and checking the capacity of the stapler by using an
 * overridden toString() method.
 */

public class Stapler
{

	//********Instance Variables********


	private int staples;		//how many staples in stapler
	private int capacity;		//how many staples it can hold
	private boolean closed;	//is stapler closed?


	//********Constructors********


	//Default constructor.
	//Set to: zero staples, capacity 250, closed.
	//Hint:  Write the default constructor here

    Stapler() {
        this.staples = 0;
        this.capacity = 250;
        this.closed = true;
    }

	//Regular constructor.  Initialize instance variables with
	//provided values.  Assume user will use valid values for all.
	public Stapler(int staples, int capacity, boolean closed)
	{
        this.staples = staples;
        this.capacity = capacity;
        this.closed = closed;
	}

	//Copy constructor.  Initializes stapler with values provided
	//from another stapler.  Assume "temp" stapler has valid values.
	public Stapler(Stapler temp)
	{
        this.staples = temp.numStaples();
        this.capacity = temp.getCapacity();
        this.closed = temp.isClosed();
	}


	//********Mutator Methods (change values) ********

	//Close the stapler
	public void closeStapler()
	{
        this.closed = true;
	}

	//Open the stapler
	public void openStapler()
	{
        this.closed = false;
	}

	//Subtract a single staple.  The stapler can
	//staple only when already closed AND when it HAS STAPLES.
	//**Both** conditions **must** be true to staple.
	//HINT:  Requires one or more IF statements.
	public void staple()
	{
        if (this.closed && (this.staples > 0)) {
            this.staples--;
            System.out.println("Used one staple.");
        } else {
            System.out.println("Stapler is either open or does not contain any staples!");
        }
	}

	//Increase staples up to the maximum capacity.
	//The stapler must already be OPEN to add staples.
	//HINT: Requires IF statement(s) to make sure stapler is already open
	//and to make sure you fill it up to, BUT NOT BEYOND capacity.
	public void addStaples(int moreStaples)
	{
        if (!(this.closed) && (this.staples < this.capacity)) {
            if ((moreStaples > this.capacity) || (this.staples + moreStaples > this.capacity)) { // cases of exceeding capacity
                this.staples += (this.capacity - this.staples);
            } else { // case of "underfilling"
                this.staples += moreStaples;
            }
            System.out.println("Added staples");
        } else {
            System.out.println("Stapler is either closed or already at capacity!");
        }
	}


	//********Accessor Methods (return values) ********

	//returns number of staples
	public int numStaples()
	{
        return this.staples;
	}

	//returns capacity of stapler
	public int getCapacity()
	{
        return this.capacity;
	}

	//returns open/closed status of stapler
	public boolean isClosed()
	{
        return this.closed;
	}

	//*********Other Methods*********************
	//returns a string representing this stapler -
	// The string says "This stapler has room for x staples"
	// where x is the capcity minus the current number of staples
	// Hint:  Override the toString() method here
    // Overridden toString() method to display how much room is available in stapler
    @Override
    public String toString() {
        return "This stapler has room for " + (this.capacity - this.staples) + " staples";
    }

}