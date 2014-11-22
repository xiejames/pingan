package com.paic.pafa2.integration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.paic.pafa.framework.servicelocator.LocatorManager;
import com.paic.pafa.framework.servicelocator.ServiceLocator;
import com.paic.pafa.framework.servicelocator.ServiceLocatorException;
import com.paic.pafa2.common.PafaDTO;

public class PolicyDAO {

	private ServiceLocator locator;

	private LocatorManager manager;

	private String tableName = Messages.getString("PafaDAO.table"); //$NON-NLS-1$

	private String dataSourceName = Messages.getString("PafaDAO.jdbc"); //$NON-NLS-1$

	public PolicyDAO() {

	}

	public void insert(PafaDTO dto) throws SQLException {
		PreparedStatement pstmt;
		Connection con = this.getConnection();

		String sqlStr = "insert into " + tableName;
		sqlStr += "(" + dto.getVarName(0);
		for (int i = 1; i < dto.getVarAmount(); i++) {
			sqlStr +=","+ dto.getVarName(i);
		}
		sqlStr += ")  values(?";
		for (int i = 1; i < dto.getVarAmount(); i++) {
			sqlStr += ",?";
		}
		sqlStr += ")";
		System.out.println(sqlStr);
		try {
			pstmt = con.prepareStatement(sqlStr);
			for (int i = 0; i < dto.getVarAmount(); i++) {
				pstmt.setString(i + 1, dto.getVarValue(i));
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.closeConnection(con);
		}
	}

	public PafaDTO query(PafaDTO dto, String queryKey) throws SQLException {
		PafaDTO result = new PafaDTO(dto.getVarAmount());

		PreparedStatement pstmt;
		Connection con = this.getConnection();
		String sqlStr = "select * from " + tableName + " where " + queryKey
				+ " =?";
		System.out.println(sqlStr);
		try {
			pstmt = con.prepareStatement(sqlStr);
			pstmt.setString(1, dto.getVarValue(queryKey));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				for (int i = 0; i < dto.getVarAmount(); i++) {
					result.setVarName(i, dto.getVarName(i));
					result.setVarValue(i, rs.getString(dto.getVarName(i)));
					System.out.println("from dao: " + dto.getVarName(i) + ":"
							+ rs.getString(i + 1));
				}
			}
			rs.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.closeConnection(con);
		}
	}

	public void update(PafaDTO dto, String updateKey) throws SQLException {
		PafaDTO result = new PafaDTO();

		PreparedStatement pstmt;
		Connection con = this.getConnection();
		String sqlStr = "update " + tableName + " set  ";
		for (int i = 0; i < dto.getVarAmount(); i++) {
			sqlStr += dto.getVarName(i) + "=?";
			if (i != dto.getVarAmount() - 1)
				sqlStr += ",";
		}
		sqlStr += "  where " + updateKey + "=?";
		System.out.println(sqlStr);
		try {
			pstmt = con.prepareStatement(sqlStr);
			for (int i = 0; i < dto.getVarAmount(); i++)
				pstmt.setString(i+1, dto.getVarValue(i));

			pstmt.setString(dto.getVarAmount()+1, dto.getVarValue(updateKey));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.closeConnection(con);
		}
	}

	public int delete(PafaDTO dto, String deleteKey) throws SQLException {
		PafaDTO result = new PafaDTO();

		PreparedStatement pstmt;
		Connection con = this.getConnection();
		String sqlStr = "delete from " + tableName + " where " + deleteKey
				+ " =?";
		System.out.println(sqlStr);
		try {
			pstmt = con.prepareStatement(sqlStr);
			pstmt.setString(1, dto.getVarValue(deleteKey));
			int lines = pstmt.executeUpdate();
			System.out.println(lines);
			return lines;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.closeConnection(con);
		}
	}

	private Connection getConnection() {
		Connection con = null;
		try {
			this.manager = LocatorManager.getLocatorManager();
			this.locator = manager.getLocator(Messages
					.getString("PafaDAO.jndi")); //$NON-NLS-1$
			DataSource ds = locator.getDataSource(dataSourceName);
			con = ds.getConnection();
		} catch (ServiceLocatorException se) {
			se.printStackTrace();
			System.out.println("wrong in se!"); //$NON-NLS-1$
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("wrong in ee!"); //$NON-NLS-1$
		}
		return con;
	}

	private void closeConnection(Connection con) {
		System.out.println("************ To release Resource **************"); //$NON-NLS-1$
		try {
			if (con != null)
				con.close();
			System.out.println("      " + "Connection Released"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("************ END release Resource **************"); //$NON-NLS-1$
	}
}
