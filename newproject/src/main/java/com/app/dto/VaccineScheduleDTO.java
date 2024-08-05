package com.app.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineScheduleDTO {
    private int scheduleId;
    private ChildDTO child;
    private VaccineDTO vaccine;
    private Date scheduledDate;
    private Date administeredDate;
    private Status status;
}
