package com.app.services;

import com.app.dto.VaccineScheduleDTO;
import java.util.List;

public interface VaccineScheduleService {
    VaccineScheduleDTO createVaccineSchedule(VaccineScheduleDTO vaccineScheduleDTO);
    VaccineScheduleDTO getVaccineScheduleById(int id);
    List<VaccineScheduleDTO> getAllVaccineSchedules();
    VaccineScheduleDTO updateVaccineSchedule(int id, VaccineScheduleDTO vaccineScheduleDTO);
    void deleteVaccineSchedule(int id);
}
