
class SpellChecker {

    String word = "Fi_er";
	char missingWord;
    String dictionary = "Filter:Fiver:fiver:Tailor:Filer:Fisher:Filre";

    public static void main(String[] args) {
		SpellChecker mainObj = new SpellChecker();
		
        int emptySpace = mainObj.word.indexOf("_");
		String[] dicArr = mainObj.dictionary.split(":");
		
		for(int i=0; i<dicArr.length; i++) {
			for(int j=0; j<mainObj.word.length(); j++) {
				if(j == emptySpace){
					continue;
				}
				if(String.valueOf(dicArr[i].charAt(j)).equalsIgnoreCase(String.valueOf(mainObj.word.charAt(j)))) {
					if(j == mainObj.word.length()-1){
						mainObj.missingWord = dicArr[i].charAt(emptySpace);
						System.out.println(dicArr[i]);
					}
				} else {
//					System.out.println(String.valueOf(dicArr[i].charAt(j)).toUpperCase());
					break;
				}
				
			}
			
		}
    }
}