package com.b430.adminpersonnelservice.service;

import com.b430.commonmodule.model.dto.inspector.InspectorSelectDTO;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.model.entity.Supervisor;

import java.util.List;

public interface IAdminPersonnelService {

    boolean editSuperVisor(Supervisor supervisor);

    List<Supervisor> getAllSupervisor();

    Supervisor getOneSupervisor(String supervisorId);

    List<Inspector> getAllInspectors();

    Inspector getOneInspector(String inspectorCode);

    boolean editInspector(Inspector inspector);

    boolean addInspector(Inspector inspector);

    List<Inspector> getListByCityCodeList(List<String> cityCodeList);

    Integer getInspectorNum(InspectorSelectDTO inspectorSelectDTO);

    List<Inspector> getInspectorList(InspectorSelectDTO inspectorSelectDTO);

    Integer getSupervisorNum(String telNum);

    List<Supervisor> getSupervisorList(String telNum, Integer pageNum, Integer pageSize);
}
