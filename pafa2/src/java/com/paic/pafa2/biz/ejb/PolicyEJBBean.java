package java.com.paic.pafa2.biz.ejb;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.paic.pafa.logging2.Level;
import com.paic.pafa.logging2.LogManager;
import com.paic.pafa.logging2.Logger;
import com.paic.pafa.logging2.LoggingException;
import com.paic.pafa2.common.PafaDTO;
import com.paic.pafa2.common.PafaBusinessException;
import com.paic.pafa2.integration.dao.Messages;
import com.paic.pafa2.integration.dao.PolicyDAO;

/**
 * XDoclet-based session bean. The class must be declared public according to
 * the EJB specification.
 * 
 * To generate the EJB related files to this EJB: - Add Standard EJB module to
 * XDoclet project properties - Customize XDoclet configuration for your
 * appserver - Run XDoclet
 * 
 * Below are the xdoclet-related tags needed for this EJB.
 * 
 * @ejb.bean name="PolicyEJB" display-name="Name for PolicyEJB"
 *           description="Description for PolicyEJB" 
 *           jndi-name="ejb/PolicyEJB"
 *           type="Stateless" view-type="remote"
 */
public class PolicyEJBBean implements SessionBean {

	/** The session context */
	private SessionContext context;

	public PolicyEJBBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * Set the associated session context. The container calls this method after
	 * the instance creation.
	 * 
	 * The enterprise bean instance should store the reference to the context
	 * object in an instance variable.
	 * 
	 * This method is called with no transaction context.
	 * 
	 * @throws EJBException
	 *             Thrown if method fails due to system-level error.
	 */
	public void setSessionContext(SessionContext newContext)
			throws EJBException {
		context = newContext;
	}

	/**
	 * An example business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 * 
	 * @throws EJBException
	 *             Thrown if method fails due to system-level error.
	 */
	public boolean insert(PafaDTO dto) throws EJBException,
			PafaBusinessException {

		PolicyDAO dao = new PolicyDAO();
		try {
			dao.insert(dto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * An example business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 * 
	 * @throws EJBException
	 *             Thrown if method fails due to system-level error.
	 */
	public PafaDTO query(PafaDTO dto,String queryKey) throws EJBException,
			PafaBusinessException {
		PolicyDAO dao = new PolicyDAO();
		PafaDTO result = null;
		try {
			result = dao.query(dto,queryKey);
			if (result.getVarValue(queryKey) == null) {
				throw new PafaBusinessException("Not found the Client!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * An example business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 * 
	 * @throws EJBException
	 *             Thrown if method fails due to system-level error.
	 */
	public boolean update(PafaDTO dto,String updateKey) throws EJBException,
			PafaBusinessException {

		PolicyDAO dao = new PolicyDAO();
		try {
			dao.update(dto,updateKey);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * An example business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 * 
	 * @throws EJBException
	 *             Thrown if method fails due to system-level error.
	 */
	public int delete(PafaDTO dto,String deleteKey) throws EJBException,
			PafaBusinessException {
		PolicyDAO dao = new PolicyDAO();
		try {
			int lines = dao.delete(dto,deleteKey);
			return lines;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
