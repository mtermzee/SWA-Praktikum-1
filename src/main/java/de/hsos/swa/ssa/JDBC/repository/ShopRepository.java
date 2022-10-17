package de.hsos.swa.ssa.JDBC.repository;

import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import de.hsos.swa.ssa.JDBC.repository.dao.ShopRepositoryDAO;
import static de.hsos.swa.ssa.JDBC.sql.MysqlConnection.*;
import de.hsos.swa.ssa.suchen.bl.Ware;

import java.sql.*;
import java.util.*;

public class ShopRepository implements ShopRepositoryDAO {

    private Connection transConnection;

    // Define SQL sentences
    private static final String SQL_SELECT = "SELECT nummer, name, preis, beschreibung FROM ware";
    private static final String SQL_SELECT_ONE = "SELECT nummer, name, preis, beschreibung FROM ware WHERE nummer = ?";
    private static final String SQL_INSERT = "INSERT INTO ware(nummer, name, preis, beschreibung) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ware SET name=?,preis=?, beschreibung=? WHERE nummer = ?";
    private static final String SQL_DELETE = "DELETE FROM waret WHERE nummer = ?";

    public ShopRepository(Connection conn) {
        this.transConnection = conn;
    }

    public ShopRepository() {
        super();
    }

    @Override
    public int insert(Ware ware) throws SQLException {
        // vaidate ware
        if (ware.getName() == null) {
            return 0;
        }
        if (ware.getPreis() == 0) {
            return 0;
        }
        if (ware.getBeschreibung() == null) {
            return 0;
        }
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = this.transConnection != null ? this.transConnection : getConnection();
            pStatement = conn.prepareStatement(SQL_INSERT);
            pStatement.setString(1, ware.getName());
            pStatement.setDouble(2, ware.getPreis());
            pStatement.setString(3, ware.getBeschreibung());
            result = pStatement.executeUpdate();

        } catch (SQLSyntaxErrorException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (CommunicationsException ex) {
            System.err.println("Error: Can't connect with database server");
        } finally {
            try {
                if (pStatement != null)
                    close(pStatement);
                if (conn != null) {
                    if (this.transConnection == null)
                        close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    @Override
    public int update(Ware ware) throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = this.transConnection != null ? this.transConnection : getConnection();
            pStatement = conn.prepareStatement(SQL_UPDATE);
            pStatement.setString(1, ware.getName());
            pStatement.setDouble(2, ware.getPreis());
            pStatement.setString(3, ware.getBeschreibung());
            pStatement.setLong(4, ware.getNummer());
            result = pStatement.executeUpdate();
        } catch (SQLSyntaxErrorException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (CommunicationsException ex) {
            System.err.println("Error: Can't connect with database server");
        } finally {
            try {
                if (pStatement != null)
                    close(pStatement);
                if (conn != null) {
                    if (this.transConnection == null)
                        close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    @Override
    public int delete(int wareID) throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = this.transConnection != null ? this.transConnection : getConnection();
            pStatement = conn.prepareStatement(SQL_DELETE);
            pStatement.setInt(1, wareID);
            result = pStatement.executeUpdate();
        } catch (SQLSyntaxErrorException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (CommunicationsException ex) {
            System.err.println("Error: Can't connect with database server");
        } finally {
            try {
                if (pStatement != null)
                    close(pStatement);
                if (conn != null) {
                    if (this.transConnection == null)
                        close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    @Override
    public Ware select(int wareID) throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Ware ware = null;
        try {
            conn = this.transConnection != null ? this.transConnection : getConnection();
            pStatement = conn.prepareStatement(SQL_SELECT_ONE);
            pStatement.setInt(1, wareID);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                ware = new Ware(
                        rs.getLong("nummer"),
                        rs.getString("name"),
                        rs.getDouble("preis"),
                        rs.getString("beschreibung"));
            }

        } catch (SQLSyntaxErrorException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (CommunicationsException ex) {
            System.err.println("Error: Can't connect with database server");
        } finally {
            try {
                if (rs != null)
                    close(rs);
                if (pStatement != null)
                    close(pStatement);
                if (conn != null) {
                    if (this.transConnection == null)
                        close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return ware;
    }

    @Override
    public List<Ware> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        List<Ware> wares = new ArrayList<>();

        try {
            conn = this.transConnection != null ? this.transConnection : getConnection();
            pStatement = conn.prepareStatement(SQL_SELECT);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                wares.add(new Ware(
                        rs.getLong("nummer"),
                        rs.getString("name"),
                        rs.getDouble("preis"),
                        rs.getString("beschreibung")));
            }
        } catch (SQLSyntaxErrorException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (CommunicationsException ex) {
            System.err.println("Error: Can't connect with database server");
        } finally {
            try {
                if (rs != null)
                    close(rs);
                if (pStatement != null)
                    close(pStatement);
                if (conn != null) {
                    if (this.transConnection == null)
                        close(conn);
                }
            } catch (SQLException throwables) {
                // throwables.printStackTrace();
            }
        }
        return wares;
    }

}
