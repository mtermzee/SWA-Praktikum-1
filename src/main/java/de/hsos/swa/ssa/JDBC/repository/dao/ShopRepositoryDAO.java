package de.hsos.swa.ssa.JDBC.repository.dao;

import java.sql.SQLException;
import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Ware;

public interface ShopRepositoryDAO {

    public int insert(Ware product) throws SQLException;

    public int update(Ware product) throws SQLException;

    public int delete(int productID) throws SQLException;

    public Ware select(int productID) throws SQLException;

    public List<Ware> selectAll() throws SQLException;
}
