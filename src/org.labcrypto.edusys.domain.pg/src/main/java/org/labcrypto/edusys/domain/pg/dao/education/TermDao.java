package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Term;


public class TermDao extends EntityDao < Term > {

  public TermDao () {
    super (Term.class);
  }
}
