package com.mftvanak.edusys.domain.dao.education;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.education.Student;


public class StudentDao extends EntityDao < Student > {

  public StudentDao () {
    super (Student.class);
  }
}
