package Fach_2_Objektorientierung.A90_Abstract_TemplateMethod_Pattern;

/**
 * HEAD FIRST DESIGN PATTERNS
 * https://books.google.li/books?id=k4_7uAJrwkEC&pg=PA305&lpg=PA305&dq=java+template+method+pattern&source=bl&ots=lF-ZrvkdTV&sig=HPNXNTyeUcRVazuxMeXzC8cQIRg&hl=de&sa=X&ved=0ahUKEwj91fnd_PDPAhVMDxoKHVLFATE4ChDoAQgvMAQ#v=onepage&q=java%20template%20method%20pattern&f=false
 */
public abstract class KoffeinhaltigesGetraenk {

    /*  Dies hier ist die "Template Methode"
        Sie enthaelt den "zentralen" Algorithmus
        und ermoeglicht den Unterklassen, eigene Implementierungen
        fuer ein oder mehr Schritte zur Verfuegung zu stellen
     */
    public void zubereitungsRezept() {
        kocheWasser();
        aufgiessen();
        inTasseSchuetten();
        zutatenHinzufuegen();
    }

    // Abstracte Methoden, muessen von jeder Subklasse selbst implementiert werden
    // diese koennen nicht hier zentral implementiert werden da sie je nach Subklasse
    // anders implementiert werden muessen
    public abstract void aufgiessen();
    public abstract void zutatenHinzufuegen();

    // Gemeinsame Nutzung aus dieser Superklasse
    void inTasseSchuetten() {
        System.out.println("schuette in Tasse");
    }

    void kocheWasser() {
        System.out.println("koche Wasser");
    }
}
