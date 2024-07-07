package com.b430.supervisorservice.service;

import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Supervisor;

import java.util.List;

public interface ISupervisorService {

    Supervisor login(String supervisorCode, String password);

    boolean register(Supervisor supervisor);

    Supervisor getSupervisorByTelId(String supervisorTelId);

    boolean editPersonal(Supervisor supervisor);

    List<Info> getAllFeedbackList(Integer supervisorId, String sortField);

    boolean addInfo(Info info);
}
