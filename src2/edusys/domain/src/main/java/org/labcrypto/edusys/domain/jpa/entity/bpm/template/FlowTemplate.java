package org.labcrypto.edusys.domain.jpa.entity.bpm.template;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "flow_template", schema = "bpm")
public class FlowTemplate {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany (fetch = FetchType.EAGER, mappedBy = "flow")
  private List < SubflowTemplate > subflows;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public List < SubflowTemplate > getSubflows () {
    if (subflows == null) {
      subflows = new ArrayList < SubflowTemplate > ();
    }
    return subflows;
  }

  public void setSubflows (List < SubflowTemplate > subflows) {
    this.subflows = subflows;
  }
}
