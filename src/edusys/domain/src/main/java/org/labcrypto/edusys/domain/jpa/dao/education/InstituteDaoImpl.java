package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Institute;

public class InstituteDaoImpl extends JpaEntityDao<Institute> implements InstituteDao {

  public InstituteDaoImpl() {
    super (Institute.class);
  }
}
