package com.app.services;

import java.util.List;

import com.app.dto.AppointmentDTO;

public interface AppointmentService {
    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);
    AppointmentDTO getAppointmentById(int id);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO updateAppointment(int id, AppointmentDTO appointmentDTO);
    void deleteAppointment(int id);
}
