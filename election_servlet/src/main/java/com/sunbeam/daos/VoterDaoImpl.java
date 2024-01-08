package com.sunbeam.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunbeam.pojo.Voter;

public class VoterDaoImpl extends Dao implements VoterDao {
	public VoterDaoImpl() throws Exception {
	}

	@Override
	public Voter findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM Voters WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					email = rs.getString("email");
					String password = rs.getString("password");
					int status = rs.getInt("status");
					Date birth = rs.getDate("dob");
					String role = rs.getString("role");
					Voter u = new Voter(id, firstName, lastName, email, password, birth, status, role);
					return u;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	@Override
	public Voter findById(int id) throws Exception {
		String sql = "SELECT * FROM Voters WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					id = rs.getInt("id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					int status = rs.getInt("status");
					Date birth = rs.getDate("dob");
					String role = rs.getString("role");
					Voter u = new Voter(id, firstName, lastName, email, password, birth, status, role);
					return u;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	@Override
	public int save(Voter Voter) throws Exception {
		String sql = "INSERT INTO Voters VALUES(default, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, Voter.getFirstName());
			stmt.setString(2, Voter.getLastName());
			stmt.setString(3, Voter.getEmail());
			stmt.setString(4, Voter.getPassword());
			stmt.setDate(5, Voter.getBirth());
			stmt.setInt(6, Voter.getStatus());
			stmt.setString(7, Voter.getRole());
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}

	@Override
	public int updateStatus(int VoterId, boolean voted) throws Exception {
		String sql = "UPDATE Voters SET status=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, (voted ? 1 : 0));
			stmt.setInt(2, VoterId);
			int cnt = stmt.executeUpdate();
			return cnt;
		} // stmt.close();
	}

	@Override
	public int updatePassword(int VoterId, String newPassword) throws Exception {
		String sql = "UPDATE Voters SET password=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, newPassword);
			stmt.setInt(2, VoterId);
			int cnt = stmt.executeUpdate();
			return cnt;
		} // stmt.close();
	}

	public int deleteById(int id) throws Exception {
		String sql = "DELETE FROM Voters WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}

	@Override
	public int update(Voter Voter) throws Exception {
		// TODO lab assignment
		return 0;
	}
}