package article.example.example.models;
// Generated Mar 31, 2023, 8:08:50 AM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Posts generated by hbm2java
 */
@Entity
@Table(name = "posts", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class Posts implements java.io.Serializable {

	private long id;
	private String title;
	private String content;
	private String category;
	private Date createdDate;
	private Date updatedDate;
	private String status;

	public Posts() {
	}

	public Posts(long id) {
		this.id = id;
	}

	public Posts(long id, String title, String content, String category, Date createdDate, Date updatedDate,
			String status) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_seq_posts")
	@SequenceGenerator(name = "generator_seq_posts", sequenceName = "posts_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "title", length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "category", length = 100)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 29, nullable = false, updatable = false)
	@CreatedDate
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 29, nullable = false)
	@LastModifiedDate
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "status", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
