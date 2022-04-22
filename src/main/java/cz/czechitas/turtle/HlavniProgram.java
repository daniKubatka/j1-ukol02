package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.util.zip.ZipEntry;

public class HlavniProgram {

    public void main(String[] args) {
        Turtle zofka;
        zofka = new Turtle();

        nakresliRovnoramennyTrojuhelnik(zofka, 150, 30);


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

    //todo
    private void nakresliPravouhlyTrojuhelnik(Turtle zelva, double delkaStranyA, double delkaStranyB){
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


}
