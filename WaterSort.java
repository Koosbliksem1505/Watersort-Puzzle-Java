import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.zip.CheckedInputStream;

class WaterSort {
    final static Scanner IN = new Scanner(System.in);
	Character top = null;
	// create constants for colors
	static Character red= new Character('r');
	static Character blue = new Character('b');
	static Character yellow= new Character('y');
	
	
	public static void showAll( StackAsMyArrayList bottles[])
	{
		for (int i = 0; i<=4; i++)
		 {
			 System.out.println("Bottle "+ i+ ": " + bottles[i]);
		 }
	}

    public static boolean solved( StackAsMyArrayList bottles[])
    {
        boolean test = false;
        int count = bottles.length;
       for(int i = 0; i< bottles.length; i++)
       {
           if(bottles[i].checkStackUniform() && (bottles[i].getStackSize() == 4 || bottles[i].getStackSize() == 0))
           {
                count--;
           }  
       }
       if(count == 0)
       {
           test = true;
       }
        return test;
    }

    public static void readInput(StackAsMyArrayList bottles[])
    {
        System.out.println("\nSelect bottle index \"From\" and bottle index \"To\" (-1 to Exit)");
        System.out.print("From : ");
        int from = IN.nextInt();
        if (from == -1)
        {
            System.exit(0);
        }
        System.out.print("To : ");
        int to = IN.nextInt();
        System.out.println(" ");
        if(from != to)
        {

        
        if(from < bottles.length -1 || to < bottles.length  -1){
            if(bottles[to].getStackSize() < 4)
            {
                if(bottles[from].peek() == bottles[to].peek() || bottles[to].peek() == null)
                {
                    bottles[to].push(bottles[from].pop());
                    while(bottles[to].peek() == bottles[from].peek())
                    {
                        if(bottles[to].getStackSize() >=4){

                        }
                        else{
                            bottles[to].push(bottles[from].pop());
                        }
                        
                    }
                }
                else{
                    System.out.println("The ink must be the same !!!");
                }
            }
            else{
                System.out.println("The bottle are too full !!!");
            }
        }
        else{
            System.out.println("Please input a value from or to that is valid !!!");
            }
    }
    else{
        System.out.println("Cannot put one bottle into itself !!!");
    }

    }


	public static void mixUpInk(StackAsMyArrayList bottles[]){
        Random rand = new Random();
        int countR = 0;
        int countB = 0;
        int countY = 0;
        int index = rand.nextInt(5);

            while(countR < 4 || countB < 4 || countY < 4)  
            { 
                int x = rand.nextInt(4);
                switch(x){
                    case 1 : //red
                    if(countR<=3 && bottles[index].getStackSize() <4)
                    {
                        bottles[index].push(red);
                        countR++; 
                    }
                    else{
                        break;
                    }  
                    break;
                    case 2 : //blue 
                    if(countB<=3 && bottles[index].getStackSize() <4)
                    {
                        bottles[index].push(blue);
                        countB++;
                    }
                    else{
                        break;
                    }
                    break;
                    case 3 : //yellow
                    if(countY<=3 && bottles[index].getStackSize() <4)
                    {    
                        bottles[index].push(yellow);
                        countY++;
                    }
                    else{
                        break;
                    } 
                    break;
                    default : x = rand.nextInt(4); break;
                }
                index = rand.nextInt(5);
            }
		}
		

	
	
    public static void main(String args[])
    {
		
		
		// Part 1
		// Bottles declaration
		 StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
		 //You can do this with a for also
		 bottles[0] = new StackAsMyArrayList<Character>();
		 bottles[1] = new StackAsMyArrayList<Character>();
		 bottles[2] = new StackAsMyArrayList<Character>();
		 bottles[3] = new StackAsMyArrayList<Character>();
		 bottles[4] = new StackAsMyArrayList<Character>();
		 
     
		
        //Play the game
        mixUpInk(bottles);         
         showAll(bottles);
        
         
                
        System.out.println("GO!!!");
        while (!solved(bottles)) {
            readInput(bottles);
            showAll(bottles);
        }
        System.out.println("You win!");
        
                
          
           
         
    }
}