
package tripleprice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import tripleprice.ref.ActionType;
import tripleprice.service.master.data.model.ModelEntity;

@Entity
@Table(name = "sys_audit_trail")
public class AuditTrailModel extends ModelEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "action_type")
	ActionType actionType;

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

}
