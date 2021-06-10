package member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import member.dto.MemberDTO;
import student.dto.StudentDTO;

public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	class MyRowMapper implements RowMapper<MemberDTO>{

		@Override
		public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberDTO dto = new MemberDTO();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setSsn1(rs.getString("ssn1"));
			dto.setSsn2(rs.getString("ssn2"));
			dto.setEmail(rs.getString("email"));
			dto.setHp1(rs.getString("hp1"));
			dto.setHp2(rs.getString("hp2"));
			dto.setHp3(rs.getString("hp3"));
			dto.setJoindate(rs.getString("joindate"));
			return dto;
		}
	}
	
	private MyRowMapper mapper = new MyRowMapper();

	@Override
	public boolean checkMember(String name, String ssn1, String ssn2) {
		String sql = "select * from member where ssn1=? and ssn2=?";
		Object[] values = new Object[] {ssn1,ssn2};
		try {
			MemberDTO dto = jdbcTemplate.queryForObject(sql,mapper,values);
			return true; 
		}catch(Exception e){			
			return false;
		}
	}

	@Override
	public int insertMember(MemberDTO dto) {
		String sql = "insert into member values"
				+ "(member_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
		Object[] values = new Object[] {dto.getName(),dto.getId(),dto.getPasswd(),dto.getSsn1(),dto.getSsn2(),dto.getEmail(),dto.getHp1(),dto.getHp2(),dto.getHp3()};
		int res = jdbcTemplate.update(sql,values);
		return res;
	}

	@Override
	public List<MemberDTO> listMember() {
		String sql = "select*from member";
		
		List<MemberDTO> list = jdbcTemplate.query(sql,mapper);
		return list;
	}

	@Override
	public int deleteMember(int no) {
		String sql = "delete from member where no=?";
		Object[] values = new Object[] {no};
		int res = jdbcTemplate.update(sql,values);
		return res;
	}

	@Override
	public MemberDTO getMember(int no) {
		String sql = "select * from member where no = ?";
		MemberDTO dto = jdbcTemplate.queryForObject(sql,mapper,no);
		return dto;
	}

	@Override
	public int updateMember(MemberDTO dto) {
		
		String sql = 
				"update member set passwd=?, email=?, hp1=?, hp2=?, hp3=? where no=?";
		Object[] values = new Object[] {dto.getPasswd(),dto.getEmail(),dto.getHp1(),dto.getHp2(),dto.getHp3(),dto.getNo()};
		int res = jdbcTemplate.update(sql,values);
		return res;
	}

	@Override
	public List<MemberDTO> findMember(String search, String searchString) {
		String sql = "select * from member where " + search + " = ?";
		
		List<MemberDTO> list = jdbcTemplate.query(sql,mapper,searchString);
		return list;
	}

	@Override
	public String searchMember(String name, String ssn1, String ssn2, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
