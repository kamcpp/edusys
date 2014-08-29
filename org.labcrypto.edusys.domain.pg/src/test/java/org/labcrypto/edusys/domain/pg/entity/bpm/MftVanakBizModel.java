package org.labcrypto.edusys.domain.pg.entity.bpm;

//import com.mftvanak.edusys.domain.entity.bpm.template.FieldTemplate;
import org.labcrypto.edusys.domain.pg.entity.bpm.template.FlowTemplate;
import org.labcrypto.edusys.domain.pg.entity.bpm.template.StepTemplate;
import org.labcrypto.edusys.domain.pg.entity.bpm.template.SubflowTemplate;
import org.labcrypto.edusys.domain.pg.entity.personnel.Person;


public class MftVanakBizModel {

  private FlowTemplate classStartFlowTemplate;
  private SubflowTemplate subflowTemplate;
  private StepTemplate classLocationStep;
  private StepTemplate gheyasCodeStep;
  private StepTemplate contactStudentsStep;
  private StepTemplate teacherContractStep;
  private StepTemplate updateWebsiteStep;
  private StepTemplate feedbackDateStep;
  private StepTemplate checkFinancialStatusStep;
  private StepTemplate defineInCenterStep;
  /* private FieldTemplate classNameField;
  private FieldTemplate daysField;
  private FieldTemplate departmentField; */

  public void createTemplate () {
    classStartFlowTemplate = new FlowTemplate ();
    subflowTemplate = new SubflowTemplate ();
    classStartFlowTemplate.getSubflows ().add (subflowTemplate);

  }

  public void initClassLocationStep () {
    classLocationStep = new StepTemplate ();
    classLocationStep.setFinalStep (false);
    classLocationStep.setOperator (new Person ());
    classLocationStep.setStartStep (true);
    classLocationStep.setValidated (false);
  }

  public void initGheyasCodeStep () {
    gheyasCodeStep = new StepTemplate ();
    gheyasCodeStep.setFinalStep (false);
    gheyasCodeStep.setOperator (new Person ());
    gheyasCodeStep.setStartStep (false);
    gheyasCodeStep.setValidated (false);
  }

  public void initContactStudentsStep () {
    contactStudentsStep = new StepTemplate ();
    contactStudentsStep.setFinalStep (false);
    contactStudentsStep.setOperator (new Person ());
    contactStudentsStep.setStartStep (false);
    contactStudentsStep.setValidated (false);
  }

  public void initTeacherContractStep () {
    teacherContractStep = new StepTemplate ();
    teacherContractStep.setFinalStep (false);
    teacherContractStep.setOperator (new Person ());
    teacherContractStep.setStartStep (false);
    teacherContractStep.setValidated (false);
  }

  public void initUpdateWebsiteStep () {
    updateWebsiteStep = new StepTemplate ();
    updateWebsiteStep.setFinalStep (false);
    updateWebsiteStep.setOperator (new Person ());
    updateWebsiteStep.setStartStep (false);
    updateWebsiteStep.setValidated (false);
  }

  public void initFeedbackDateStep () {
    feedbackDateStep = new StepTemplate ();
    feedbackDateStep.setFinalStep (false);
    feedbackDateStep.setOperator (new Person ());
    feedbackDateStep.setStartStep (false);
    feedbackDateStep.setValidated (false);
  }

  public void initCheckFinancialStatusStep () {
    checkFinancialStatusStep = new StepTemplate ();
    checkFinancialStatusStep.setFinalStep (false);
    checkFinancialStatusStep.setOperator (new Person ());
    checkFinancialStatusStep.setStartStep (false);
    checkFinancialStatusStep.setValidated (false);
  }

  public void initDefineInCenterStep () {
    defineInCenterStep = new StepTemplate ();
    defineInCenterStep.setFinalStep (false);
    defineInCenterStep.setOperator (new Person ());
    defineInCenterStep.setStartStep (false);
    defineInCenterStep.setValidated (false);
  }
}
