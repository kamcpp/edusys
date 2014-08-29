package org.labcrypto.edusys.domain.pg.entity.bpm.template;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "subflow_template", schema = "bpm")
public class SubflowTemplate {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne (fetch = FetchType.EAGER)
  private FlowTemplate flow;

  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "step_template_field_template", schema = "bpm", joinColumns = {@JoinColumn (name = "step_template_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "field_template_id", nullable = false)})
  private Set < FieldTemplate > fields;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public FlowTemplate getFlow () {
    return flow;
  }

  public void setFlow (FlowTemplate flow) {
    this.flow = flow;
  }

  public Set < FieldTemplate > getFields () {
    return fields;
  }

  public void setFields (Set < FieldTemplate > fields) {
    this.fields = fields;
  }
}
