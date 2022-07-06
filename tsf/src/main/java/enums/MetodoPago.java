package enums;

public enum MetodoPago {
	EFECTIVO("Efectivo"), TARJETA("Tarjeta"), TRANSFERENCIA("Transferencia"), PREMIO_PADEL("Premio Padel"), PREMIO_BIWENGER("Biwenger");
	
	private String metodoAsWord;
	
	private MetodoPago(String metodoAsWord) {
		this.metodoAsWord = metodoAsWord;
	}
	
	public String getMetodoPagoAsWord() {
		return this.metodoAsWord;
	}

//	  /**
//	   * Convert word to MetodoPago enum.
//	   *
//	   * @param word the word
//	   * @return the metodo pago
//	   */
//	  public MetodoPago convertWordToMetodoPago(String word) {
//	    switch (word.toUpperCase()) {
//	      case "EFECTIVO":
//	        return EFECTIVO;
//	      case "TARJETA":
//	        return TARJETA;
//	      case "TRANSFERENCIA":
//	        return TRANSFERENCIA;
//	      case "PREMIO_PADEL":
//	        return PREMIO_PADEL;
//	      case "PREMIO_BIWENGER":
//	    	  return PREMIO_BIWENGER;
//	      default:
//	        return null;
//	    }
//	  }
}
