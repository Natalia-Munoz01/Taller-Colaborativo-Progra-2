package view;

import javax.swing.JOptionPane;

import model.Management;

public class Runner {
	
	/**
	 * Metodo que permite visualizar el menu y gestionar las opciones 
	 */
	public void menu() {

		String cadenaOriginal = JOptionPane.showInputDialog("Ingrese la cadena de caracteres que desea evaluar");
		Management obj = new Management(cadenaOriginal);
		boolean continuar = true;
		while (continuar == true) {
			String mensaje = JOptionPane.showInputDialog("MENU\n" 
					+ "1.  Ver Cadena Original\n"
					+ "2.  Convertir en nombre propio\n" + ""
					+ "3.  Buscar cadena de caracteres\n" 
					+ "4.  Contar vocales\n"
					+ "5.  Año nuevo\n" 
					+ "6.  Llenar Caracteres\n" 
					+ "7.  Borrar Caracteres\n" 
					+ "8.  Intersección\n"
					+ "9.  Eliminar repetidos\n" 
					+ "10. Contar palabras\n"
					+ "11. Validar dirección de correo electrónico\n" 
					+ "12. Salir de la App\n"
					+ "      Digite una opción: ");
			int opcion = Integer.parseInt(mensaje);
			switch (opcion) {
			case 1:
				JOptionPane.showMessageDialog(null, "Cadena : " + cadenaOriginal);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Mayusculas :" + obj.ownName());
				break;
			case 3:
				String word = JOptionPane.showInputDialog("Ingrese la palabra que desea buscar: ");
				JOptionPane.showMessageDialog(null,
						"La palabra " + word + " se encuentra " + obj.findWord(word) + " veces");
				break;
			case 4:

				break;
			case 5:
				
				int minutes = Integer.parseInt(JOptionPane.showInputDialog("Digite los minutos para el conteo: "));
				obj.Regresive(minutes);

				break;
			case 6:
				String charr = JOptionPane.showInputDialog("Ingrese el caracter que desea agregar a la cadena");
				char character = charr.charAt(0);
				int limit = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de veces a agregar")));
				int address = (Integer.parseInt(
						JOptionPane.showInputDialog("Seleccione la dirección \n" + "1. Izquierda \n" + "2. Derecha")));

				JOptionPane.showMessageDialog(null, obj.fillCharacters(character, limit, address));
				break;
			case 7:

				break;
			case 8:
				String cadena2 = JOptionPane.showInputDialog("Ingrese la cadena a intersectar con la Cadena original");
				JOptionPane.showMessageDialog(null, "Interseccion :" + obj.intersection(cadena2));
				break;
			case 9:
				String removeword = JOptionPane.showInputDialog("Digite la cadena");
				JOptionPane.showMessageDialog(null, obj.removeCharacter(removeword));
				break;
			case 10:

				break;
			case 11:

				break;
			case 12:
				continuar = false;
				JOptionPane.showMessageDialog(null, "Fin de la App, Bye");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no Valida");
				break;
		}//fin switch
		
		}//fin while
		
	}//fin menu()


	/**
	 * Metodo que permite ejecutar el programa
	 */
	public static void main(String[] args) {
		
		Runner runner = new Runner();
		runner.menu();
	}

}
