public class AbschlussArbeit {
    public static void main(String[] args) {
        boolean themaOk = false;
        String thema;

        do {
            thema = themaErfragen();
            themaOk = isThemaOk(thema);
        } while (!themaOk);

        if (!voraussetzungenPruefen(thema)) {
            return;
        }

        String plan = planen(thema);
        String arbeitspakete = arbeitAnmelden(plan);
        String zwischenErgebnis;
        boolean fertig = false;

        while (true) {
            try {
                boolean lust = Math.random() > 0.1;
                zwischenErgebnis = themaBearbeiten(arbeitspakete, lust);
            } catch (Error e) {
                System.out.println("[Fehler] " + e.getMessage());
                arbeitAbbrechen();
                break;
            }

            arbeitspakete = arbeitBesprechen(zwischenErgebnis);

            if (arbeitIstFertig(arbeitspakete)) {
                arbeitAbgeben(arbeitspakete);
                break;
            }
        }

        System.out.println("Ausarbeitung abgeschlossen.");
    }

    private static String themaErfragen() {
        System.out.println("[Aktion] Thema erfragen");
        return "Beispielthema";
    }

    private static boolean isThemaOk(String thema) {
        System.out.println("[Entscheidung] Nutzer akzeptiert Thema?");
        return thema == "Beispielthema";
    }

    private static boolean voraussetzungenPruefen(String thema) {
        System.out.println("[Aktion] Voraussetzungen prüfen");
        return true;
    }

    private static String planen(String thema) {
        System.out.println("[Aktion] Planung durchführen");
        return "Plan für " + thema;
    }

    private static String arbeitAnmelden(String plan) {
        System.out.println("[Aktion] Arbeit anmelden");
        return "Startpaket";
    }

    private static String themaBearbeiten(String arbeitspakete, boolean lust) {
        System.out.println("[Aktion] Thema bearbeiten mit: " + arbeitspakete);
        if (!lust) {
            throw new Error("Keine Lust mehr");
        }
        return "Zwischenergebnis";
    }

    private static String arbeitBesprechen(String zwischenErgebnis) {
        System.out.println("[Aktion] Arbeit besprechen");
        return "neue Arbeitspakete";
    }

    private static boolean arbeitIstFertig(String arbeitspakete) {
        System.out.println("[Entscheidung] Arbeit fertig?");
        return Math.random() > 0.3;
    }

    private static String arbeitAbgeben(String arbeit) {
        System.out.println("[Aktion] Arbeit abgeben;");
        return "Ausarbeitung";
    }

    private static void arbeitAbbrechen() {
        System.out.println("[Aktion] Arbeit abbrechen");
    }
}
