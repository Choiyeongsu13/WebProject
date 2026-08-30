package com.profill.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.profill.util.DBManager;

public class ProfillDAO {
	private ProfillDAO() {}
	public static ProfillDAO profill = new ProfillDAO();
	public static ProfillDAO getInstance() {
		return profill;
	}
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//home 페이지 대표 프로젝트메소드
	public List<ProjectDTO> projectFeatured(int limit) {

		List<ProjectDTO> list = new ArrayList<ProjectDTO>();

		String sql = "select * from ( "
		           + "  select project_id, title, subtitle, description, category_code, thumbnail, github_url, demo_url, team_size, my_role, "
		           + " is_featured, sort_order,to_char(started_on,'YYYY.MM') AS started_on,to_char(ended_on,'YYYY.MM') as ended_on from project where is_featured = 'Y' "
		           + " order by sort_order, project_id "
		           + ") where rownum <= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, limit);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProjectDTO dto = new ProjectDTO();

				dto.setProject_id(rs.getInt("project_id"));
				dto.setTitle(rs.getString("title"));
				dto.setSubtitle(rs.getString("subtitle"));
				dto.setDescription(rs.getString("description"));
				dto.setCategory_code(rs.getString("category_code"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setGithub_url(rs.getString("github_url"));
				dto.setDemo_url(rs.getString("demo_url"));
				dto.setTeam_size(rs.getInt("team_size"));
				dto.setMy_role(rs.getString("my_role"));
				dto.setSort_order(rs.getInt("sort_order"));
				dto.setStarted_on(rs.getString("started_on"));
				dto.setEnded_on(rs.getString("ended_on"));

				dto.setFeatured("Y".equals(rs.getString("is_featured")));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//작업물 전체 목록
	public List<ProjectDTO> projectList() {
		List<ProjectDTO> list = new ArrayList<ProjectDTO>();
		String sql = "select project_id, title, subtitle, description, category_code, thumbnail, "
		           + "       github_url, demo_url, team_size, my_role, is_featured, sort_order, "
		           + "       to_char(started_on,'YYYY.MM') as started_on, "
		           + "       to_char(ended_on,'YYYY.MM')   as ended_on "
		           + "  from project "
		           + " order by sort_order, project_id";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProjectDTO dto = new ProjectDTO();
				dto.setProject_id(rs.getInt("project_id"));
				dto.setTitle(rs.getString("title"));
				dto.setSubtitle(rs.getString("subtitle"));
				dto.setDescription(rs.getString("description"));
				dto.setCategory_code(rs.getString("category_code"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setGithub_url(rs.getString("github_url"));
				dto.setDemo_url(rs.getString("demo_url"));
				dto.setTeam_size(rs.getInt("team_size"));
				dto.setMy_role(rs.getString("my_role"));
				dto.setSort_order(rs.getInt("sort_order"));
				dto.setStarted_on(rs.getString("started_on"));
				dto.setEnded_on(rs.getString("ended_on"));
				dto.setFeatured("Y".equals(rs.getString("is_featured")));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	
	//home 화면용
	public List<PostDTO> postRecent(String categoryCode, int limit) {
		List<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "select * from ( "
		           + "  select p.post_id, p.category_id, p.title, p.summary, p.thumbnail, "
		           + "         p.read_minutes, p.status, p.view_count, "
		           + "         to_char(p.created_at,'YYYY.MM.DD')   as created_at, "
		           + "         to_char(p.published_at,'YYYY.MM.DD') as published_at "
		           + "    from post p join category c on c.category_id = p.category_id "
		           + "   where p.status = 'PUBLISHED' and c.code = ? "
		           + "   order by p.published_at desc, p.post_id desc "
		           + ") where rownum <= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryCode);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setPostid(rs.getInt("post_id"));
				dto.setCategoryid(rs.getInt("category_id"));
				dto.setTitle(rs.getString("title"));
				dto.setSummary(rs.getString("summary"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setReadminutes(rs.getInt("read_minutes"));
				dto.setStatus(rs.getString("status"));
				dto.setViewcount(rs.getInt("view_count"));
				dto.setCreadtedat(rs.getString("created_at"));
				dto.setPublishedat(rs.getString("published_at"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//글목록
	public List<PostDTO> postList(String categoryCode) {
		List<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "select p.post_id, p.category_id, p.title, p.summary, p.thumbnail, "
		           + "       p.read_minutes, p.status, p.view_count, "
		           + "       to_char(p.created_at,'YYYY.MM.DD')   as created_at, "
		           + "       to_char(p.published_at,'YYYY.MM.DD') as published_at "
		           + "  from post p join category c on c.category_id = p.category_id "
		           + " where p.status = 'PUBLISHED' "
		           + "   and (? is null or c.code = ?) "
		           + " order by p.published_at desc, p.post_id desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryCode);
			pstmt.setString(2, categoryCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setPostid(rs.getInt("post_id"));
				dto.setCategoryid(rs.getInt("category_id"));
				dto.setTitle(rs.getString("title"));
				dto.setSummary(rs.getString("summary"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setReadminutes(rs.getInt("read_minutes"));
				dto.setStatus(rs.getString("status"));
				dto.setViewcount(rs.getInt("view_count"));
				dto.setCreadtedat(rs.getString("created_at"));
				dto.setPublishedat(rs.getString("published_at"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public PostDTO postView(int postId) {
		PostDTO dto = null;
		String sql = "select p.post_id, p.category_id, p.title, p.slug, p.summary, p.content, "
		           + "       p.thumbnail, p.read_minutes, p.status, p.view_count, "
		           + "       to_char(p.created_at,'YYYY.MM.DD')   as created_at, "
		           + "       to_char(p.updated_at,'YYYY.MM.DD')   as updated_at, "
		           + "       to_char(p.published_at,'YYYY.MM.DD') as published_at "
		           + "  from post p "
		           + " where p.post_id = ? and p.status = 'PUBLISHED'";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new PostDTO();
				dto.setPostid(rs.getInt("post_id"));
				dto.setCategoryid(rs.getInt("category_id"));
				dto.setTitle(rs.getString("title"));
				dto.setSlug(rs.getString("slug"));
				dto.setSummary(rs.getString("summary"));
				dto.setContent(rs.getString("content"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setReadminutes(rs.getInt("read_minutes"));
				dto.setStatus(rs.getString("status"));
				dto.setViewcount(rs.getInt("view_count"));
				dto.setCreadtedat(rs.getString("created_at"));
				dto.setUpdatedat(rs.getString("updated_at"));
				dto.setPublishedat(rs.getString("published_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	//조회수 1증가
	public int postCountUp(int postId) {
		int result = 0;
		String sql = "update post set view_count = view_count + 1 where post_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//글 댓글
	public List<PostcommentDTO> commentList(int postId){
		List<PostcommentDTO> list = new ArrayList<PostcommentDTO>();

		String sql = "select comment_id, post_id, parent_id, nickname, content, "
				+ "       is_secret, is_deleted, "
				+ "       to_char(created_at,'YYYY.MM.DD HH24:MI') as created_at "
				+ "  from post_comment "
				+ " where post_id = ? "
				+ " order by case when parent_id is null then comment_id else parent_id end, "
				+ "          comment_id";

		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				PostcommentDTO dto = new PostcommentDTO();
				dto.setCommentid(rs.getInt("comment_id"));
				dto.setPostid(rs.getInt("post_id"));
				dto.setParentid(rs.getInt("parent_id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setSecret("Y".equals(rs.getString("is_secret")));
				dto.setDeleted("Y".equals(rs.getString("is_deleted")));
				dto.setCreatedat(rs.getString("created_at"));

				if(dto.isDeleted()) {
					dto.setContent("");
				}else {
					dto.setContent(rs.getString("content"));
				}

				dto.setReply(dto.getParentid() != 0);
				list.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
	}
	
	//댓글 등록 
	public int commentInsert(PostcommentDTO dto) {
		int result = 0;
		String sql = "insert into post_comment ("
				+"post_id,parent_id,nickname,password,content, is_secret)"
				+"values(?,?,?,lower(standard_hash(?,'SHA256')),?,?)";
	
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
				conn= DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getPostid());
				
				if(dto.getParentid() > 0 ) {
					pstmt.setInt(2, dto.getParentid());
				}else {
					pstmt.setNull(2, Types.NUMERIC);
				}
				
				pstmt.setString(3, dto.getNickname());
				pstmt.setString(4, dto.getPassword());
				pstmt.setString(5, dto.getContent());
				pstmt.setString(6, dto.isSecret() ? "Y" : "N");
				
				result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt , rs);
		}return result;
		
	}
	
	//댓글 삭제
	
	public int commentDelete(int commentld, String password) {
		int result = 0 ;
		String sql = "update post_comment set is_deleted ='Y' where comment_id = ? "
				+"and is_deleted = 'N' and lower(password) = lower(standard_hash(?,'SHA256'))";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentld);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return result;
	
	}

	//여행 앨범 목록
	
	public List<AlbumDTO> albumList(){
		List<AlbumDTO> list = new ArrayList<AlbumDTO>();
		String sql = "select album_id,title,place,country,description,\r\n"
				+ "				to_char(travel_from,'YYYY.MM.DD') as travel_from,\r\n"
				+ "				to_char(travel_to,'YYYY.MM.DD') as travel_to,\r\n"
				+ "				latitude,longitude,post_id,\r\n"
				+ "				to_char(created_at,'YYYY.MM.DD') as created_at\r\n"
				+ "				from album order by travel_from desc, album_id desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				AlbumDTO dto = new AlbumDTO();
				dto.setAlbumid(rs.getInt("album_id"));
				dto.setTitle(rs.getString("title"));
				dto.setPlace(rs.getString("place"));
				dto.setCountry(rs.getString("country"));
				dto.setDescription(rs.getString("description"));
				dto.setTravelfrom(rs.getString("travel_from"));
				dto.setTravelto(rs.getString("travel_to"));
				dto.setLatitude(rs.getDouble("latitude"));
				dto.setLongitude(rs.getDouble("longitude"));
				dto.setPostid(rs.getInt("post_id"));
				dto.setCreatedat(rs.getString("created_at"));
				list.add(dto);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
	}
	//앨범 속 사진 목록
	public List<PhotoDTO> photoList(int albumld){
		List<PhotoDTO> list = new ArrayList<PhotoDTO>();
		String  sql = "select photo_id, album_id , file_name,caption, "
				+"to_char(taken_at,'YYYY.MM.DD')as taken_at,"
				+"is_cover,sort_order from photo where album_id=? order by is_cover desc, sort_order, photo_id";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumld);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				PhotoDTO dto = new PhotoDTO();
				dto.setPhotoid(rs.getInt("photo_id"));
				dto.setAlbumid(rs.getInt("Album_id"));
				dto.setFilename(rs.getString("file_name"));
				dto.setCaption(rs.getString("caption"));
				dto.setTakenat(rs.getString("taken_at"));
				dto.setCover("Y".equals(rs.getString("is_cover")));
				dto.setSortorder(rs.getInt("sort_order"));
				list.add(dto);
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
	
	}
	
	//관리자 로그인
	
	public Blog_userDTO userLogin(String loginld,String password) {
		Blog_userDTO dto =null;
		
		String sql = "select user_id, login_id,name,email,to_char(created_at,'YYYY.MM.DD')as created_at from blog_user\r\n"
				+ "where login_id= ? and lower(password) = lower(standard_hash(?,'SHA256'))";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginld);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto= new Blog_userDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setLogin_id(rs.getString("login_id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setCreated_at(rs.getString("created_at"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return dto;
		
		
	}
	
	
	//글 저장
	
	public int postInsert(PostDTO dto , String[] tags) {
		int postId = 0;
		String sql = "insert into post (category_id,title,slug,summary,content,thumbnail,read_minutes,status,published_at) "
				+ "values(?,?,?,?,?,?,?,?, case when ? = 'PUBLISHED' then sysdate else null end)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql, new String[] { "POST_ID" });

			pstmt.setInt(1, dto.getCategoryid());
			pstmt.setString(2, dto.getTitle());
			setText(pstmt, 3, dto.getSlug());
			setText(pstmt, 4, dto.getSummary());
			pstmt.setString(5, dto.getContent());
			setText(pstmt, 6, dto.getThumbnail());

			if (dto.getReadminutes() > 0) {
				pstmt.setInt(7, dto.getReadminutes());
			} else {
				pstmt.setNull(7, Types.NUMERIC);
			}

			pstmt.setString(8, dto.getStatus());
			pstmt.setString(9, dto.getStatus());

			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				postId = rs.getInt(1);
			}
			rs.close();
			rs = null;
			pstmt.close();
			pstmt = null;

			if (postId == 0) {
				conn.rollback();
				return 0;
			}

			if (tags != null) {
				for (int i = 0; i < tags.length; i++) {
					String name = tags[i].trim();
					if (name.length() == 0) {
						continue;
					}
					int tagId = findOrCreateTag(conn, name);
					if (tagId == 0) {
						conn.rollback();
						return 0;
					}
					pstmt = conn.prepareStatement(
						"insert into post_tag (post_id, tag_id) values (?, ?)");
					pstmt.setInt(1, postId);
					pstmt.setInt(2, tagId);
					pstmt.executeUpdate();
					pstmt.close();
					pstmt = null;
				}
			}

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			postId = 0;
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.setAutoCommit(true);
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			DBManager.close(conn, pstmt, rs);
		}
		return postId;

	
	}
	
	private int findOrCreateTag(Connection conn, String name) throws Exception {
		int tagId = 0;

		PreparedStatement pstmt = conn.prepareStatement(
			"select tag_id from tag where name = ?");
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			tagId = rs.getInt(1);
		}
		rs.close();
		pstmt.close();

		if (tagId > 0) {
			return tagId;
		}

		pstmt = conn.prepareStatement(
			"insert into tag (name) values (?)", new String[] { "TAG_ID" });
		pstmt.setString(1, name);
		pstmt.executeUpdate();
		rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			tagId = rs.getInt(1);
		}
		rs.close();
		pstmt.close();

		return tagId;
	}

	private void setText(PreparedStatement pstmt, int index, String value) throws Exception {
		if (value == null || value.trim().length() == 0) {
			pstmt.setNull(index, Types.VARCHAR);
		} else {
			pstmt.setString(index, value.trim());
		}
	}


	public Map<Integer, String> projectTagMap() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		String sql = "select pt.project_id, "
		           + "       listagg(t.name, ' ') within group (order by t.name) as tags "
		           + "  from project_tag pt join tag t on t.tag_id = pt.tag_id "
		           + " group by pt.project_id";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map.put(Integer.valueOf(rs.getInt("project_id")), rs.getString("tags"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return map;
	}
	
	public Map<Integer, String> categoryList(String lang) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		String sql = "select category_id, code, name_ko, name_ja "
		           + "  from category "
		           + " order by sort_order, category_id";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name_ko");

				if ("ja".equals(lang)) {
					String ja = rs.getString("name_ja");
					if (ja != null && ja.trim().length() > 0) {
						name = ja;
					}
				}

				if (name == null || name.trim().length() == 0) {
					name = rs.getString("code");
				}

				map.put(Integer.valueOf(rs.getInt("category_id")), name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return map;
	}
	
	public List<String> postTagList(int postId) {
		List<String> list = new ArrayList<String>();
		String sql = "select t.name "
		           + "  from post_tag pt join tag t on t.tag_id = pt.tag_id "
		           + " where pt.post_id = ? "
		           + " order by t.name";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//관리자 글 수정화면 조회 (공개 여부 상관없이 가져온다)
	public PostDTO postEditView(int postId) {
		PostDTO dto = null;
		String sql = "select p.post_id, p.category_id, p.title, p.slug, p.summary, p.content, "
		           + "       p.thumbnail, p.read_minutes, p.status, p.view_count, "
		           + "       to_char(p.created_at,'YYYY.MM.DD')   as created_at, "
		           + "       to_char(p.updated_at,'YYYY.MM.DD')   as updated_at, "
		           + "       to_char(p.published_at,'YYYY.MM.DD') as published_at "
		           + "  from post p "
		           + " where p.post_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new PostDTO();
				dto.setPostid(rs.getInt("post_id"));
				dto.setCategoryid(rs.getInt("category_id"));
				dto.setTitle(rs.getString("title"));
				dto.setSlug(rs.getString("slug"));
				dto.setSummary(rs.getString("summary"));
				dto.setContent(rs.getString("content"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setReadminutes(rs.getInt("read_minutes"));
				dto.setStatus(rs.getString("status"));
				dto.setViewcount(rs.getInt("view_count"));
				dto.setCreadtedat(rs.getString("created_at"));
				dto.setUpdatedat(rs.getString("updated_at"));
				dto.setPublishedat(rs.getString("published_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}

	//글 수정
	public boolean postUpdate(PostDTO dto, String[] tags) {
		boolean success = false;
		String sql = "update post set category_id = ?, title = ?, slug = ?, summary = ?, "
		           + "       content = ?, thumbnail = ?, read_minutes = ?, updated_at = sysdate "
		           + " where post_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCategoryid());
			pstmt.setString(2, dto.getTitle());
			setText(pstmt, 3, dto.getSlug());
			setText(pstmt, 4, dto.getSummary());
			pstmt.setString(5, dto.getContent());
			setText(pstmt, 6, dto.getThumbnail());

			if (dto.getReadminutes() > 0) {
				pstmt.setInt(7, dto.getReadminutes());
			} else {
				pstmt.setNull(7, Types.NUMERIC);
			}

			pstmt.setInt(8, dto.getPostid());

			int row = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			if (row == 0) {
				conn.rollback();
				return false;
			}

			pstmt = conn.prepareStatement("delete from post_tag where post_id = ?");
			pstmt.setInt(1, dto.getPostid());
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			if (tags != null) {
				for (int i = 0; i < tags.length; i++) {
					String name = tags[i].trim();
					if (name.length() == 0) {
						continue;
					}
					int tagId = findOrCreateTag(conn, name);
					if (tagId == 0) {
						conn.rollback();
						return false;
					}
					pstmt = conn.prepareStatement(
						"insert into post_tag (post_id, tag_id) values (?, ?)");
					pstmt.setInt(1, dto.getPostid());
					pstmt.setInt(2, tagId);
					pstmt.executeUpdate();
					pstmt.close();
					pstmt = null;
				}
			}

			conn.commit();
			success = true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.setAutoCommit(true);
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			DBManager.close(conn, pstmt , rs);
		}
		return success;
	}

	//글 삭제 (post_tag, post_comment 는 외래키 ON DELETE CASCADE 로 함께 지워지고
	//         album.post_id 는 ON DELETE SET NULL 로 자동으로 비워진다)
	public boolean postDelete(int postId) {
		boolean success = false;
		String sql = "delete from post where post_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			success = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt , rs);
		}
		return success;
	}

	public List<PostDTO> postRelated(int postId, int limit) {
		List<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "select * from ( "
		           + "  select p.post_id, p.title, "
		           + "         to_char(p.created_at,'YYYY.MM.DD')   as created_at, "
		           + "         to_char(p.published_at,'YYYY.MM.DD') as published_at "
		           + "    from post p "
		           + "   where p.status = 'PUBLISHED' "
		           + "     and p.post_id <> ? "
		           + "     and p.category_id = (select category_id from post where post_id = ?) "
		           + "   order by p.published_at desc, p.post_id desc "
		           + ") where rownum <= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			pstmt.setInt(2, postId);
			pstmt.setInt(3, limit);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setPostid(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setCreadtedat(rs.getString("created_at"));
				dto.setPublishedat(rs.getString("published_at"));
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
