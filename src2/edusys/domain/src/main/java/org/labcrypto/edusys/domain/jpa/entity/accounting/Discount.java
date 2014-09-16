package org.labcrypto.edusys.domain.jpa.entity.accounting;

import javax.persistence.*;


@Entity
@Table (name = "discount", schema = "education")
public class Discount {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  
}
