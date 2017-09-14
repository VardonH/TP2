package example;

public class Inversor {
	/**
	 * @param s la chaine à inverser (non nulle)
	 * @return l'inverse de s
	 */
	public String inverse(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Argument must not be null");
		}

		// Cette implémentation est très inefficace, pourquoi ?
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result = s.charAt(i) + result;
		}
		return result;
	}
}
