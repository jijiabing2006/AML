package com.lzsoft.aml.local;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 */
public class MyPhaseListener implements PhaseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Override
	public void afterPhase(PhaseEvent pe) {
	}

	/**
	 * 
	 */
	@Override
	public void beforePhase(PhaseEvent pe) {
		//
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		Locale myLocale = (Locale) request.getSession().getAttribute("myLocale");

		if (myLocale != null) {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);
		}
	}

	/**
	 * 
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
}