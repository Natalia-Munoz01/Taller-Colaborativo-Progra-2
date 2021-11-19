package model;

import java.util.ArrayList;

/**
 * @author Natalia Muñoz
 * @version 19/11/21
 */

public class TextTools {
	
	/**
	 * Guarda palabras
	 */
	private ArrayList<String> modifiedText;
	private String text;
	
	/**
	 * @param text cadena de caracteres con la que se va a trabajar
	 */
	public TextTools(String text) {
		this.text = text;
		modifiedText = new ArrayList<>();
	}
	
	/**
	 * Separa el texto en palabras y espacios alojados por separado en el vector
	 */
	public void words() {
		String cutWords = text + " ";
		String aux = "";
		for (int i = 0; i < cutWords.length(); i++) {
			if (!cutWords.substring(i, i + 1).equalsIgnoreCase(" ")) {
				aux += cutWords.substring(i, i + 1);
			} else {
				if (!aux.equalsIgnoreCase(""))
					modifiedText.add(aux);
					modifiedText.add(" ");
				aux = "";
			}
		}
	}
	
	/**
	 * Remplaza las palabras por la palabra con la mayuscula inicial 
	 */
	public void substitution() {
		for (int i = 0; i < modifiedText.size(); i++) {
			modifiedText.set(i, addCapitalLetter(modifiedText.get(i)));
		}
	}
	
	/**
	 * @param word palabra proveniente del vector
	 * @return palabra con letra inicial en mayuscula siempre y cuando tengan mas de un caracter 
	 */
	public String addCapitalLetter(String word) {
		if (word.length() > 1) {
			String firstLetter = word.substring(0, 1).toUpperCase();
			String nextLetters = word.substring(1, word.length());
			return firstLetter + nextLetters;
		} else {
			return word;
		}
	}

	/**
	 * @return cadena con letras iniciales en mayuscula
	 */
	public String result() {
		words();
		substitution();
		String string = "";
		for (int i = 0; i < modifiedText.size(); i++) {
			string += modifiedText.get(i);
		}
		return string.substring(0, string.length() - 1);
	}
	
	/**
	 * @param character caracter a verificar su existencia dentro de la cadena de inteseccion
	 * @param string cadena formada apartir de la interseccion entre cadenas
	 * @return verdadero si el caracter no esta o falso si se encuentra
	 */
	public static boolean identifyRepeatingData(String character,String string) {
		int indicator = 0;
		for (int i = 0; i < string.length(); i++) {
			if(string.substring(i, i+1).equalsIgnoreCase(character)) {
				indicator++;
			}
		}
		if(indicator>0)return false;
		else return true;
	}

}
