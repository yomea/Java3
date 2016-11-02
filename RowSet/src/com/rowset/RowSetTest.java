package com.rowset;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

public class RowSetTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			JdbcRowSet rowSet = new JdbcRowSetImpl(
					"jdbc:mysql://localhost:3306/taotao?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC",
					"root", "root");
			rowSet.setAutoCommit(false);
			rowSet.setCommand("select username from tb_user");
			rowSet.execute();
			while (rowSet.next()) {
				System.out.println(rowSet.getString(1));

			}
			rowSet.commit();
			rowSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	public static void main(String[] args) {
		new RowSetTest().doGet(null, null);
	}

}
