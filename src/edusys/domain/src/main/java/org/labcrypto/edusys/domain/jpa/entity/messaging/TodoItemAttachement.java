package org.labcrypto.edusys.domain.jpa.entity.messaging;

import org.labcrypto.edusys.domain.jpa.DomainConstants;

import javax.persistence.*;


@Entity
@Table (name = "todo_item_attachement", schema = "messaging")
public class TodoItemAttachement {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @Column (name = "length", nullable = false)
  private int length;
  @Column (name = "submit_datetime", nullable = false)
  private long submitDateTime;
  @Column (name = "data", nullable = true)
  private byte[] data;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "todo_item_id", nullable = false)
  private TodoItem todoItem;

}
