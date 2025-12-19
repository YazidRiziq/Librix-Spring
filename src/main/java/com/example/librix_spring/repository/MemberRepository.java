package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.model.MemberModel;

@Repository
public class MemberRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertMember(MemberModel memberModel) {
        jdbcTemplate.update(
            "Call AddMember (MemName, MemEmail, MemTelp, MemAddress, MemPassword) VALUES (?, ?, ?, ?, ?)",
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
            m.setRegDate(rs.getTimestamp("RegDate").toLocalDateTime());
            return m;
        }
    );
}

}
