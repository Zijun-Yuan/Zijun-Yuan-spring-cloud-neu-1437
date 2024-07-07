package com.b430.inspectorservice.service;



import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;

import java.util.List;

public interface IInspectorService {

    Inspector login(String inspectorCode, String password);

    Info getDetailedInfo(Integer infoId);

    boolean feedbackInfo(Info info);

    List<Info> getInfoList(String inspectorCode);

    Inspector getInspectorByCode(String inspectorCode);
}
