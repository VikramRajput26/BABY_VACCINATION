package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.VaccineScheduleDTO;
import com.app.entity.VaccineSchedule;
import com.app.repository.VaccineScheduleRepository;

@Service
public class VaccineScheduleServiceImpl implements VaccineScheduleService {
	@Autowired
	private final VaccineScheduleRepository vaccineScheduleRepository;
	@Autowired
	private final ModelMapper modelMapper;

	public VaccineScheduleServiceImpl(VaccineScheduleRepository vaccineScheduleRepository, ModelMapper modelMapper) {
		this.vaccineScheduleRepository = vaccineScheduleRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public VaccineScheduleDTO createVaccineSchedule(VaccineScheduleDTO vaccineScheduleDTO) {
		VaccineSchedule vaccineSchedule = modelMapper.map(vaccineScheduleDTO, VaccineSchedule.class);
		vaccineSchedule = vaccineScheduleRepository.save(vaccineSchedule);
		return modelMapper.map(vaccineSchedule, VaccineScheduleDTO.class);
	}

	@Override
	public VaccineScheduleDTO getVaccineScheduleById(int id) {
		VaccineSchedule vaccineSchedule = vaccineScheduleRepository.findById(id).orElseThrow();
		return modelMapper.map(vaccineSchedule, VaccineScheduleDTO.class);
	}

	@Override
	public List<VaccineScheduleDTO> getAllVaccineSchedules() {
		return vaccineScheduleRepository.findAll().stream()
				.map(vaccineSchedule -> modelMapper.map(vaccineSchedule, VaccineScheduleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public VaccineScheduleDTO updateVaccineSchedule(int id, VaccineScheduleDTO vaccineScheduleDTO) {
		VaccineSchedule vaccineSchedule = vaccineScheduleRepository.findById(id).orElseThrow();
		modelMapper.map(vaccineScheduleDTO, vaccineSchedule);
		vaccineSchedule = vaccineScheduleRepository.save(vaccineSchedule);
		return modelMapper.map(vaccineSchedule, VaccineScheduleDTO.class);
	}

	@Override
	public void deleteVaccineSchedule(int id) {
		vaccineScheduleRepository.deleteById(id);
	}
}