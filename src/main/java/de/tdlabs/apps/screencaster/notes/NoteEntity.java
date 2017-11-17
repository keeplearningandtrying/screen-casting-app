package de.tdlabs.apps.screencaster.notes;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "note")
@EntityListeners(AuditingEntityListener.class)
public class NoteEntity extends AbstractPersistable<Long> {

  @NotEmpty
  @Column(length = 64000)
  String text;

  @NotEmpty
  @Column(length = 64000)
  String html;

  @CreatedDate
  LocalDateTime createdAt;

  @LastModifiedDate
  LocalDateTime updatedAt;

  @Version
  Long version;

  public static NoteEntity valueOf(Note note) {
    NoteEntity ne = new NoteEntity();
    ne.setText(note.getText());
    return ne;
  }

  public Note toNote() {

    Note n = new Note();
    n.setText(getText());
    n.setHtml(this.html);
    n.setId(getId());
    n.setCreatedAt(getCreatedAt());
    n.setUpdatedAt(getUpdatedAt());

    return n;
  }
}