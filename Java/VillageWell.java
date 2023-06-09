import java.util.ArrayList;

/**
n = 3
m = 3
c[][]: H H H
       H W H
       H H H

	   {{'H', 'H', 'H'}, {'H', 'W', 'H'}, {'H', 'H', 'H'}}

Output:
4 2 4 
2 0 2 
4 2 4
==================

n = 5
m = 5
c[][]: H N H H H
       N N H H W
       W H H H H
       H H H H H
       H H H H H

	   {{'H','N','H','H','H'}, {'N','N','H','H','W'}, {'W','H','H','H','H'}, {'H','H','H','H','H',}, {'H','H','H','H','H'}}

Output:
-1 0 6 4 2 
0 0 4 2 0 
0 2 4 4 2 
2 4 6 6 4 
4 6 8 8 6


**/

public class VillageWell {
    public static void main(String[] args) {
        VillageWell obj = new VillageWell();

/*		
	{{'H', 'H', 'H'}, {'H', 'W', 'H'}, {'H', 'H', 'H'}}  // (actual ques)

	{{'H', 'N', 'H'}, {'N', 'W', 'H'}, {'H', 'H', 'H'}}  // 00 (left top)
	{{'N', 'H', 'N'}, {'H', 'N', 'H'}, {'H', 'H', 'H'}}  // 01 (middle top)
	{{'H', 'N', 'H'}, {'H', 'W', 'N'}, {'H', 'H', 'H'}}  // 02 (right top)
	
	{{'N', 'H', 'H'}, {'H', 'N', 'H'}, {'N', 'H', 'H'}}  // 10 (left center)
	{{'H', 'N', 'H'}, {'N', 'H', 'N'}, {'H', 'N', 'H'}}  // 00 02 11 20 22 (center)
	{{'H', 'H', 'N'}, {'H', 'N', 'H'}, {'H', 'H', 'N'}}  // 12 (right center)

	{{'H', 'H', 'H'}, {'N', 'H', 'H'}, {'H', 'N', 'H'}}  // 20 (left bottom)
	{{'H', 'H', 'H'}, {'H', 'N', 'H'}, {'N', 'H', 'N'}}  // 21 (middle bottom)
	{{'H', 'H', 'H'}, {'H', 'H', 'N'}, {'H', 'N', 'H'}}  // 22 (right bottom)

	{{'H', 'H', 'N'}, {'N', 'N', 'H'}, {'H', 'N', 'N'}}  // (special case)
*/

        char[][] c = {{'H', 'H', 'H'}, {'H', 'W', 'H'}, {'H', 'H', 'H'}};
        obj.chefAndWells(3, 3, c);
    }

    public int[][] chefAndWells(int n, int m, char c[][]) {
		System.out.println("Initial Map is here : ");
		for(int i=0; i < n; i++) {
			for(int j=0; j < m; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}

		

		int[][] result = new int[n][m];
		ArrayList<String> wellPos = new ArrayList<>();
		ArrayList<String> nPos = new ArrayList<>();
		ArrayList<String> housePos = new ArrayList<>();
		
		for(int i=0; i < n; i++) {
			for(int j=0; j < m; j++) {
				if(c[i][j] == 'W' || c[i][j] == 'N' || c[i][j] == '.') {
					result[i][j] = 0;
					if(c[i][j] == 'N') {
						nPos.add("" + i + j);
					}
					if(c[i][j] == 'W') {
						wellPos.add("" + i + j);
					}
				} else if(c[i][j] == 'H') {

					// if( c[0][0] == 'H' &&  (j-1 < 0 || c[i][j-1] == 'N')  &&  (j+1 >= m || c[i][j+1] == 'N')   &&   
					// 	(i-1 < 0 || c[i-1][j] == 'N')   &&  (i+1 >= n || c[i+1][j] == 'N')  ) {

					// if( (i==0 && j==0 && c[i][j+1] == 'N' && c[i+1][j] == 'N')   ||   
					// ( (j-1 < 0 || c[i][j-1] == 'N') && (j+1 >= m-1 || c[i][j+1] == 'N')   &&   ( i-1 < 0 || c[i-1][j] == 'N') && (i+1 >= n-1 || c[i+1][j] == 'N') )   ||   
					// ( i==n-1 && j==m-1 && c[i][j-1] == 'N' && c[i-1][j] == 'N')   ) {

					if( ((j-1 < 0 && c[i][j+1] == 'N') || (j>0 && c[i][j-1] == 'N')) && 
						((j+1 >= m && c[i][j-1] == 'N') || (j<m-1 && c[i][j+1] == 'N')) && 
						((i-1 < 0 && c[i+1][j] == 'N') || (i>0 && c[i-1][j] == 'N')) && 
						((i+1 >= n && c[i-1][j] == 'N') || (i<n-1 && c[i+1][j] == 'N')) ) {

						result[i][j] = -1;

					} else {
						housePos.add("" + i + j);
						// if(wellPos.size() != 0) {
						// 	result[i][j] = distanceCal(i, j);
						// } else {
						// 	result[i][j] = 1;
						// }
					}
				}
			}
		}

		System.out.println(wellPos);
		System.out.println(housePos);

		for(int h = 0; h < housePos.size(); h++) {
			int smallestDistance = 0, temp = 0;
			int hX = Character.getNumericValue(housePos.get(h).charAt(0));
			int hY = Character.getNumericValue(housePos.get(h).charAt(1));

			for(int w = 0; w < wellPos.size(); w++) {
				int wX = Character.getNumericValue(wellPos.get(w).charAt(0));
				int wY = Character.getNumericValue(wellPos.get(w).charAt(1));

				if(w == 0) {
					smallestDistance = distanceCal(hX, hY, wX, wY);
				} else {
					temp = distanceCal(hX, hY, wX, wY);
					if(smallestDistance > temp) {
						smallestDistance = temp;
					}
				}
			}
			result[hX][hY] = smallestDistance;
		}





		System.out.println("After calculation : ");
		for(int i=0; i < n; i++) {
			for(int j=0; j < m; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}

		return result;
    }

	int distanceCal(int hX, int hY, int wX, int wY) {
		// System.out.println("(" + i + "," + j + ")");
		int count = 0;
		if(hX != wX) {
			hX = hX + 1;

		}


		return 0;
	}


}
