package it.polito.tdp.alien;

import java.util.*;

public class Word {
	
	private String alienWord;
	List<String> translation = new ArrayList<String>();
	
	
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		
	}


	public String getAlienWord() {
		return alienWord;
	}




	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}




	public List<String> getTranslation() {
		return translation;
	}




	public void addTranslation(String translation) {
		
		String primaLettera = translation.substring(0, 1).toUpperCase();

		for(String s : this.translation)
			if(s.toLowerCase().compareTo(translation.toLowerCase()) == 0)
				return;
		
				this.translation.add(primaLettera + translation.substring(1, translation.length()));
	}


	
	
	

}
