package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dizionarioAlieno = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String[] paroleInserite = txtWord.getText().split(" ");
		
    	if(paroleInserite.length == 2) {
    		
    		if(dizionarioAlieno.CercaNelDizionario(paroleInserite[0]) == true)
			{
				for(Word w : dizionarioAlieno.dizionarioAlieno) 
					if(w.getAlienWord().compareTo(paroleInserite[0]) == 0)
						w.setTranslation(paroleInserite[1]);
			}
    		
    		dizionarioAlieno.addWord(paroleInserite[0], paroleInserite[1]);
    		txtResult.appendText("Aggiunta al dizionario la parola "+paroleInserite[0]+" che significa "+paroleInserite[1]+"\n");
		}
		
		else if (paroleInserite.length == 1)
		{ 
			
				if(dizionarioAlieno.translateWord(txtWord.getText()) == null)
					txtResult.appendText("Attenzione: traduzione non disponibile"+"\n");
			
			String result = new String(dizionarioAlieno.translateWord(txtWord.getText()));
			txtResult.appendText(result+"\n");
		}
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	dizionarioAlieno.dizionarioAlieno.clear();
    	txtResult.clear();
    	txtWord.clear();

    }
    
}
