import java.util.Scanner;

public class MovieDriverTask1{
	public static void main (String[] args) {
		
		Scanner keyboard= new Scanner(System.in);
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
		
		keyboard.close();
			
	}
}