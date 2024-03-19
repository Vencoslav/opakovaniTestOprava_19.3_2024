import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjektForm extends JFrame{
    private JPanel panelMain;
    private JButton ulozDoSouboruBt;
    private JButton dalsiBt;
    private JButton predchoziBt;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JTextField textField3;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JLabel nazevLabel;
    private JLabel pocetResiteluLabel;
    private JLabel dokoncenoLabel;
    private JLabel hodnoceniLabel;
    private JLabel datumLabel;
    private int aktualniIndex = 0;
    private EvidenceProjektu evidenceProjektu;
    public ProjektForm(){
        List<Projekt> seznam = new ArrayList<>();
        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Projekty");
        setSize(300,250);

        initMenuBar();

        evidenceProjektu = new EvidenceProjektu();
        evidenceProjektu.nactiProjekty();

        Projekt projekt1 = new Projekt("Menu",3, BigDecimal.valueOf(200),2,LocalDate.of(2024,2,3),true);
        Projekt projekt2 = new Projekt("FileChooser",8,BigDecimal.valueOf(100),1,LocalDate.of(2024,3,28),false);
        Projekt projekt3 = new Projekt("List",2,BigDecimal.valueOf(50),3,LocalDate.of(2023,11,29),true);
        evidenceProjektu.seznam.add(projekt1);
        evidenceProjektu.seznam.add(projekt2);
        evidenceProjektu.seznam.add(projekt3);

        dalsiBt.addActionListener(e -> {
            if(aktualniIndex < evidenceProjektu.seznam.size()-1){
                vlozProjeckt();
                aktualniIndex++;
            }
        });

        predchoziBt.addActionListener(e ->{
            if(aktualniIndex > 0){
                vlozProjeckt();
                aktualniIndex--;
            }
        });

        vlozProjeckt();
    }
    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu projekt = new JMenu("Projekt");
        menuBar.add(projekt);

        JMenu statistika = new JMenu("Statistika");
        menuBar.add(statistika);

        JMenuItem pridej = new JMenuItem("Přidej další");
        projekt.add(pridej);
    }
    public void vlozProjeckt(){
        Projekt aktualniProjekt = evidenceProjektu.getSeznam().get(aktualniIndex);
        textField1.setText(aktualniProjekt.getNazev());
        textField2.setText(String.valueOf(aktualniProjekt.getPocetResitelu()));
        checkBox1.setSelected(aktualniProjekt.getDokonceno());
        textField3.setText(aktualniProjekt.getDatumZahajeni().toString());
        a1RadioButton.setSelected(aktualniProjekt.getHodnoceni() == 1);
        a2RadioButton.setSelected(aktualniProjekt.getHodnoceni() == 2);
        a3RadioButton.setSelected(aktualniProjekt.getHodnoceni() == 3);
    }
}

