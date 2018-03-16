package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	List<Word> dizionarioAlieno = new ArrayList<Word>();
	
	public void addWord(String alienWord, String translation) {
		
		String primaLettera = translation.substring(0, 1).toUpperCase();
		Word wtemp = new Word(alienWord, primaLettera + translation.substring(1, translation.length()));
		wtemp.addTranslation(primaLettera + translation.substring(1, translation.length()));
		dizionarioAlieno.add(wtemp);
				
		
	}
	
	public List<String> translateWord(String alienWord) {
		
		for(Word w : dizionarioAlieno) {
			if(w.getAlienWord().toLowerCase().compareTo(alienWord.toLowerCase()) == 0) {
				return w.getTranslation();
			}
		}
		
		return null;
		
	}
	
	
	public boolean CercaNelDizionario(String alienWord) {
		
		
		for(Word w : dizionarioAlieno) {
			boolean presente = false;
			if(w.getAlienWord().toLowerCase().compareTo(alienWord.toLowerCase()) == 0) {
				presente = true;
				return presente;}
		
	}
	
		return false;
			
	}
	
	
	
}


