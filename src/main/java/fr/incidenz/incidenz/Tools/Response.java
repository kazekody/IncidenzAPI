package fr.incidenz.incidenz.Tools;

public class Response extends AbstractResponse{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected Integer nbPages = 1;
	

//	public Response() {
//		this.sessionId = FintechApiClientHelper.sessionId;
//	}

	/**
	 * @param sessionId Id de Session
	 * @param context Contexte d'execution
	 * @param trxId Identifiant de la Transaction
	 * @param success Transaction executee avec succes (true/false)
	 * @param failure Transaction Echouee ? (true/false)
	 * @param errorCode Message de l'exception levee
	 * @param returnValue Valeur retourne (Object)
	 * @param returnType Type de donnee de l'objet Retourne
	 * @param returnMsg Trace de l'exception levee
	 */
	public Response(String sessionId, String context, String trxId, boolean success, boolean failure, String errorCode,
			String returnValue, String returnType, String returnMsg) {
		super(sessionId, context, trxId, success, failure, errorCode, returnValue, returnType, returnMsg);
	}
	public Response() {
		super();
		
	}

	
	/**
	 * @return the nbPages
	 */
	public Integer getNbPages() {
		return nbPages;
	}

	/**
	 * @param nbPages the nbPages to set
	 */
	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	/**
	 * Met a jour les infos de la reponse en fonction l'exception passee en parametre
	 * @param ex
//	 */
//	public void theatException(Exception ex) {
//		if(ex == null) return;
//		this.setSuccess(false);
//		this.errorCode = ex.getMessage() != null ? ex.getMessage().replaceFirst("java.lang.RuntimeException:", "").trim() : "-1";
//		String msg = Multilangue.getMessage(errorCode, null, this.getClass().getClassLoader());
//		if(ex instanceof AbstractException || !this.errorCode.equals(msg)) this.returnMsg = msg ;
//		else {
//			this.errorCode = "BankServerError";
//			this.returnMsg = "Unable to access Bank Services! Please, contact support.";
//		}
//		ex.printStackTrace();
//	}

	
//	public void theatException(Exception ex, Language lang) {
//		if(ex == null) return;
//		this.setSuccess(false);
//		this.errorCode = ex.getMessage() != null ? ex.getMessage().replaceFirst("java.lang.RuntimeException:", "").trim() : "-1";
//		String msg = Multilangue.getMessage(errorCode, null, this.getClass().getClassLoader());
//		if(ex instanceof AbstractException || !this.errorCode.equals(msg)) this.returnMsg = msg;
//		else {
//			this.errorCode = "BankServerError";
//			this.returnMsg = "Unable to access Bank Services! Please, contact support.";
//		}
//		ex.printStackTrace();
//	}

	
	
	@Override
	public String toString() {
		return "Response [trxId=" + trxId + ", success=" + success + ", errorCode=" + errorCode + ", returnValue="
				+ returnValue + ", returnType=" + returnType + ", returnMsg=" + returnMsg + "]";
	}



}
