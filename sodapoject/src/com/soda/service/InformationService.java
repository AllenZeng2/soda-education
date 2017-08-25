package com.soda.service;
import com.soda.entity.Information;
import java.util.List;

import com.soda.entity.News;
import com.soda.entity.PageInfo;

public interface InformationService{

	List<Information> getinformation(Information in);

	List<Information> conditionSelect(Information information, PageInfo pi);

	int conditionCount(Information information);

	int deleteInformation(int ns_id);

	int updateState(int in_state, int in_id);

	Information getInformationWithId(int ns_id);

	int submitInformation(Information information);

	int addInformation(Information information);
	Information selectInformationById(int in_id);
}

