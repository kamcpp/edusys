package org.labcrypto.edusys.domain.jpa.entity.bpm.template;

import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "step_template", schema = "bpm")
public class StepTemplate {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @Column (name = "validated", nullable = false)
  private boolean validated;

  @Column (name = "start_step", nullable = false)
  private boolean startStep;

  @Column (name = "final_step", nullable = false)
  private boolean finalStep;

  @ManyToOne (fetch = FetchType.EAGER)
  private Person operator;

  @ManyToOne (fetch = FetchType.EAGER)
  private StepTemplate previousStep;

  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "step_template_next_step_template", schema = "bpm", joinColumns = {@JoinColumn (name = "step_template_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "next_step_template_id", nullable = false)})
  private List < StepTemplate > nextSteps;

  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "step_template_field_template", schema = "bpm", joinColumns = {@JoinColumn (name = "step_template_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "field_template_id", nullable = false)})
  private List < FieldTemplate > fields;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public boolean isValidated () {
    return validated;
  }

  public void setValidated (boolean validated) {
    this.validated = validated;
  }

  public boolean isStartStep () {
    return startStep;
  }

  public void setStartStep (boolean startStep) {
    this.startStep = startStep;
  }

  public boolean isFinalStep () {
    return finalStep;
  }

  public void setFinalStep (boolean finalStep) {
    this.finalStep = finalStep;
  }

  public Person getOperator () {
    return operator;
  }

  public void setOperator (Person operator) {
    this.operator = operator;
  }

  public StepTemplate getPreviousStep () {
    return previousStep;
  }

  public void setPreviousStep (StepTemplate previousStep) {
    this.previousStep = previousStep;
  }

  public List < StepTemplate > getNextSteps () {
    return nextSteps;
  }

  public void setNextSteps (List < StepTemplate > nextSteps) {
    this.nextSteps = nextSteps;
  }

  public List < FieldTemplate > getFields () {
    if (fields == null) {
      fields = new ArrayList < FieldTemplate > ();
    }
    return fields;
  }

  public void setFields (List < FieldTemplate > fields) {
    this.fields = fields;
  }
}
