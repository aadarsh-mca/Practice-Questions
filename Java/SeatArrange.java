/**
n = 27
m = 98
seats[] = 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 1 1 0 0 0 1 1 1 0 0 0 0 1 1 1 1 1 0 0 0 0 0 1 1 0 0 0 1 1 1 1 0 0 0 0 0 0 1 1 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 1 1 1 0 0 1 1 1 1 0 0 1 1 1 1 0 0 0 1 1
**/

class SeatArrange {
	public static void main(String[] args) {
		int[] seats = {0, 0, 0};  // 0, 0, 1, 0, 0, 0, 1		0, 0, 1
		int n = 1, m = seats.length;
		
		SeatArrange.solution(n, m, seats);
		
	}
	
	static boolean solution(int n, int size, int[] seats) {
		
        // code here

		/**
		 * Optimized Code
		 * 
		 *  int i=0;
        	while(i<m && n>0){
				if(seats[i]==0 && ((i-1 < 0 || seats[i-1] == 0) && (i+1 >= m || seats[i+1] == 0))) {
					n--;
					seats[i] = 1;
				}
            	i++;
        	}
        	return n<=0;
		 * 
		 * **/
        
        boolean preSeatOccupied = false;
        int altVacantSeat = 0;
        
        if(size == 1) {
            if(seats[0] == 0) {
                altVacantSeat++;
            }
		} else if(size == 2) {
		    if(seats[0] == 0 && seats[1] == 0) {
		        altVacantSeat++;
		    }
		} else {
			for(int i = 0; i < size; i++) {
				if(altVacantSeat == n) {  // everyone is already seated, no need to check for more seats
				// 	break;
				}
				
				if(seats[i] == 1) {
				    preSeatOccupied = false;
					continue;
				} else if(seats[i] == 0) {
				    if(i == 0 && seats[1] == 0) {  // check for first seat vacancy
				        altVacantSeat++;
				        preSeatOccupied = true;
					} else if(i > 0 && i < size-1 && seats[i-1] == 0 && seats[i+1] == 0) {
					    if(preSeatOccupied) {
					        preSeatOccupied = false;
					    } else {
						    altVacantSeat++;
						    preSeatOccupied = true;
					    }
					} else if(i == size-1 && seats[i-1] == 0) {   // check for last seat vacancy
					    if(!preSeatOccupied) {
    					    altVacantSeat++;
					    }
					}
				}
			}
		}
		
		if(altVacantSeat >= n) {
		    System.out.println("No. of alt vacant seat : " + altVacantSeat);
		    return true;
		} else {
		    System.out.println("No. of alt vacant seat : " + altVacantSeat);
		    return false;
		}
        
        
	}
}