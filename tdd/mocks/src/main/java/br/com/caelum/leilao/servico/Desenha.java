package br.com.caelum.leilao.servico;

public class Desenha {

	public static void main(String[] args) {
//		int stars = 1;
//		int empty = 5;
//		for(int i=6; i > 0; i--) {
//			for(int j=6; j > stars; j--) {
//				imprimeVazio();
//			}
//			for(int j=6; j > empty; j--) {
//				imprimeStar();
//			}
//			System.out.println();
//			stars++;
//			empty--;
//		}
//		StairCase(10);
		String[] votes = {"Alex", "Mama", "Pap", "Alex", "Mama", "Papi", "Popo", "Mama", "Alex"};
		electionWinner(votes);
		
	}
	
	
    static String electionWinner(String[] votes) {
    	int [] a = new int[votes.length];
    	int index =0;
    	for(String vote : votes) {
			a[index] = sumVotes(vote, votes);
			index++;
    	}
    	
    	int max = maxVotes(a);
    	String[] aa = indexMaxVotes(max, a, votes);
    	for (String string : aa) {
    		System.out.println(string);
		}
    	return "";
    }
    
    private static String[] indexMaxVotes(int max, int[] vts, String[] votes) {
    	String[] wins = new String[vts.length];
    	int a=0;
    	for(int i=0; i <vts.length; i++) {
    		if(max == vts[i]) {
    			if(a == 0 || !exist(wins, votes[i])) {
    				wins[a] = votes[i];
    				a++;
    			}
    		}
    	}
    	return wins;
    }
    
    private static boolean exist(String[] wins, String string) {
		for (String win : wins) {
			if(win != null && win.equals(string)) {
				return true;
			}
		}
    	return false;
	}


	private static int maxVotes(int[] vts) {
    	int max = 0;
    	for (int i : vts) {
			if(i > max) {
				max = i;
			}
		}
    	return max;
    }
	
	private static int sumVotes(String vote, String[] votes) {
		int i = 0;
		for (String vot : votes) {
			if(vote.equals(vot)) {
				i++;
			}
		}
		return i;
	}


	static void StairCase(int n) {
        int stair = 1;
        int empty = n - stair;
        for(int i = n; i > 0; i--) {
            for(int j=n; j > stair; j--) {
				printEmpty();
			}
			for(int j=n; j > empty; j--) {
				printStair();
			}
			System.out.println();
			stair++;
			empty--;
        }

    }

    static void printStair() {
        System.out.print("#");
    }

    static void printEmpty() {
        System.out.print(" ");
    }

	
}
