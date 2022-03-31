package hhManager;

public class MainHHLauncher {

	public static void main(String[] args) {
		new MainHHLauncher().start();

	}
	
	private void start() {
		MakehhBuchObject haushaltsliste = new MakehhBuchObject();
		haushaltsliste.hhBuchFromHD();
        for (Entry e : MakehhBuchObject.hhBuch) {
            System.out.println(e);
        }
	}

}
