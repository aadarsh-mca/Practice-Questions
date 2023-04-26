class MapPosition {
	
	String pos = "22E";
	String path = "RMLMLM";
	String compass = "NESWN";
	
	public static void main(String[] args) {
		MapPosition obj = new MapPosition();
		
		for(int i=0; i<obj.path.length(); i++) {
			obj.move(obj.path.charAt(i));
		}
		
		System.out.println( "After moving on " + obj.path + " the new Position is : " + obj.pos);
	}
	
	void move(char direct) {
		char currPos = this.pos.charAt(2);
		int newPosIndex;
		
		switch(direct) {
			case 'R' :
				newPosIndex = this.compass.indexOf(currPos) + 1;
				this.pos = this.pos.substring(0, 2) + this.compass.charAt(newPosIndex);
				break;
			case 'L' :
				newPosIndex = this.compass.indexOf(currPos) - 1;
				this.pos = this.pos.substring(0, 2) + this.compass.charAt(newPosIndex);
				break;
			case 'M' :
				this.updateCoordinate(currPos);
				break;
		}
	}
	
	void updateCoordinate(char currPos) {
		int currCoorX = Integer.parseInt(String.valueOf(this.pos.charAt(0)));
		int currCoorY = Integer.parseInt(String.valueOf(this.pos.charAt(1)));;
		
		if(currPos == 'N' || currPos == 'S') {
			if(currPos == 'N') {
				currCoorY = currCoorY + 1;
			} else {
				currCoorY = currCoorY - 1;				
			}
		} else if(currPos == 'E' || currPos == 'W') {
			if(currPos == 'E') {
				currCoorX = currCoorX + 1;
			} else {
				currCoorX = currCoorX - 1;				
			}
		}
		
		this.pos = String.valueOf(currCoorX) + String.valueOf(currCoorY) + this.pos.charAt(2);
	}
	
	
}