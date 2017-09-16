package example;

public class PalindromeCheker {
	// La dépendance est créée dans la classe
	// Cette classe ne peut plus être testée de manière unitaire
	private final Inversor inversor = new Inversor();

	/**
	 * Détermine si une chaine est un palindrome	 *
	 * @param s la chaine à tester (non nulle)
	 * @return vrai si s est un palindrome, faux sinon
	 */
	public boolean estPalindrome(String s) {
		return inversor.inverse(s).equals(s);
	}
}
