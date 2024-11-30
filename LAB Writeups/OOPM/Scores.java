import java.util.Scanner;

public class Scores {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the number of players:");
        int players = s1.nextInt();
        int[][] scores = new int[players][];
        for (int i = 0; i < players; i++) {
            System.out.println("Enter the number of matches played by player " + (i + 1) + ":");
            int matches = s1.nextInt();
            scores[i] = new int[matches];
            System.out.println("Enter the scores for player " + (i + 1) + ":");

            int ts = 0;
            for (int j = 0; j < matches; j++){
                scores[i][j] = s1.nextInt();
                ts += scores[i][j];
            }
            double avgscore = (double) ts / matches;
            System.out.println("The average score for player " + (i + 1) + " is: " + avgscore);
        }

        s1.close();
    }
}
