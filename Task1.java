import java.lang.Math;
import java.util.Scanner;
class Task1 {
    public static void main(String args[]) {
    /*  1. Generate a random number within a specified range, such as 1 to 100.
        2. Prompt the user to enter their guess for the generated number.
        3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high, or too low.
        4. Repeat steps 2 and 3 until the user guesses the correct number.
        You can incorporate additional details as follows:
        5. Limit the number of attempts the user has to guess the number. 
        6. Add the option for multiple rounds, allowing the user to play again. 
        7. Display the user's score, which can be based on the number of attempts taken or rounds won.  */

        int roundCount = 1;
        boolean canWeStartTheRound = true;
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalAttempts = 10;

        System.out.println("\n\nThere will be a random number selected between 1 to 100 and you have to guess it in "+totalAttempts+" attempts. You will get a hint if the guessed number is either lower or higher than the winning number. Your score will be based on number of attempts or average of all rounds if you choose to play multiple rounds.");

        while(canWeStartTheRound) {
            System.out.println("\nRound "+roundCount+":");
            canWeStartTheRound = false;
            int randomNumber = (int)(Math.random() * 100) + 1;
            int numOfAttemptsRemaining = totalAttempts;
            while(numOfAttemptsRemaining>=1) {
                System.out.print("\nEnter your guess ("+numOfAttemptsRemaining+" chances available) :");
                int guessedNum = 0;
                try {
                    guessedNum = Integer.parseInt(scanner.nextLine());
                } catch(Exception e) { 
                    System.out.println("\nBad input please input numericals");
                    continue; 
                }
                if(guessedNum>randomNumber) {
                    System.out.println("too high");
                    numOfAttemptsRemaining--; 
                }
                else if(guessedNum<randomNumber) {
                    System.out.println("too low");
                    numOfAttemptsRemaining--;
                }
                else { 
                    System.out.println("\nCongratulations! You guessed the number it's "+guessedNum); 
                    score+=numOfAttemptsRemaining; 
                    break; 
                }
            }
            if(numOfAttemptsRemaining==0) {
                System.out.println("\nYou lost this round the number was "+randomNumber);
            }
            boolean humanError = true;
            while(humanError) {
            humanError = false;
            System.out.print("\nChoose an option: \n1.Play another round \n 2.Finish and get score\nEnter choice here ::");
            int choice = 0;
            try {
            choice = Integer.parseInt(scanner.nextLine());
            } catch(Exception e) {
                humanError = true;
                System.out.println("\nBad input please input either 1 or 2");
                continue;
            }

            if(choice==1) {
                canWeStartTheRound = true;
                roundCount++;
            } else if(choice==2) {
                System.out.println("\nYour score : "+(score/roundCount)+"\n");
            } else {
                humanError = true;
                System.out.println("\nbad input please input either 1 or 2");
            }
            }
        }
    }
}