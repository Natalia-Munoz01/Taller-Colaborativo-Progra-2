package model;

import javax.swing.JOptionPane;

/**
 * @author Natalia Muñoz
 * @author Juanita Sanabria
 * @author Jhon Jaime
 * @version 19/11/21
 */

//Clase Principal
public class Management {
	
	/**
	 * Texto inmutable con el que se va a trabajar
	 */
	private String TEXT_STRING;

	/**
	 * @param TEXT_STRING texto inmodificable
	 */
	public Management(String TEXT_STRING) {
		this.TEXT_STRING = TEXT_STRING;
	}

	/**
	 * Método para convertir en nombre propio el contenido de la cadena 
	 * @return Nombre propio
	 */
	public String ownName() {
		TextTools toolsForname = new TextTools(TEXT_STRING);
		return toolsForname.result();
	}

	/**
	 *  Método para buscar una palabra determinada y mostrar cuantas veces 
	 *  se encuentra dicha palabra en la cadena original.
	 *  @return cont;
	 */
	public int findWord(String word) {

		int cont = 0;
		String[] words = TEXT_STRING.split(" ");// en esta parte se separa la cadena de caracteres en palabras
		for (int i = 0; i < words.length; i++) {
			if (words[i].equalsIgnoreCase(word)) {
				cont++;
			}
		}
		return cont;
	}

	/**
	 * Método para agregar un caracter n veces al inicio o fin de la cadena
	 * @param character
	 * @param limit
	 * @param address
	 * @return auxChain
	 */
	public String fillCharacters(char character, int limit, int address) {
		String chainModified = "";
		String auxChain = TEXT_STRING;
		for (int i = 0; i < limit; i++) {
			if (address == 1) {
				chainModified = character + auxChain;
			} else {
				chainModified = auxChain + character;
			}
			auxChain = chainModified;

		}
		return auxChain;
	}
	
	/**
	 * Método de Interseccion
	 * @param text texto a comparar con texto principal(TEXT_STRING)
	 * @return cadena formada por las intersecciones entre la cadena de entrada y la
	 *         principal
	 */
	public String intersection(String text) {
		String intersectingText = "";
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < TEXT_STRING.length(); j++) {
				if (text.substring(i, i + 1).equalsIgnoreCase(TEXT_STRING.substring(j, j + 1))) {
					if (TextTools.identifyRepeatingData(text.substring(i, i + 1), intersectingText)) {
						intersectingText += TEXT_STRING.substring(j, j + 1);
					}
				}
			}
		}
		return intersectingText;
	}
	
	
	/**
	 * 
	 * Metodo de cuenta regresiva dependiendo un parametro
	 * @param minutes
	 * parametro que pide el valor de los minutos para la cuenta regresiva
	 */
	
	public void Regresive(int minutes) {

		String timer="";
		
		for (int i = minutes; i >= 0; i--) {
			for (int j = 59; j >= 0; j--) {
				timer= timer+ (i+":"+j);
				timer+="\n";
				
				System.out.printf("| %02d : %02d | \n", i, j);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		JOptionPane.showMessageDialog(null,"Año Nuevo!!!!____|=|:)");
	}
	
	/**
	 * Metodo que remueve caracteres repetidos
	 * 
	 * @param word
	 * parametro que pide la palabra para eliminar los caracteres repetidos
	 */
	

	public String removeCharacter(String word) {

		String removeWord ="";
		//vetor que almacena la palabra
		String[] splitWord = new String[word.length()];

		for (int i = 0; i < word.length(); i++) {
			
			splitWord[i] = word.substring(i, i + 1);
		}
		
		for (int i = 0; i < word.length(); i++) {
			for (int j = i + 1; j < word.length(); j++) {
				
				if (splitWord[j].equalsIgnoreCase(splitWord[i])) {
					splitWord[j] = "";	
				}
				
			}
			removeWord+= splitWord[i];
		}
			return removeWord;

	}
}
