package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Term;

public class TermDao extends EntityDao<Term> {

    public TermDao() {
        super(Term.class);
    }
}