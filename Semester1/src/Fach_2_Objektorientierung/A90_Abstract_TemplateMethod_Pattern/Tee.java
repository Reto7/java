package Fach_2_Objektorientierung.A90_Abstract_TemplateMethod_Pattern;

/**
 * HEAD FIRST DESIGN PATTERNS
 * https://books.google.li/books?id=k4_7uAJrwkEC&pg=PA305&lpg=PA305&dq=java+template+method+pattern&source=bl&ots=lF-ZrvkdTV&sig=HPNXNTyeUcRVazuxMeXzC8cQIRg&hl=de&sa=X&ved=0ahUKEwj91fnd_PDPAhVMDxoKHVLFATE4ChDoAQgvMAQ#v=onepage&q=java%20template%20method%20pattern&f=false
 */
public class Tee extends KoffeinhaltigesGetraenk {

    public void aufgiessen() {
        System.out.println("lasse den Teebeutel ziehen (aufgiessen)");
    }

    public void zutatenHinzufuegen() {
        System.out.println("fuege Zitrone hinzu (Zutaten)");
    }

    // Ueberschreiben Hook Methode, also nicht die "default" Implementierung verwenden
    @Override
    public boolean kundeWillZutaten() {
        return false;
    }

}
