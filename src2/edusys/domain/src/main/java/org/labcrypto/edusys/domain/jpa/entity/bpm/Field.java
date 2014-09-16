package org.labcrypto.edusys.domain.jpa.entity.bpm;

import javax.persistence.*;


@Entity
@Table (name = "field", schema = "bpm")
public class Field {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

}
