package com.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import java.util.List;

@Getter @Setter
public class TerminIznajmljivanjaDTO {
    private Long id;
    private DateTime dateTo;
    private DateTime dateFrom;
    private Long voziloId;
    private List<Long> oglasId;

    public TerminIznajmljivanjaDTO() {
    }

    public TerminIznajmljivanjaDTO(Long id, DateTime dateTo, DateTime dateFrom, Long voziloId, List<Long> oglasId) {
        this.id = id;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
        this.voziloId = voziloId;
        this.oglasId = oglasId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(DateTime dateTo) {
        this.dateTo = dateTo;
    }

    public DateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(DateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Long getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Long voziloId) {
        this.voziloId = voziloId;
    }

    public List<Long> getOglasId() {
        return oglasId;
    }

    public void setOglasId(List<Long> oglasId) {
        this.oglasId = oglasId;
    }
}
