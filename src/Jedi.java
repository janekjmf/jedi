import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;


public class Jedi
{
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch (Exception ex) {}

        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                JFrame window = new JFrame("Zarządzanie Jedi");
                Okienko okienko = new Okienko();
                window.add(okienko);
                window.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-((okienko.getPreferredSize().width)/2),
                                   (Toolkit.getDefaultToolkit().getScreenSize().height/2)-((okienko.getPreferredSize().height)/2));
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false);
                window.setVisible(true);
                window.pack();
            }
        });
    }
}

class Okienko extends JPanel
{
    public Okienko()
    {
        ArrayList<Zakon> zakony = new ArrayList<>();
        ArrayList<RycerzJedi> rycerzJedis = new ArrayList<>();
        ButtonGroup bgroup = new ButtonGroup();
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        DefaultListModel<String> defaultListModel1 = new DefaultListModel<>();

        setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 14);
        Font font1 = new Font("Arial", Font.BOLD, 12);
        Font font2 = new Font("Arial", Font.BOLD, 8);

                JLabel zakonyJedi = new JLabel("Zakony Jedi");
                zakonyJedi.setFont(font);
                zakonyJedi.setBounds(150,10, 100, 30);
                add(zakonyJedi);

                JLabel jedi = new JLabel("Jedi");
                jedi.setFont(font);
                jedi.setBounds(600,10, 100, 30);
                add(jedi);

        JList listaZakonow = new JList(defaultListModel1);
        listaZakonow.setBounds(10, 50, 380, 300);
        add(listaZakonow);

        JList listaJedi = new JList(defaultListModel);
        listaJedi.setBounds(410, 50, 380, 300);
        add(listaJedi);

                JLabel rejestracjaZakonuJedi = new JLabel("Rejestacja Zakonu Jedi");
                rejestracjaZakonuJedi.setFont(font1);
                rejestracjaZakonuJedi.setBounds(130,350, 200, 30);
                add(rejestracjaZakonuJedi);

                JLabel rejestracjaJedi = new JLabel("Rejestacja Jedi");
                rejestracjaJedi.setFont(font1);
                rejestracjaJedi.setBounds(570,350, 200, 30);
                add(rejestracjaJedi);

                JLabel nazwaZakonu = new JLabel("Nazwa:");
                nazwaZakonu.setFont(font1);
                nazwaZakonu.setBounds(40,380, 50, 30);
                add(nazwaZakonu);


        JTextArea rejestracjaZakonNazwa = new JTextArea();
        rejestracjaZakonNazwa.setBounds(150, 385, 240, 20);
        rejestracjaZakonNazwa.setLineWrap(true);
        add(rejestracjaZakonNazwa);

        JButton wybierz = new JButton("Wybierz");
        wybierz.setBounds(40,420,80,20);
        add(wybierz);

        JList<Zakon> dostepneZakony = new JList<Zakon>();
        dostepneZakony.setBounds(150, 420, 240, 150);
        add(dostepneZakony);

        JButton importujZakon = new JButton("Import");
        importujZakon.setBounds(40,550,80,20);
        add(importujZakon);

        JButton eksportujZakon = new JButton("Export");
        eksportujZakon.setBounds(40,580,80,20);
        add(eksportujZakon);

        String Path =System.getProperty("user.home");
        Path+= "\\Desktop\\jedi.txt";
        JTextField sciezkaZakon = new JTextField(Path);
        sciezkaZakon.setBounds(150,580,240,20);
        sciezkaZakon.setEditable(false);
        add(sciezkaZakon);

        JButton zarejestrujZakon = new JButton("Zarejestruj");
        zarejestrujZakon.setBounds(150,610,100,20);
        add(zarejestrujZakon);
        zarejestrujZakon.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Zakon zakon = new Zakon(rejestracjaZakonNazwa.getText());
            zakony.add(zakon);
            defaultListModel1.addElement(zakon.toString());
            rejestracjaZakonNazwa.setText("");
        }
         });

        JButton wyczyscZakon = new JButton("Wyczyść");
        wyczyscZakon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {rejestracjaZakonNazwa.setText("");}
		});
        wyczyscZakon.setBounds(290,610,100,20);
        add(wyczyscZakon);

                JLabel nazwaJedi = new JLabel("Nazwa:");
                nazwaJedi.setFont(font1);
                nazwaJedi.setBounds(440,380, 50, 30);
                add(nazwaJedi);

        JTextArea rejestracjaJediNazwa = new JTextArea();
        rejestracjaJediNazwa.setBounds(550, 385, 240, 20);
        rejestracjaJediNazwa.setLineWrap(true);
        add(rejestracjaJediNazwa);

                JLabel kolorMiecza = new JLabel("Kolor Miecza:");
                kolorMiecza.setFont(font1);
                kolorMiecza.setBounds(440,420, 100, 30);
                add(kolorMiecza );

        String[] tab = {"Czerwony", "Niebieski", "Zielony", "Źółty"};

        JComboBox<String> dostepneMiecze = new JComboBox<String>(tab);
        dostepneMiecze.setBounds(550,425, 240, 20);
        add(dostepneMiecze);

                JLabel moc = new JLabel("Moc:");
                moc.setFont(font1);
                moc.setBounds(440,460, 50, 30);
                add(moc);

        JSlider ileMocy = new JSlider(JSlider.HORIZONTAL, 0, 1000, 50);
        ileMocy.setBounds(550, 465, 240, 20);
        ileMocy.setValue(0);
        add(ileMocy);

                JLabel minMoc = new JLabel("0");
                minMoc.setFont(font1);
                minMoc.setBounds(555,475, 20, 30);
                add(minMoc);

                JLabel maxMoc = new JLabel("1000");
                maxMoc.setFont(font1);
                maxMoc.setBounds(760,475, 40, 30);
                add(maxMoc);

                JLabel stronaMocy = new JLabel("Strona Mocy:");
                stronaMocy.setFont(font1);
                stronaMocy.setBounds(540,510, 100, 30);
                add(stronaMocy);

        JRadioButton jasna = new JRadioButton("Jasna");
        jasna.setBounds(650, 515, 60, 20);
        add(jasna);
        bgroup.add(jasna);

        JRadioButton ciemna = new JRadioButton("Ciemna");
        ciemna.setBounds(720, 515, 60, 20);
        add(ciemna);
        bgroup.add(ciemna);

        JButton importujJedi = new JButton("Import");
        importujJedi.setBounds(440,550,80,20);
        add(importujJedi);

        JButton eksportujJedi = new JButton("Export");
        eksportujJedi.setBounds(440,580,80,20);
        add(eksportujJedi);

        JTextField sciezkaJedi = new JTextField(Path);
        sciezkaJedi.setBounds(550,580,240,20);
        sciezkaJedi.setEditable(false);
        add(sciezkaJedi);

        JButton zarejestrujJedi = new JButton("Zarejestruj");
        zarejestrujJedi.setBounds(550,610,100,20);
        add(zarejestrujJedi);
        zarejestrujJedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RycerzJedi rycerzJedi = new RycerzJedi(rejestracjaJediNazwa.getText(), dostepneMiecze.getSelectedIndex(), (String) dostepneMiecze.getSelectedItem(), ileMocy.getValue(), ciemna.isSelected());
                rycerzJedis.add(rycerzJedi);
                defaultListModel.addElement(rycerzJedi.toString());
                rejestracjaJediNazwa.setText("");
                ileMocy.setValue(0);
                jasna.setSelected(false);
                ciemna.setSelected(false);
                dostepneMiecze.setSelectedIndex(0);
            }
        });
        JButton wyczyscJedi = new JButton("Wyczyść");
        wyczyscJedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rejestracjaJediNazwa.setText("");
                ileMocy.setValue(0);
                jasna.setSelected(false);
                ciemna.setSelected(false);
                dostepneMiecze.setSelectedIndex(0);
            }
        });
        wyczyscJedi.setBounds(690,610,100,20);
        add(wyczyscJedi);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 650);
    }
}

class Zakon
{
    String nazwa;

    public Zakon(String nazwa)
    {
        this.nazwa = nazwa;
    }
    public String getNazwa() {return nazwa;}
    public void setNazwa(String nazwa) {this.nazwa = nazwa;}

    @Override
    public String toString() {
    return nazwa;
    }
}

class RycerzJedi
{
    String nazwa;
    int nrMiecza;
    String kolorMiecza;
    int moc;
    boolean czyCiemna;

    public RycerzJedi(String nazwa, int nrMiecza, String kolorMiecza, int moc, boolean czyCiemna)
    {
        this.nazwa = nazwa;
        this.nrMiecza = nrMiecza;
        this.kolorMiecza = kolorMiecza;
        this.moc = moc;
        this.czyCiemna = czyCiemna;

    }
    public String getNazwa() {return nazwa;}
    public void setNazwa(String nazwa) {this.nazwa = nazwa;}
    public int getNrMiecza() {return nrMiecza;}
    public void setNrMiecza(int nrMiecza) {this.nrMiecza = nrMiecza;}
    public String getKolorMiecza() {return kolorMiecza;}
    public void setKolorMiecza(String kolorMiecza) {this.kolorMiecza = kolorMiecza;}
    public int getMoc() {return moc;}
    public void setMoc(int moc) {this.moc = moc;}
    public boolean isCzyCiemna() {return czyCiemna;}
    public void setCzyCiemna(boolean czyCiemna) {this.czyCiemna = czyCiemna;}

    @Override
    public String toString() {
        return nazwa + ", Miecz: " + kolorMiecza +", moc: " + moc + ", Ciemna Strona? - " + czyCiemna;
    }
}


