import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        Indit();
    }

    public static boolean veletlenSzam() {
        double rnadSzam = Math.random();
        if (rnadSzam < 0.75) {
            return true;
        }
        return false;
    }

    public static int gepSzam() {
        if(veletlenSzam()) {
            return 1;
        }
        return 2;
    }

    
	public static void Indit() {
		int pont = 0;
		boolean fut = true;

		while (fut) {
			int gep = gepSzam();
			Scanner sc = new Scanner(System.in);
			System.out.println("Adj meg egy szamot! 1 vagy 2!");
			int jatekosSzama = sc.nextInt();
			while (jatekosSzama > 2 || jatekosSzama < 1) {
				System.out.println("Hiba!! 1 vagy 2!");
				jatekosSzama = sc.nextInt();
			}

			int osszeg = gep + jatekosSzama;

			if (osszeg % 2 == 0) {
				pont += osszeg;
				System.out.println("A te számod: " + jatekosSzama + "\nA gep szama: " + gep + "\nNyertel " + osszeg
						+ " pontot.\n" + "Pontod: " + pont);
			} else {
				pont -= osszeg;
				System.out.println("A te számod: " + jatekosSzama + "\nA gep szama: " + gep + "\nVesztettél " + osszeg
						+ " pontot.\nPontod: " + pont);
			}

			@SuppressWarnings("resource")
			Scanner sl = new Scanner(System.in);

			System.out.println("Uj jatek? (i/n) ");
			String valasz = sl.nextLine();

			while (!valasz.equals("n") && !valasz.equals("i")) {
				System.out.println("i vagy n!");
				valasz = sl.nextLine();
			}

			if (valasz.equals("n")) {
				fut = false;
			}
		}

		if (pont == 0) {
			System.out.println("Dontetlen.");
		} else if (pont < 0) {
			System.out.println("Elveszitetted a jatekot.");
		} else if (pont > 0) {
			System.out.println("Megnyerted a jatekot.");
		}
	}
}
