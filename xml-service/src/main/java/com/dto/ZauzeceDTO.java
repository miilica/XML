package com.dto;

import com.Util.JsonJodaDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZauzeceDTO {

    private Long id;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime zauzetOd;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime zauzetDo;

    private Long voziloId;
    private List<Long> oglasId;
}
