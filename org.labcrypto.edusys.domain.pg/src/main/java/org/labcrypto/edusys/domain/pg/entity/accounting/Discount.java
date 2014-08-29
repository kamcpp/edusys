package org.labcrypto.edusys.domain.pg.entity.accounting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "discount", schema = "education")
public class Discount {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  
}
