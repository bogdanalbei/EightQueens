/**
 * Created by bogdan on 24/05/17.
 */
public class Queens {

    public static final int NO_OF_QUEENS = 8;
    private int number_of_solutions = 0;

    private void printResults(int[] solutions) {
        for(int i=0; i< NO_OF_QUEENS; i++) {
            for(int j=0; j< NO_OF_QUEENS; j++) {
                if(solutions[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("---");
        number_of_solutions++;
    }

    private boolean isValid(int[] solutions, int n) {
        if(n == 1) {
            return true;
        }
        for(int i=0; i< n-1; i++) {
            for(int j=i+1; j<n; j++) {

                //on the same column
                if(solutions[i] == solutions[j]) {
                    return false;
                }

                //on the diagonal
                if(solutions[i] + (j-i) == solutions[j]) {
                    return false;
                }

                //on the diagonal
                if(solutions[i] == solutions[j] + (j-i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void solve(int[] solutions, int k) {
        for(int i=0; i<NO_OF_QUEENS; i++) {
            solutions[k] = i;
            if(isValid(solutions, k+1)) {
                if(k == NO_OF_QUEENS -1) {
                    printResults(solutions);
                } else {
                    solve(solutions, k + 1);
                }
            }
        }
    }

    public void solve() {
        solve(new int[NO_OF_QUEENS], 0);
        System.out.println("Number of solutions:" + number_of_solutions);
    }
}
