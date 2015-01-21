package org.labcrypto.edusys.ws.mftvanak;

import org.labcrypto.edusys.domain.gheyas.dao.GheyasDao;
import org.labcrypto.edusys.domain.gheyas.entity.GheyasClass;
import org.labcrypto.edusys.domain.gheyas.entity.GheyasClassGroup;
import org.labcrypto.edusys.domain.gheyas.entity.GheyasStudent;
import org.labcrypto.edusys.domain.gheyas.entity.GheyasTerm;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;
import java.util.ArrayList;
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
    public List<GheyasClassGroup> getGroups() {
        return gheyasDao.getGroups(1);
    }

    @ResponseWrapper(partName = "returnParam")
    public List<GheyasClass> getClasses(@WebParam(name = "groupCode") String groupCode,
                                        @WebParam(name = "termCode") String termCode,
                                        @WebParam(name = "classNamePattern") String classNamePattern,
                                        @WebParam(name = "showAll") boolean showAll,
                                        @WebParam(name = "className") String className,
                                        @WebParam(name = "classCode") long classCode) {
        return gheyasDao.getClasses(1, groupCode, termCode, classNamePattern, showAll, className, classCode);
    }

    @ResponseWrapper(partName = "returnParam")
    public List<GheyasStudent> getStudents(@WebParam(name = "classCode") String classCode) {
        return gheyasDao.getStudents(1, classCode);
    }

    @ResponseWrapper(partName = "returnParam")
    public List<GheyasStudent> searchStudents(@WebParam(name = "name") String name,
                                              @WebParam(name = "family") String family) {
        System.out.println("name: " + name + ", family: " + family);
        if (name.trim().length() == 0 && family.trim().length() == 0) {
            GheyasStudent gheyasStudent = new GheyasStudent();
            gheyasStudent.setName("adasdasdasdasdad");
            ArrayList<GheyasStudent> list = new ArrayList<>();
            list.add(gheyasStudent);
            return list;
        }
        return gheyasDao.searchStudents(1, name, family);
    }

    @ResponseWrapper(partName = "returnParam")
    public List<GheyasClass> getCommonClasses(@WebParam(name = "groupCodes") String groupCodes,
                                              @WebParam(name = "termCodes") String termCodes) {
        return gheyasDao.getCommonClasses(groupCodes, termCodes);
    }
}
