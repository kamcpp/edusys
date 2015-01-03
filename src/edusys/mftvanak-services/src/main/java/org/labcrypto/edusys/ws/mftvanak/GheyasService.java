package org.labcrypto.edusys.ws.mftvanak;

import org.labcrypto.edusys.domain.gheyas.dao.GheyasDao;
import org.labcrypto.edusys.domain.gheyas.entity.GheyasTerm;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService
public class GheyasService {

    @Inject
    private GheyasDao gheyasDao;

    @ResponseWrapper(partName = "returnParam")
    public List<GheyasTerm> getTerms() {
        return gheyasDao.getTerms(1);
    }

    @ResponseWrapper(partName = "returnParam")
    public String getName() {
        return "Test";
    }
}
