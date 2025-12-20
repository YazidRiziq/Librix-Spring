package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.model.OfficerModel;

@Repository
public class OfficerRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public OfficerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertOfficer(OfficerModel officerModel) {
        jdbcTemplate.update(
            "Call AddOfficer(?, ?, ?, ?)",
            officerModel.getOffName(),
            officerModel.getOffEmail(),
            officerModel.getOffTelp(),
            officerModel.getOffPassword()
        );
    }

    public List<OfficerModel> findAllOfficers() {
        return jdbcTemplate.query(
            "SELECT * FROM officer",
            (rs, rowNum) -> {
                OfficerModel o = new OfficerModel();
                o.setOffID(rs.getString("OffID"));
                o.setOffName(rs.getString("OffName"));
                o.setOffEmail(rs.getString("OffEmail"));
                o.setOffTelp(rs.getString("OffTelp"));
                o.setOffPassword(rs.getString("OffPassword"));
                return o;
            }
        );
    }

    public OfficerModel findByEmail(String email) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM officer WHERE OffEmail = ?",
            (rs, rowNum) -> {
                OfficerModel o = new OfficerModel();
                o.setOffID(rs.getString("OffID"));
                o.setOffName(rs.getString("OffName"));
                o.setOffEmail(rs.getString("OffEmail"));
                o.setOffTelp(rs.getString("OffTelp"));
                o.setOffPassword(rs.getString("OffPassword"));
                return o;
            },
            email
        );
    }

}
