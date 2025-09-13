/*
 * Name: Patrick Rooney
 * Date: September 13, 2025
 * Description: Driver of Stapler class. Sample run available at bottom of file. No modifications were made to the executable code in this
 * file.
 */

//***************************************
//DRIVER PROGRAM CODE MAY NOT BE MODIFIED
//HOWEVER, DO PASTE RUN OUTPUT AT BOTTOM.
//***************************************

public class StaplerTester
{
    public static void main(String args[])
    {
        //create stapler objects
        Stapler test1 = new Stapler();
        Stapler test2 = new Stapler(25, 100, true);
        Stapler test3 = new Stapler(test2);

        //initial status
        System.out.println("BEFORE CHANGES");
        printStatus(test1, "test1");
        printStatus(test2, "test2");
        printStatus(test3, "test3");
        System.out.println();

        //first set of actions
        test1.staple();
        test1.staple();
        test2.staple();
        test2.staple();
        test3.openStapler();
        test3.staple();
        test3.staple();

        //middle status
        System.out.println("FIRST CHANGES");
        printStatus(test1, "test1");
        printStatus(test2, "test2");
        printStatus(test3, "test3");
        System.out.println();
        System.out.println();

        //second set of actions
        test1.openStapler();
        test1.addStaples(5000);
        test1.staple();
        test1.staple();
        test2.addStaples(10);
        test2.openStapler();
        test2.staple();
        test2.staple();
        test3.addStaples(10);
        test3.closeStapler();
        test3.staple();
        test3.staple();

        //final status
        System.out.println("SECOND CHANGES");
        printStatus(test1, "test1");
        printStatus(test2, "test2");
        printStatus(test3, "test3");
        System.out.println();
        System.out.println();

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println();
        System.out.println();

        //done
        System.out.println("Done...");
    }

    //Prints Stapler Status.
    private static void printStatus(Stapler temp, String name)
    {
        System.out.print(name + " status:\t");
        System.out.print("staples = " + temp.numStaples() + "\t");
        System.out.print("capacity = " + temp.getCapacity() + "\t");
        System.out.print("closed = " + temp.isClosed());
        System.out.println();
    }

}

/*
PASTE RUN OUTPUT HERE:

BEFORE CHANGES
test1 status:   staples = 0     capacity = 250  closed = true
test2 status:   staples = 25    capacity = 100  closed = true
test3 status:   staples = 25    capacity = 100  closed = true

Stapler is either open or does not contain any staples!
Stapler is either open or does not contain any staples!
Used one staple.
Used one staple.
Stapler is either open or does not contain any staples!
Stapler is either open or does not contain any staples!
FIRST CHANGES
test1 status:   staples = 0     capacity = 250  closed = true
test2 status:   staples = 23    capacity = 100  closed = true
test3 status:   staples = 25    capacity = 100  closed = false


Added staples
Stapler is either open or does not contain any staples!
Stapler is either open or does not contain any staples!
Stapler is either closed or already at capacity!
Stapler is either open or does not contain any staples!
Stapler is either open or does not contain any staples!
Added staples
Used one staple.
Used one staple.
SECOND CHANGES
test1 status:   staples = 250   capacity = 250  closed = false
test2 status:   staples = 23    capacity = 100  closed = false
test3 status:   staples = 33    capacity = 100  closed = true


This stapler has room for 0 staples
This stapler has room for 77 staples
This stapler has room for 67 staples


Done...

*/