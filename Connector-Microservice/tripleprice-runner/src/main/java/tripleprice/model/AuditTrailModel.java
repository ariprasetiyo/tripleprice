
package tripleprice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import tripleprice.ref.ActionType;

@Entity
@Table(name ="sys_audit_trail")
public class AuditTrailModel extends ModelEntity {
    
	private static final long serialVersionUID = 2432434267482377275L;
	
	@Column(name = "action_type")
    ActionType actionType;
    
    
}
