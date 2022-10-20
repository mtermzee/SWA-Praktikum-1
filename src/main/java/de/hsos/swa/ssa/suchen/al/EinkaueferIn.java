package de.hsos.swa.ssa.suchen.al;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import de.hsos.swa.ssa.JDBC.repository.ShopRepository;
import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class EinkaueferIn implements HoleWarenkorb, SucheWare, PruefeWare, WaehleWare {
    // services
    WarenSuchenUndPruefen warenSuchenUndPruefen;
    WarenkorbVerwalten warenkorbVerwalten;

    // Database
    ShopRepository shopRepository = new ShopRepository();

    Scanner input = new Scanner(System.in);

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Produktinformation> holeDetailInformation(Ware ware) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Ware> sucheWare(String warenName) {
        List<Ware> wares = new ArrayList<Ware>();
        try {
            wares = this.shopRepository.select(warenName);
            if (wares != null) {
                wares.forEach(System.out::println);
            } else {
                System.out.println("ware not found");
            }
            input.nextLine();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");
            input.nextLine();
            input.nextLine();
        }
        return null;
    }

    @Override
    public Ware sucheWare(long warenNummer) {
        try {
            Ware ware = this.shopRepository.select(warenNummer);
            if (ware != null) {
                System.out.println(ware.toString());
            } else {
                System.out.println("ware not found");
            }
            input.nextLine();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");
            input.nextLine();
            input.nextLine();
        }
        return null;
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb(long warenKorbNummer) {
        // TODO Auto-generated method stub
        return null;
    }
}
