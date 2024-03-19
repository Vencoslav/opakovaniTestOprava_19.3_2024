import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceProjektu {
    String nazevSouboru = "src\\vstup";
    public List<Projekt> seznam = new ArrayList<>();

    public List<Projekt> getSeznam() {
        return seznam;
    }

    public void nactiProjekty(){
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(nazevSouboru)))){
            while (sc.hasNextLine()){
                String radek = sc.nextLine();
                String[] rozdelovac = radek.split("#");
                if(radek.length() != 6){
                    throw new RuntimeException("Špatný počet prvků na řádku.");
                }
                String nazev = rozdelovac[0].trim();
                Integer pocetResitelu = Integer.parseInt(rozdelovac[1].trim());
                BigDecimal odhadNaklady = BigDecimal.valueOf(Long.parseLong(rozdelovac[2].trim()));
                Integer hodnoceni = Integer.parseInt(rozdelovac[3].trim());
                LocalDate datumZahajeni = LocalDate.parse(rozdelovac[4].trim());
                Boolean dokonceno = Boolean.parseBoolean(rozdelovac[5].trim());
                Projekt projekt = new Projekt(nazev,pocetResitelu,odhadNaklady,hodnoceni,datumZahajeni,dokonceno);
                seznam.add(projekt);

            }
            } catch (FileNotFoundException e){
              throw new RuntimeException("Soubor: "+nazevSouboru+" nebyl nalezen "+e.getLocalizedMessage());
        }
    }
}
