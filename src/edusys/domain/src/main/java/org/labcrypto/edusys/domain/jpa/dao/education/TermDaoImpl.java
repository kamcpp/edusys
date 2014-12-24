package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Term;

public class TermDaoImpl extends JpaEntityDao<Term> implements TermDao {

    public TermDaoImpl() {
        super(Term.class);
    }
}
