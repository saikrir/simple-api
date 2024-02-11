package opentracinglearning.simpleapi.repository;

import opentracinglearning.simpleapi.model.Note;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import io.micrometer.observation.annotation.Observed;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NoteRepository {

    public NoteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;

    @Observed(name = "notes.load-all-notes", contextualName = "oracle.find-all-notes")
    public List<Note> getAllNotes() {

        String sql = "SELECT * FROM APP_USER.T_USER_NOTES ORDER BY ID";

        RowMapper<Note> tRowMapper = (rs, num)-> {

            Long id = rs.getLong(1);
            String description = rs.getString(2);
            LocalDateTime localDateTime = rs.getObject(3, LocalDateTime.class);
            String status = rs.getString(4);

            return new Note(id, description, localDateTime, status);

        } ;
        return jdbcTemplate.query(sql, tRowMapper);
    }
}
