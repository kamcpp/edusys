package org.labcrypto.edusys.domain.pg.entity.bpm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "field", schema = "bpm")
public class Field {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

}
