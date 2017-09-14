package example;

/**
 * PalindromeChecker avec injection de dépendance
 */
public class PalindromeCheckerDI {

	private final Inversor inversor;

	// La dépendance est "injectée" par le constructeur
	public PalindromeCheckerDI(Inversor inversor) {
		this.inversor = inversor;
	}

	/**
	 * Détermine si une chaine est un palindrome
	 *
	 * @param s la chaine à tester (non nulle)
	 * @return vrai si s est un palindrome, faux sinon
	 */
	public boolean estPalindrome(String s) {
		return inversor.inverse(s).equals(s);
	}

}
