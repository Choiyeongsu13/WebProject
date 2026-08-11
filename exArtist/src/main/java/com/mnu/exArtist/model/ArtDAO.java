package com.mnu.exArtist.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exArtist.util.DBManager;

public class ArtDAO {
	private ArtDAO() {}
	public static ArtDAO instance = new ArtDAO();
	public static ArtDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 참가자 목록 조회
	public List<artistDTO> artistList() {
		List<artistDTO> list = new ArrayList<artistDTO>();

		String sql = "SELECT artist_id, artist_name, artist_gender, artist_birth, talent, agency FROM tbl_artist_201905";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				artistDTO dto = new artistDTO();
				dto.setArtist_id(rs.getString("artist_id"));
				dto.setArtist_name(rs.getString("artist_name"));

				String gender = rs.getString("artist_gender");
				if ("M".equals(gender)) gender = "남성";
				else if ("F".equals(gender)) gender = "여성";
				dto.setArtist_gender(gender);

				String birth = rs.getString("artist_birth");
				if (birth != null && birth.length() == 8) {
					birth = birth.substring(0, 4) + "년" + birth.substring(4, 6) + "월" + birth.substring(6, 8) + "일";
				}
				dto.setArtist_birth(birth);

				String talent = rs.getString("talent");
				if ("1".equals(talent)) talent = "댄스";
				else if ("2".equals(talent)) talent = "랩";
				else if ("3".equals(talent)) talent = "노래";
				dto.setTalent(talent);

				dto.setAgency(rs.getString("agency"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int insertArtist(artistDTO dto) {
		int row = 0;
		String sql = "INSERT INTO tbl_artist_201905 "
				+ "(artist_id, artist_name, artist_gender, artist_birth, talent, agency) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getArtist_id());
			pstmt.setString(2, dto.getArtist_name());
			pstmt.setString(3, dto.getArtist_gender());
			pstmt.setString(4, dto.getArtist_birth());
			pstmt.setString(5, dto.getTalent());
			pstmt.setString(6, dto.getAgency());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	
	//멘토점수 목록 조회
	public List<mentoScoreDTO> mentoScoreList() {
		List<mentoScoreDTO> list = new ArrayList<mentoScoreDTO>();

		String sql = "SELECT p.serial_no, p.artist_id, a.artist_name, a.artist_birth, p.point, m.mento_name "
				+ "FROM tbl_point_201905 p "
				+ "JOIN tbl_artist_201905 a ON p.artist_id = a.artist_id "
				+ "JOIN tbl_mento_201905 m ON p.mento_id = m.mento_id "
				+ "ORDER BY p.serial_no";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mentoScoreDTO dto = new mentoScoreDTO();
				dto.setSerial_no(rs.getInt("serial_no"));
				dto.setArtist_id(rs.getString("artist_id"));
				dto.setArtist_name(rs.getString("artist_name"));
				dto.setArtist_birth(rs.getString("artist_birth"));
				dto.setPoint(rs.getInt("point"));
				dto.setMento_name(rs.getString("mento_name"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<ArtistRankDTO> ArtistRankList() {
		List<ArtistRankDTO> list = new ArrayList<ArtistRankDTO>();

		String sql = "select a.artist_id,artist_name,artist_gender,sum (point) tot, round(avg(point),2) ave\r\n"
				+ "    from tbl_artist_201905 a join tbl_point_201905 p \r\n"
				+ "    on a.artist_id = p.artist_id\r\n"
				+ "        group by a.artist_id,artist_name,artist_gender\r\n"
				+ "         order by tot desc";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArtistRankDTO dto = new ArtistRankDTO();
				dto.setArtist_id(rs.getString("artist_id"));
				dto.setArtist_name(rs.getString("artist_name"));
				dto.setArtist_gender(rs.getString("artist_gender"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getDouble("ave"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public List<ArtistSearchDTO> searchArtist(String artist_id) {
		List<ArtistSearchDTO> list = new ArrayList<ArtistSearchDTO>();

		String sql = "SELECT a.artist_id, a.artist_name, a.artist_birth, m.mento_name, p.point "
				+ "FROM tbl_artist_201905 a "
				+ "JOIN tbl_point_201905 p ON a.artist_id = p.artist_id "
				+ "JOIN tbl_mento_201905 m ON p.mento_id = m.mento_id "
				+ "WHERE a.artist_id=? "
				+ "ORDER BY a.artist_id";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, artist_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArtistSearchDTO dto = new ArtistSearchDTO();
				dto.setArtist_id(rs.getString("artist_id").toUpperCase());
				dto.setArtist_name(rs.getString("artist_name"));

				String birth = rs.getString("artist_birth");
				if (birth != null && birth.length() == 8) {
					birth = birth.substring(0, 4) + "년" + birth.substring(4, 6) + "월" + birth.substring(6, 8) + "일";
				}
				dto.setArtist_birth(birth);

				dto.setMento_name(rs.getString("mento_name"));
				dto.setPoint(rs.getString("point"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}