import java.math.BigDecimal;
import java.time.LocalDate;

public class Projekt {
    private String nazev;
    private Integer pocetResitelu;
    private BigDecimal odhadNaklady;
    private Integer hodnoceni;
    private LocalDate datumZahajeni;
    private Boolean dokonceno;

    public Projekt(String nazev,Integer pocetResitelu,BigDecimal odhadNaklady, Integer hodnoceni, LocalDate datumZahajeni, Boolean dokonceno){
        this.nazev = nazev;
        this. pocetResitelu = pocetResitelu;
        this.odhadNaklady = odhadNaklady;
        this.hodnoceni = hodnoceni;
        this.datumZahajeni = datumZahajeni;
        this.dokonceno = dokonceno;
    }

    public String getNazev() {
        return nazev;
    }

    public Integer getPocetResitelu() {
        return pocetResitelu;
    }

    public BigDecimal getOdhadNaklady() {
        return odhadNaklady;
    }

    public Integer getHodnoceni() {
        return hodnoceni;
    }

    public LocalDate getDatumZahajeni() {
        return datumZahajeni;
    }

    public Boolean getDokonceno() {
        return dokonceno;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPocetResitelu(Integer pocetResitelu) {
        this.pocetResitelu = pocetResitelu;
    }

    public void setOdhadNaklady(BigDecimal odhadNaklady) {
        this.odhadNaklady = odhadNaklady;
    }

    public void setHodnoceni(Integer hodnoceni) {
        this.hodnoceni = hodnoceni;
    }

    public void setDatumZahajeni(LocalDate datumZahajeni) {
        this.datumZahajeni = datumZahajeni;
    }

    public void setDokonceno(Boolean dokonceno) {
        this.dokonceno = dokonceno;
    }
}
