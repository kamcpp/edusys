package com.mftvanak.edusys.engine.scheduler.education;

import java.util.List;

import com.mftvanak.edusys.engine.scheduler.education.reservation.DepartmentItem;

public interface Processor {

	List<DepartmentItem> process(String downloaded);
}
