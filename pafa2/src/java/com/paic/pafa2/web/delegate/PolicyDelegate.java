package com.paic.pafa2.web.delegate;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.ejb.CreateException;
import javax.servlet.http.HttpServletRequest;

import com.paic.pafa.framework.delegate.Delegate;
import com.paic.pafa.framework.servicelocator.LocatorManager;
import com.paic.pafa.framework.servicelocator.ServiceLocator;
import com.paic.pafa.framework.servicelocator.ServiceLocatorException;

import com.paic.pafa2.biz.interfaces.PolicyEJB;
import com.paic.pafa2.biz.interfaces.PolicyEJBHome;
import com.paic.pafa2.common.PafaDTO;
import com.paic.pafa2.common.PafaBusinessException;

public class PolicyDelegate extends Delegate {
	private ServiceLocator locator;

	private LocatorManager manager;

	private PolicyEJBHome home;

	public void insert(HttpServletRequest request) throws PafaBusinessException {
		boolean inserted = true;

		Map paramMap = request.getParameterMap();
		int size = paramMap.size();
		System.out.println(size);
		PafaDTO dto = new PafaDTO(size);
		Set params = paramMap.entrySet();
		int i = 0;
		for (Iterator it = params.iterator(); it.hasNext(); i++) {
			Entry param = (Entry) it.next();
			String name = (String) param.getKey();
			String value = ((String[]) param.getValue())[0];
			dto.setVarName(i, name);
			dto.setVarValue(i, value);
		}
		
		System.out.println("" + i);
		// insert
		this.home = this.getHome();
		try {
			PolicyEJB pafaEJB = this.home.create();
			inserted = pafaEJB.insert(dto);
		} catch (RemoteException e) {
		} catch (CreateException e) {
		} catch (PafaBusinessException e) {
			throw e;
		}
		request.setAttribute("inserted", "" + inserted); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void query(HttpServletRequest request) throws PafaBusinessException {
		Map paramMap = request.getParameterMap();
		int size = paramMap.size();
		System.out.println(size);
		PafaDTO dto = new PafaDTO(size);
		Set params = paramMap.entrySet();
		int j = 0;
		for (Iterator it = params.iterator(); it.hasNext(); j++) {
			Entry param = (Entry) it.next();
			String name = (String) param.getKey();
			String value = ((String[]) param.getValue())[0];
			dto.setVarName(j, name);
			dto.setVarValue(j, value);
		}

		this.home = this.getHome();
		PolicyEJB pafaEJB;
		try {
			pafaEJB = this.home.create();
			PafaDTO result = pafaEJB.query(dto, Messages
					.getString("MyDelegate.queryKey"));
			for (int i = 0; i < dto.getVarAmount(); i++) {
				request.setAttribute("" + result.getVarName(i), result
						.getVarValue(i));
			}
		} catch (RemoteException e) {
		} catch (CreateException e) {
		} catch (PafaBusinessException e) {
			throw e;
		}
	}

	public void QueryBeforeUpdate(HttpServletRequest request)
			throws PafaBusinessException {
		Map paramMap = request.getParameterMap();
		int size = paramMap.size();
		System.out.println(size);
		PafaDTO dto = new PafaDTO(size);
		Set params = paramMap.entrySet();
		int j = 0;
		for (Iterator it = params.iterator(); it.hasNext(); j++) {
			Entry param = (Entry) it.next();
			String name = (String) param.getKey();
			String value = ((String[]) param.getValue())[0];
			dto.setVarName(j, name);
			dto.setVarValue(j, value);
		}
		this.home = this.getHome();
		PolicyEJB pafaEJB;
		try {
			pafaEJB = this.home.create();
			PafaDTO result = pafaEJB.query(dto, Messages
					.getString("MyDelegate.queryKey"));
			for (int i = 0; i < dto.getVarAmount(); i++) {
				request.setAttribute("" + result.getVarName(i), result
						.getVarValue(i));
			}

		} catch (RemoteException e) {
		} catch (CreateException e) {
		} catch (PafaBusinessException e) {
			throw e;
		}
		request.setAttribute("updating", "true");
	}

	public void update(HttpServletRequest request) throws PafaBusinessException {
		boolean updated = true;
		Map paramMap = request.getParameterMap();
		int size = paramMap.size();
		System.out.println(size);
		PafaDTO dto = new PafaDTO(size);
		Set params = paramMap.entrySet();
		int i = 0;
		for (Iterator it = params.iterator(); it.hasNext(); i++) {
			Entry param = (Entry) it.next();
			String name = (String) param.getKey();
			String value = ((String[]) param.getValue())[0];
			dto.setVarName(i, name);
			dto.setVarValue(i, value);
		}

		System.out.println("" + i);
		// insert
		this.home = this.getHome();
		try {
			PolicyEJB pafaEJB = this.home.create();
			updated = pafaEJB.update(dto, Messages
					.getString("MyDelegate.queryKey"));
		} catch (RemoteException e) {
		} catch (CreateException e) {
		} catch (PafaBusinessException e) {
			throw e;
		}
		request.setAttribute("updated", "" + updated); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void delete(HttpServletRequest request) throws PafaBusinessException {
		int deleted = 0;

		Map paramMap = request.getParameterMap();
		int size = paramMap.size();
		System.out.println(size);
		PafaDTO dto = new PafaDTO(size);
		Set params = paramMap.entrySet();
		int j = 0;
		for (Iterator it = params.iterator(); it.hasNext(); j++) {
			Entry param = (Entry) it.next();
			String name = (String) param.getKey();
			String value = ((String[]) param.getValue())[0];
			dto.setVarName(j, name);
			dto.setVarValue(j, value);
		}
		this.home = this.getHome();
		PolicyEJB pafaEJB;
		try {
			pafaEJB = this.home.create();
			deleted = pafaEJB.delete(dto, Messages
					.getString("MyDelegate.queryKey"));
		} catch (RemoteException e) {
		} catch (CreateException e) {
		} catch (PafaBusinessException e) {
			throw e;
		}
		request.setAttribute("deleted", "" + deleted); //$NON-NLS-1$ //$NON-NLS-2$

	}

	private PolicyEJBHome getHome() {
		PolicyEJBHome PafaEJBHome = null;
		try {
			this.manager = LocatorManager.getLocatorManager();
			this.locator = manager.getLocator(Messages
					.getString("MyDelegate.jndi")); //$NON-NLS-1$
			System.out.println("*****************************"); //$NON-NLS-1$
			System.out.println(locator.toString());
			System.out.println("*****************************"); //$NON-NLS-1$
			PafaEJBHome = (PolicyEJBHome) locator.getRemoteHome(Messages
					.getString("MyDelegate.ejb"), PolicyEJBHome.class); //$NON-NLS-1$
		} catch (ServiceLocatorException se) {
			se.printStackTrace();
			System.out.println("wrong in se!"); //$NON-NLS-1$
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("wrong in ee!"); //$NON-NLS-1$
		}
		return PafaEJBHome;
	}

	private void executeRules(PafaDTO dto) throws PafaBusinessException {

		String linestr = RuleManager.getString("EJB.ruleNumber");
		int line = Integer.parseInt(linestr);
		String insertRules[] = new String[line];

		for (int i = 0; i < line; i++) {
			insertRules[i] = RuleManager.getString("EJB.insertRule[" + i + "]");
			StringTokenizer st = new StringTokenizer(insertRules[i], ":");
			String name = st.nextToken();
			int value = Integer.parseInt(dto.getVarValue(name));
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			if (value < min || value > max) {
				throw new PafaBusinessException(value + "<" + min + " or "
						+ value + ">" + max);
			}

		}

	}
}
