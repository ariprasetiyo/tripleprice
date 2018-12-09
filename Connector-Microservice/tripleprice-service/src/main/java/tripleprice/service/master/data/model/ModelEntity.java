package tripleprice.service.master.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author ari.prasetiyo
 */

@MappedSuperclass
public class ModelEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="id")
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, name = "created_time", insertable = true, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	// @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private Date createdTime;// = new Date();

	/**
	 * PostgreSQL not support ON UPDATE CURRENT_TIMESTAMP
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, name = "modified_time", insertable = false, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private Date modifiedTime; // = new Date();

	@Column(length = 5)
	private String version = "1.0";

	private boolean disabled = false;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "modified_by")
	private long modifiedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	@PrePersist
	public void setCreatedTime() {
		this.createdTime = new Date();
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	@PreUpdate
	public void setModifiedTime() {
		this.modifiedTime = new Date();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
