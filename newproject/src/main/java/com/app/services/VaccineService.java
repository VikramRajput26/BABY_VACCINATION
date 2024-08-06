package com.app.services;

import com.app.dto.VaccineDTO;
import java.util.List;

public interface VaccineService {
    VaccineDTO createVaccine(VaccineDTO vaccineDTO);
    VaccineDTO getVaccineById(int id);
    List<VaccineDTO> getAllVaccines();
    VaccineDTO updateVaccine(int id, VaccineDTO vaccineDTO);
    void deleteVaccine(int id);
}
