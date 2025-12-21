package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.dto.Member.PutMemberDTO;
import com.example.librix_spring.model.MemberModel;

@Repository
public class MemberRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertMember(MemberModel memberModel) {
        jdbcTemplate.update(
            "Call AddMember (?, ?, ?, ?, ?)",
            memberModel.getMemName(),
            memberModel.getMemEmail(),
            memberModel.getMemTelp(),
            memberModel.getMemAddress(),
            memberModel.getMemPassword()
        );
    }

    public List<MemberModel> findAllMembers() {
        return jdbcTemplate.query(
            "SELECT * FROM member",
            (rs, rowNum) -> {
                MemberModel m = new MemberModel();
                m.setMemID(rs.getString("MemID"));
                m.setMemName(rs.getString("MemName"));
                m.setMemEmail(rs.getString("MemEmail"));
                m.setMemTelp(rs.getString("MemTelp"));
                m.setMemAddress(rs.getString("MemAddress"));
                m.setRegDate(rs.getDate("RegDate").toLocalDate());
                m.setMemPassword(rs.getString("MemPassword"));
                return m;
            }
        );
    }

    public MemberModel findById(String memID) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM member WHERE MemID = ?",
            (rs, rowNum) -> {
                MemberModel m = new MemberModel();
                m.setMemID(rs.getString("MemID"));
                m.setMemName(rs.getString("MemName"));
                m.setMemEmail(rs.getString("MemEmail"));
                m.setMemTelp(rs.getString("MemTelp"));
                m.setMemAddress(rs.getString("MemAddress"));
                m.setRegDate(rs.getDate("RegDate").toLocalDate());
                m.setMemPassword(rs.getString("MemPassword"));
                return m;
            },
            memID
        );
    }

    public MemberModel findByEmail(String email) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM member WHERE MemEmail = ?",
            (rs, rowNum) -> {
                MemberModel m = new MemberModel();
                m.setMemID(rs.getString("MemID"));
                m.setMemName(rs.getString("MemName"));
                m.setMemEmail(rs.getString("MemEmail"));
                m.setMemTelp(rs.getString("MemTelp"));
                m.setMemAddress(rs.getString("MemAddress"));
                m.setMemPassword(rs.getString("MemPassword"));
                m.setRegDate(rs.getDate("RegDate").toLocalDate());
                return m;
            }, 
            email
        );
    }

    public int updateMember(String memID, PutMemberDTO dto) {
        return jdbcTemplate.update(
            "UPDATE member SET MemName = ?, MemEmail = ?, MemTelp = ?, MemAddress = ? WHERE MemID = ?",
            dto.getMemName(),
            dto.getMemEmail(),
            dto.getMemTelp(),
            dto.getMemAddress(),
            memID
        );
    }

    public int deleteMember(String memID) {
        return jdbcTemplate.update(
            "DELETE FROM member WHERE MemID = ?",
            memID
        );
    }

}
