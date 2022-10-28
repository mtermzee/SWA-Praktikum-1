package de.hsos.swa.ssa.suchen.dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import de.hsos.swa.ssa.JDBC.repository.ShopRepository;
import de.hsos.swa.ssa.JDBC.repository.dao.ShopRepositoryDAO;
import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.SuchAlgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenRepository implements Katalog {

    // Database
    ShopRepositoryDAO shopRepository = new ShopRepository();

    // interface
    WarenSuche wareSuche;

    @Override
    public void legeSuchalgorithmusFest(SuchAlgorithmus suchalgorithmus) {
        if (suchalgorithmus == SuchAlgorithmus.KeywordMatching) {
            wareSuche = new KeywordMatching();
        } else if (suchalgorithmus == SuchAlgorithmus.SemanticMatching) {
            wareSuche = new SemanticMatching();
        }
    }

    @Override
    public List<Ware> suchen(String wareName) {
        List<Ware> wares = new ArrayList<Ware>();
        try {
            wares = this.shopRepository.select(wareName, wareSuche.gebeSqlFuerSucheWare());
            if (wares != null) {
                wares.forEach(System.out::println);
                System.out.println("waren gefunden = " + wares.size());
            }
            if (wares.size() == 0) {
                System.out.println("ware not found");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");

        }
        return wares;
    }

    @Override
    public Ware suchen(long wareNummer) {
        Ware ware = new Ware();
        try {
            ware = this.shopRepository.select(wareNummer);
            if (ware != null) {
                System.out.println(ware.toString());
            } else {
                System.out.println("ware not found");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");

        }
        return ware;
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

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");

        }
        return wareInfos;
    }

    @Override
    public List<Ware> gebeWaren() {
        List<Ware> wares = new ArrayList<Ware>();
        try {
            wares = this.shopRepository.selectAll();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");

        }
        return wares;
    }

    @Override
    public void addWare(Ware ware) {
        try {
            this.shopRepository.insert(ware);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");

        }

    }

    @Override
    public void deleteWare(long wareNummer) {
        try {
            this.shopRepository.delete(wareNummer);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");

        }

    }

    @Override
    public void updateWare(Ware ware) {
        try {
            this.shopRepository.update(ware);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");

        }
    }

}
