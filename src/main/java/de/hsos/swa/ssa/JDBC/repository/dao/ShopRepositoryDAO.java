package de.hsos.swa.ssa.JDBC.repository.dao;

import java.sql.SQLException;
import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public interface ShopRepositoryDAO {

    public int insert(Ware product) throws SQLException;

    public int update(Ware product) throws SQLException;

    public int delete(long productID) throws SQLException;

    public Ware select(long productID) throws SQLException;

    public List<Ware> select(String productName, String SqlSelect) throws SQLException;

    public List<Produktinformation> selectInofs(long productID) throws SQLException;

    public List<Ware> selectAll() throws SQLException;
}
