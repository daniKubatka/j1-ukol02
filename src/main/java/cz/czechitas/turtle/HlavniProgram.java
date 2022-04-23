package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.util.zip.ZipEntry;

public class HlavniProgram {

    public void main(String[] args) {
        Turtle zofka;
        Turtle leonardo;
        Turtle rafael;

        zofka = new Turtle();
        nakresliZmrzlinu(zofka, 215.00, 15.00);

        leonardo = new Turtle();
        nakresliSnehulaka(leonardo);

        rafael = new Turtle();
        nakresliVlacek(rafael);
    }

    private void nakresliMnohouhelnik(Turtle zelva, double delkaStrany, int pocetStran) {
        double uhel = 360.0 / pocetStran;
        for (int i = 0; i < pocetStran; i++) {
            zelva.move(delkaStrany);
            zelva.turnRight(uhel);
        }
    }

    private void nakresliCtverec(Turtle zelva, double delkaStrany) {
        nakresliMnohouhelnik(zelva, delkaStrany, 4);
    }

    private void nakresliRovnostrannyTrojuhelnik(Turtle zelva, double delkastrany){
        nakresliMnohouhelnik(zelva, delkastrany, 3);
    }

    private void nakresliRovnoramennyTrojuhelnik(Turtle zelva, double delkaStranyAB, double uhel){
        double stranaC = vypocitejDelkuTretiStrany(delkaStranyAB, uhel);
        double druhyUhel = (180 - uhel)/2;
        zelva.move(delkaStranyAB);
        zelva.turnLeft(180 - uhel);
        zelva.move(delkaStranyAB);
        zelva.turnLeft(180 - druhyUhel);
        zelva.move(stranaC);
    }

    public double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((velikostRamene * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0)) * 2.0);
        return tretiStrana;
    }

    private void nakresliObdelnik(Turtle zelva,double delkaKratsiStrany, double delkaDelsiStrany){
        for (int i = 0; i < 2; i++) {
            zelva.move(delkaKratsiStrany);
            zelva.turnRight(90.00);
            zelva.move(delkaDelsiStrany);
            zelva.turnRight(90.00);
        }
    }

    private void nakresliKolecko(Turtle zelva, double delkaStrany) {
        nakresliMnohouhelnik(zelva, delkaStrany, 24);
    }

    private void nakresliZmrzlinu(Turtle zelva, double velikostKornoutu, double velikostKopecku){
        zelva.setLocation(150.00, 150.00);
        zelva.turnRight(165.00);
        nakresliRovnoramennyTrojuhelnik(zelva, velikostKornoutu, 30.00);
        zelva.turnRight(90.00);
        nakresliKolecko(zelva, velikostKopecku);
    }

    private void nakresliSnehulaka(Turtle zelva){
        zelva.setLocation(450.00, 250.00);
        zelva.turnRight(90.00);
        nakresliKolecko(zelva, 25.00);
        zelva.setLocation(470, 250);
        zelva.turnLeft(180.00);
        nakresliKolecko(zelva, 16.00);
        zelva.setLocation(470.00, 127.00);
        nakresliKolecko(zelva, 11.00);
        zelva.setLocation(385, 210);
        nakresliKolecko(zelva, 5.00);
        zelva.setLocation(545.00, 210.00);
        nakresliKolecko(zelva, 5.00);
    }

    private void nakresliVlacek(Turtle zelva){
        zelva.setLocation(1050.00, 450.00);
        zelva.turnLeft(90.00);
        nakresliObdelnik(zelva, 230.00, 115.00);
        zelva.turnRight(90.00);
        nakresliObdelnik(zelva, 230.00, 150.00);
        nakresliKolecko(zelva, 20.00);
        zelva.setLocation(950.00, 488.00);
        nakresliKolecko(zelva, 8.00);
        zelva.setLocation(850.00, 488.00);
        nakresliKolecko(zelva, 8.00);
        zelva.setLocation(700.00, 488.00);
        zelva.turnRight(90.00);
        nakresliRovnoramennyTrojuhelnik(zelva, 120.00, 90.00);
    }
}
