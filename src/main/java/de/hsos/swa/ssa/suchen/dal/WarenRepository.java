package de.hsos.swa.ssa.suchen.dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import de.hsos.swa.ssa.JDBC.repository.ShopRepository;
import de.hsos.swa.ssa.JDBC.repository.dao.ShopRepositoryDAO;
import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.SuchAlgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenRepository implements Katalog {

    // Database
    ShopRepositoryDAO shopRepository = new ShopRepository();

    Scanner input = new Scanner(System.in);

    @Override
    public void legeSuchalgorithmusFest(SuchAlgorithmus suchalgorithmus) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Ware> suchen(String wareName) {
        List<Ware> wares = new ArrayList<Ware>();
        try {
            wares = this.shopRepository.select(wareName);
            if (wares != null) {
                wares.forEach(System.out::println);
                System.out.println("waren gefunden = " + wares.size());
            }
            if (wares.size() == 0) {
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
    public Ware suchen(long wareNummer) {
        try {
            Ware ware = this.shopRepository.select(wareNummer);
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
    public List<Produktinformation> gebeProduktinformationen(long wareNummer) {
        List<Produktinformation> wareInfos = new ArrayList<Produktinformation>();
        try {
            wareInfos = this.shopRepository.selectInofs(wareNummer);
            if (wareInfos != null) {
                wareInfos.forEach(System.out::println);
                System.out.println("waren gefunden = " + wareInfos.size());
            }
            if (wareInfos.size() == 0) {
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
    public List<Ware> gebeWaren() {
        List<Ware> wares = new ArrayList<Ware>();
        try {
            wares = this.shopRepository.selectAll();
            if (wares != null) {
                wares.forEach(System.out::println);
            }
            if (wares.size() == 0) {
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

}
