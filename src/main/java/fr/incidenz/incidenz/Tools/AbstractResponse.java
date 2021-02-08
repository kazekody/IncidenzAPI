package fr.incidenz.incidenz.Tools;

import java.io.Serializable;

public abstract class AbstractResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String sessionId;
	/**
	 * Determine le contexte d'execution du service sollicite (adresse du service + parametres d'entree)
	 */
	protected String context;
	/**
	 * Identifiant de la transaction
	 */
	protected String trxId = "0";
	/**
	 * Determine si la transaction s'est correctement executee
	 */
	protected boolean success = true;
	/**
	 * Determine si l'execution de la transaction a leve une exception
	 */
	protected boolean failure = false;
	/**
	 * Code de l'exception levee
	 */
	protected String errorCode = "0";
	/**
	 * Valeur retournee par le service
	 */
	protected Object returnValue;
	/**
	 * Type de donnees retourne
	 */
	protected String returnType;
	/**
	 * Message
	 */
	protected String returnMsg = "success";

	/**
	 * Default Constructor
	 */
	public AbstractResponse() {}

	/**
	 * @param sessionId Identifiant de session
	 * @param context Contexte d'execution 
	 * @param trxId N� de transaction
	 * @param success Succes de la transaction (true/false)
	 * @param failure Echec de la transaction (true/false)
	 * @param errorCode Code de l'erreur
	 * @param returnValue Valeur retournee
	 * @param returnType Type de donnee retourne
	 * @param returnMsg Message d'erreur
	 */
	public AbstractResponse(String sessionId, String context, String trxId, boolean success, boolean failure,
			String errorCode, Object returnValue, String returnType, String returnMsg) {
		super();
		this.sessionId = sessionId;
		this.context = context;
		this.trxId = trxId;
		this.success = success;
		this.failure = failure;
		this.errorCode = errorCode;
		this.returnValue = returnValue;
		this.returnType = returnType;
		this.returnMsg = returnMsg;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @return the trxId
	 */
	public String getTrxId() {
		return trxId;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return the failure
	 */
	public boolean isFailure() {
		return failure;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the returnValue
	 */
	public Object getReturnValue() {
		return returnValue;
	}

	/**
	 * @return the returnType
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * @return the returnMsg
	 */
	public String getReturnMsg() {
		return returnMsg;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @param trxId the trxId to set
	 */
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
		this.failure = !success;
		this.errorCode = this.success ? "0" : this.errorCode;
		this.returnMsg = this.success ? "success" : "failure";
	}

	/**
	 * @param failure the failure to set
	 *
	public void setFailure(boolean failure) {
		this.failure = failure;
		this.success = !failure;
		this.errorCode = this.success ? "0" : this.errorCode;
		this.returnMsg = this.success ? "success" : "failure";
	}*/

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		//if(this.errorCode != null && !this.errorCode.isEmpty()) setFailure(true);
		//this.returnMsg = errorCode;
	}

	/**
	 * @param returnValue the returnValue to set
	 */
	public void setReturnValue(Object returnValue) {
		this.returnValue = returnValue;
		this.returnType = this.returnValue != null ? this.returnValue.getClass().getName() : null;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	/**
	 * @param returnMsg the returnMsg to set
	 */
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
}
