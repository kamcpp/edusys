package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Term;

public class TermDaoImpl extends EntityDaoImpl<Term> {

    public TermDaoImpl() {
        super(Term.class);
    }
}
