import java.util.Scanner;

public class MovieDriverTask2 {

	public static void main(String[] args) {
		String Selection;
		
		
		Scanner keyboard= new Scanner(System.in);
		//Using do-while loop
		do {
		Movie movie = new Movie();
		
		//Asking for title of the movie
		System.out.println("Enter the title of the movie:");
		String title= keyboard.nextLine();
		movie.setTitle(title);
		
		//Asking for movie rating
		System.out.println("Enter the movie rating:");
		String rating= keyboard.nextLine();
		movie.setRating(rating);
		
		//Asking for tickets sold
		System.out.println("Enter the number of tickets sold: ");
		int tickets= keyboard.nextInt();
		movie.setSoldTickets(tickets);
		
		//Print movie information
		System.out.println("\nMovie Information: ");
		System.out.println(movie.toString());
		keyboard.nextLine();
		System.out.println("");
		
		//Asking the user if he wants to enter another movie
		System.out.println("Do you want to enter another movie? Yes/No");
	    Selection= keyboard.nextLine().toLowerCase();
		} 
		
		while(Selection.equals("yes"));
			
		System.out.println("Thank you for using Movie program");
		keyboard.close();
		

	}

}
