import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;  // Import the Scanner class
import java.util.Collections;

public class Randomiser {


	public void RunMenu()
	{
		System.out.println("---Class Randomiser Started---");
		
		// List of students
		ArrayList<String> studentNames = new ArrayList<String>(); // Create an ArrayList object
		studentNames.add("Adam");
		studentNames.add("Alan");
		studentNames.add("Callum");
		studentNames.add("Connor");
		studentNames.add("Daniel");
		studentNames.add("Derek");
		studentNames.add("Franciszek");
		studentNames.add("Jack");
		studentNames.add("Jakub");
		studentNames.add("Jay");
		studentNames.add("John");
		studentNames.add("Josie");
		studentNames.add("Kai");
		studentNames.add("Martyna");
		//studentNames.add("Noa");
		//studentNames.add("Owen");
		studentNames.add("Stuart");
		studentNames.add("Zeliha");
		

		// to store whether we should keep going
		boolean running = true;
		
		// For use reading responses
	    Scanner input = new Scanner(System.in);  // Create a Scanner object

		// Keep going for as long as running is true
		while (running)
		{
			// randomise the names and print them
			RandomiseGroups(studentNames);

			// ask if we should do it again!
			System.out.println("Randomise again? (y/n)");
			String userChoice = input.nextLine();

			// If they said anything other than yes, stop doing this!
			if (!userChoice.equals("y") && !userChoice.equals("Y"))
			{
				running = false;
				System.out.println("Goodbye!");
			}
			// Otherwise, the loop will happen again and then wait on user input.
		}
		
	}
	
	public void RandomiseGroups(ArrayList<String> students)
	{
		// shuffle Array
		Collections.shuffle(students);

		// groups array
		ArrayList<ArrayList<String> > groups = new ArrayList<ArrayList<String> >();

		// Add the first group
		groups.add(new ArrayList<String>());

		// initially assign groups
		int groupCount = 0;
		int groupIndex = 0;
		for (int i = 0; i < students.size(); ++i)
		{
			if (groupCount >= 3)
			{
				groupCount = 0;
				++groupIndex;
				groups.add(new ArrayList<String>());
			}

			groups.get(groupIndex).add(students.get(i));

			++groupCount;
		}

		// if we ended with a group size of one, steal one from the previous group
		if (groupCount == 1)
		{
			ArrayList<String> lastGroup = groups.get(groupIndex);
			ArrayList<String> secondToLastGroup = groups.get(groupIndex-1);
			lastGroup.add(secondToLastGroup.get(secondToLastGroup.size()-1));
			secondToLastGroup.remove(secondToLastGroup.size()-1);
		}

		// Print groups
		for (int gi = 0; gi < groups.size(); ++gi)
		{
			System.out.println("========================================");
			System.out.println("Group " + (gi + 1) + ":");
			for (int si = 0; si < groups.get(gi).size(); ++si)
			{
				System.out.println("   "+groups.get(gi).get(si));
			}
		}
		System.out.println("========================================");
	}
	
}
